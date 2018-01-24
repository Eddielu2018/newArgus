package cn.htd.argus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cn.htd.argus.dto.HtyFctHomePageCust;
import cn.htd.argus.dto.HtyFctHomePageLvl;
import cn.htd.argus.dto.HtyFctHomePageOrg;
import cn.htd.argus.dto.HtyFctHomePageTown;
import cn.htd.argus.dto.HtyFctMemberStockOrg;
import cn.htd.argus.dto.HtyFctMemberStockOrgDTO;
import cn.htd.argus.dto.VmsConverMemberDetailDTO;
import cn.htd.argus.dto.VmsConverMemberInfoDTO;
import cn.htd.argus.mappers.HtyFctHomePageCustMapper;
import cn.htd.argus.mappers.HtyFctHomePageLvlMapper;
import cn.htd.argus.mappers.HtyFctHomePageOrgMapper;
import cn.htd.argus.mappers.HtyFctHomePageTownMapper;
import cn.htd.argus.mappers.HtyFctMemberStockOrgMapper;
import cn.htd.argus.service.VmsIndexDataService;
import cn.htd.common.Pager;

public class VmsIndexDataServiceImpl implements VmsIndexDataService{
	
	@Resource
	private HtyFctMemberStockOrgMapper htyFctMemberStockOrgMapper;
	@Resource
	private HtyFctHomePageOrgMapper htyFctHomePageOrgMapper;
	@Resource
	private HtyFctHomePageTownMapper htyFctHomePageTownMapper;
	@Resource
	private HtyFctHomePageCustMapper htyFctHomePageCustMapper;
	@Resource
	private HtyFctHomePageLvlMapper htyFctHomePageLvlMapper;
	
	private Logger logger = LoggerFactory.getLogger(VmsIndexDataServiceImpl.class);
	 
	@Override
	public Map<String, Object> queryVmsIndexData(String companyCode) {
		Map<String, Object> resultMap=Maps.newHashMap();
		HtyFctHomePageOrg basicData=htyFctHomePageOrgMapper.selectHtyFctHomePageByComCode(companyCode);
		resultMap.put("basicData", basicData);
		return resultMap;
	}

