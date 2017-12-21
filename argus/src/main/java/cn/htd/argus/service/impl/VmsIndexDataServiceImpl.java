package cn.htd.argus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

import cn.htd.argus.dto.HtyFctHomePageOrg;
import cn.htd.argus.dto.HtyFctMemberStockOrg;
import cn.htd.argus.mappers.HtyFctHomePageOrgMapper;
import cn.htd.argus.mappers.HtyFctMemberStockOrgMapper;
import cn.htd.argus.service.VmsIndexDataService;
import cn.htd.common.Pager;

public class VmsIndexDataServiceImpl implements VmsIndexDataService{
	
	@Resource
	private HtyFctMemberStockOrgMapper htyFctMemberStockOrgMapper;
	@Resource
	private HtyFctHomePageOrgMapper htyFctHomePageOrgMapper;
	
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
			Integer pageSize, Integer pageNo) {
		logger.info("VmsIndexDataServiceImpl::queryPagedHtyFctMemberStock:enter...");
		Map<String, Object> resultMap=Maps.newHashMap();
		try{
			Pager pager=new Pager();
			pager.setRows(pageSize);
			pager.setPageOffset((pageNo-1)*pageSize);
			Long total=htyFctMemberStockOrgMapper.queryTotalHtyFctMemberStockByCompanyCode(companyCode);
			if(total==null||total<=0){
				resultMap.put("code", "0");
				resultMap.put("msg", "没有查到数据");
			}
			List<HtyFctMemberStockOrg> resulltList=htyFctMemberStockOrgMapper.queryPagedHtyFctMemberStockByCompanyCode(companyCode,pager);
			resultMap.put("code", "1");
			resultMap.put("data", resulltList);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("VmsIndexDataServiceImpl::queryPagedHtyFctMemberStock:"+e);
		}
		return resultMap;
	}

}