	@Override
	public Map<String, Object> queryPagedHtyFctMemberStock(String companyCode,
			Integer pageSize, Integer pageNo,String searchWord) {
		logger.info("VmsIndexDataServiceImpl::queryPagedHtyFctMemberStock:enter...");
		Map<String, Object> resultMap=Maps.newHashMap();
		try{
			Pager pager=new Pager();
			pager.setRows(pageSize);
			pager.setPage(pageNo);
			pager.setPageOffset((pageNo-1)*pageSize);
			Long total=htyFctMemberStockOrgMapper.queryTotalHtyFctMemberStockByCompanyCode(companyCode,searchWord);
			if(total==null||total<=0){
				resultMap.put("code", "0");
				resultMap.put("msg", "没有查到数据");
			}
			List<HtyFctMemberStockOrg> resulltList=htyFctMemberStockOrgMapper.queryPagedHtyFctMemberStockByCompanyCode(companyCode,pager,searchWord);
			resultMap.put("code", "1");
			resultMap.put("total", total+"");
			resultMap.put("data", resulltList);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("VmsIndexDataServiceImpl::queryPagedHtyFctMemberStock:"+e);
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> queryAreaContributionData(String companyCode,String cityCode) {
		Map<String, Object> resultMap=Maps.newHashMap();
		try{
			//查询
			List<HtyFctHomePageTown> areaContriList=htyFctHomePageTownMapper.selectHtyHomepageTownInfo(companyCode, cityCode);
			if(CollectionUtils.isNotEmpty(areaContriList)){
				List<String> pkKeyTownList=Lists.newArrayList();
				List<VmsConverMemberInfoDTO> vmsConverMemberInfoDTOList=Lists.newArrayList();
				for(HtyFctHomePageTown htyFctHomePageTown:areaContriList){
					//数据转换
					VmsConverMemberInfoDTO tempVmsConverMemberInfoDTO=new VmsConverMemberInfoDTO();
					if(htyFctHomePageTown.getPurchaseAmt()!=null){
						tempVmsConverMemberInfoDTO.setContribution(htyFctHomePageTown.getPurchaseAmt());
					}
					if(htyFctHomePageTown.getCoverageRate()!=null){
						tempVmsConverMemberInfoDTO.setCoverageRate(htyFctHomePageTown.getCoverageRate());
					}
					
					tempVmsConverMemberInfoDTO.setName(htyFctHomePageTown.getAreaCountyname());
					if(htyFctHomePageTown.getCustNum()!=null&&StringUtils.isNumeric(htyFctHomePageTown.getCustNum())){
						tempVmsConverMemberInfoDTO.setStoreNum(Integer.parseInt(htyFctHomePageTown.getCustNum()));
					}
					tempVmsConverMemberInfoDTO.setValue(0);
					vmsConverMemberInfoDTOList.add(tempVmsConverMemberInfoDTO);
					pkKeyTownList.add(htyFctHomePageTown.getPkKeyTown());
				}
				
				resultMap.put("vmsConverMemberInfoDTOList", vmsConverMemberInfoDTOList);
				
				if(CollectionUtils.isNotEmpty(pkKeyTownList)){
					 List<HtyFctHomePageCust> htyFctHomePageCustList=htyFctHomePageCustMapper.selectHtyFctHomePageCustByTownPK(pkKeyTownList);
					 if(CollectionUtils.isNotEmpty(htyFctHomePageCustList)){
						List<VmsConverMemberDetailDTO> vmsConverMemberDetailDTOList=Lists.newArrayList();
						 for(HtyFctHomePageCust htyFctHomePageCust:htyFctHomePageCustList){
							 VmsConverMemberDetailDTO vmsConverMemberDetailDTO=new VmsConverMemberDetailDTO();
							 if(htyFctHomePageCust.getPurchaseAmtYear()!=null){
								 vmsConverMemberDetailDTO.setContribution(htyFctHomePageCust.getPurchaseAmtYear()+"");
							 }
							 String[] position=new String[2];
							 //会员店地址经度
							 if(htyFctHomePageCust.getOrgaddresslat()!=null){
								 position[0]=htyFctHomePageCust.getOrgaddresslat()+"";
							 }
							 //会员店地址纬度
							 if(htyFctHomePageCust.getOrgaddresslng()!=null){
								 position[1]=htyFctHomePageCust.getOrgaddresslng()+"";
							 }
							 
							 vmsConverMemberDetailDTO.setPosition(position);
							 vmsConverMemberDetailDTO.setCoverageRate("0");
							 vmsConverMemberDetailDTO.setName(htyFctHomePageCust.getCustName());
							 vmsConverMemberDetailDTO.setStoreNum(0);
							 
							 vmsConverMemberDetailDTOList.add(vmsConverMemberDetailDTO);
						 }
						 resultMap.put("vmsConverMemberDetailDTOList", vmsConverMemberDetailDTOList);
					 }
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("VmsIndexDataServiceImpl::queryAreaContributionData:"+e);
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> queryMemberPurchaseAmountData(
			String companyCode, Integer staticType, Integer orderType) {
		Map<String, Object> resultMap=Maps.newHashMap();
		if(StringUtils.isEmpty(companyCode)||staticType==null||orderType==null){
			return resultMap;
		}
		
		List<HtyFctHomePageLvl> htyFctHomePageLvlList=htyFctHomePageLvlMapper.selectHtyFctHomePageLvlByComCode(companyCode, staticType, orderType);
		
		if(CollectionUtils.isEmpty(htyFctHomePageLvlList)){
			return resultMap;
		}
		
		//会员店名字列表
		List<String> memberNameList=Lists.newArrayList();
		//当前销售数据
		List<String> currentStaticData=Lists.newArrayList();
		//相对销售数据
		List<String> relativeStaticData=Lists.newArrayList();
		for(HtyFctHomePageLvl htyFctHomePageLvl:htyFctHomePageLvlList){
			memberNameList.add(htyFctHomePageLvl.getCustName());
			//按照月度同比率
			if(1==staticType){
				if(htyFctHomePageLvl.getPurchaseAmtMon()!=null){
					currentStaticData.add(htyFctHomePageLvl.getPurchaseAmtMon().toString());
				}
				
				if(htyFctHomePageLvl.getPurchaseAmtLmon()!=null){
					relativeStaticData.add(htyFctHomePageLvl.getPurchaseAmtLmon().toString());
				}
				
			}
			//按照半年度同比率
			if(2==staticType){
				if(htyFctHomePageLvl.getPurchaseAmtMon6()!=null){
					currentStaticData.add(htyFctHomePageLvl.getPurchaseAmtMon6().toString());
				}
				
				if(htyFctHomePageLvl.getPurchaseAmtLmon6()!=null){
					relativeStaticData.add(htyFctHomePageLvl.getPurchaseAmtLmon6().toString());
				}
			}
			
			if(3==staticType){
				if(htyFctHomePageLvl.getPurchaseAmtYear()!=null){
					currentStaticData.add(htyFctHomePageLvl.getPurchaseAmtYear().toString());
				}
				
				if(htyFctHomePageLvl.getPurchaseAmtLyear()!=null){
					relativeStaticData.add(htyFctHomePageLvl.getPurchaseAmtLyear().toString());
				}
			}
			
		}
		resultMap.put("memberNameList", memberNameList);
		resultMap.put("currentStaticData", currentStaticData);
		resultMap.put("relativeStaticData", relativeStaticData);
		return resultMap;
	}

	@Override
	public Map<String, Object> queryMemberStockAnalysisData(String companyCode) {
		Map<String,Object> resultMap=Maps.newHashMap();
		if(StringUtils.isEmpty(companyCode)){
			return resultMap;
		}
		List<HtyFctMemberStockOrgDTO> htyFctMemberStockOrgDTOList=htyFctMemberStockOrgMapper.queryTopHtyFctMemberStockOrg(companyCode);
		
		if(CollectionUtils.isEmpty(htyFctMemberStockOrgDTOList)){
			return resultMap;
		}
		
		Long maxStock=htyFctMemberStockOrgMapper.queryMaxStockByHtyFctMemberStockOrg(companyCode);
		
		List<Map<String,Object>> memberStockList=Lists.newArrayList();
		
		List<Integer> catStockValueList=Lists.newArrayList();
		
		for(HtyFctMemberStockOrgDTO htyFctMemberStockOrgDTO:htyFctMemberStockOrgDTOList){
			Map<String,Object> data=Maps.newHashMap();
			data.put("text", htyFctMemberStockOrgDTO.getThirdLevelCatName());
			data.put("max", maxStock);
			
			memberStockList.add(data);
			
			catStockValueList.add(htyFctMemberStockOrgDTO.getStoreNum());
		}
		
		resultMap.put("memberStockList", memberStockList);
		resultMap.put("catStockValueList", catStockValueList);
		resultMap.put("topAllList", htyFctMemberStockOrgDTOList);
		return resultMap;
	}

}
