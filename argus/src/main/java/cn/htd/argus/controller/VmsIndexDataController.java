package cn.htd.argus.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

import cn.htd.argus.dto.QueryPagedMemStockDTO;
import cn.htd.argus.service.VmsIndexDataService;

@RestController
@RequestMapping("vmsindex")
public class VmsIndexDataController {
	@Resource
	private VmsIndexDataService vmsIndexDataService;
	
	/**
	 * 查询VMS首页基础数据
	 * 
	 * @param companyCode
	 * @return
	 */
	@RequestMapping("queryVMSIndexData")
	public Map<String,Object> queryVMSIndexData(@RequestParam("companyCode") String companyCode){
		Map<String,Object> resultMap=Maps.newHashMap();
		
		if(StringUtils.isEmpty(companyCode)){
			resultMap.put("code", "0");
			resultMap.put("msg", "companyCode为空");
			return resultMap;
		}
		
		Map<String,Object> dataMap=vmsIndexDataService.queryVmsIndexData(companyCode);
		
		if(MapUtils.isEmpty(dataMap)){
			resultMap.put("code", "0");
			resultMap.put("msg", "没有查到数据");
			return resultMap;
		}
		
		resultMap.put("code", "1");
		resultMap.put("data", dataMap);
		return resultMap;
	}
	
	@RequestMapping("queryPagedMemberStockData")
	public Map<String,Object> queryPagedMemberStockData(@RequestBody QueryPagedMemStockDTO queryPagedMemStockDTO){
		
		Map<String,Object> resultMap=Maps.newHashMap();
		
		if(StringUtils.isEmpty(queryPagedMemStockDTO.getCompanyCode())){
			resultMap.put("code", "0");
			resultMap.put("msg", "companyCode为空");
			return resultMap;
		}
		
		if(queryPagedMemStockDTO.getPageNo()==null||queryPagedMemStockDTO.getPageNo()<0){
			resultMap.put("code", "0");
			resultMap.put("msg", "pageNo为空");
			return resultMap;
		}
		
		if(queryPagedMemStockDTO.getPageSize()==null||queryPagedMemStockDTO.getPageSize()<0){
			resultMap.put("code", "0");
			resultMap.put("msg", "pageSize为空");
			return resultMap;
		}
		
		return vmsIndexDataService.queryPagedHtyFctMemberStock(queryPagedMemStockDTO.getCompanyCode(), queryPagedMemStockDTO.getPageSize(),queryPagedMemStockDTO.getPageNo(),queryPagedMemStockDTO.getMemberNameOrCode());
	}
	
	/**
	 * 查询区域贡献度数据
	 * 
	 * @param companyCode
	 * @param cityCode
	 * @return
	 */
	@RequestMapping("queryAreaContributionData")
	public Map<String,Object> queryAreaContributionData(@RequestParam("companyCode") String companyCode,@RequestParam("cityCode") String cityCode){
		
		Map<String,Object> resultMap=Maps.newHashMap();
		if(StringUtils.isEmpty(companyCode)){
			resultMap.put("code", "0");
			resultMap.put("msg", "companyCode为空");
			return resultMap;
		}
		
		if(StringUtils.isEmpty(cityCode)){
			resultMap.put("code", "0");
			resultMap.put("msg", "cityCode为空");
			return resultMap;
		}
		
		Map<String,Object> dataMap=vmsIndexDataService.queryAreaContributionData(companyCode, cityCode);
		
		if(MapUtils.isEmpty(dataMap)){
			resultMap.put("code", "0");
			resultMap.put("msg", "没有查到对应数据");
			return resultMap;
		}
		resultMap.put("code", "1");
		resultMap.put("data", dataMap);
		return resultMap;
	}
	
	/**
	 * 查询会员店采购上升排名数据
	 * 
	 * @param companyCode
	 * @param staticType
	 * @param orderType
	 * @return
	 */
	@RequestMapping("queryMemberPurchaseAmountData")
	public Map<String,Object> queryMemberPurchaseAmountData(@RequestParam("companyCode") String companyCode,
			@RequestParam("staticType") Integer staticType,@RequestParam("orderType") Integer orderType){
		Map<String,Object> resultMap=Maps.newHashMap();
		if(StringUtils.isEmpty(companyCode)){
			resultMap.put("code", "0");
			resultMap.put("msg", "companyCode为空");
			return resultMap;
		}
		
		if(staticType==null){
			resultMap.put("code", "0");
			resultMap.put("msg", "staticType为空");
			return resultMap;
		}
		
		if(staticType<0||staticType>3){
			resultMap.put("code", "0");
			resultMap.put("msg", "staticType不正确");
			return resultMap;
		}
		
		if(orderType==null){
			resultMap.put("code", "0");
			resultMap.put("msg", "orderType为空");
			return resultMap;
		}
		
		Map<String,Object> dataMap=vmsIndexDataService.queryMemberPurchaseAmountData(companyCode, staticType,orderType);
		
		if(MapUtils.isEmpty(dataMap)){
			resultMap.put("code", "0");
			resultMap.put("msg", "没有查到对应数据");
			return resultMap;
		}
		resultMap.put("code", "1");
		resultMap.put("data", dataMap);
		return resultMap;
	}
	
	/**
	 * 查询会员店库存分析数据
	 *  
	 * @param companyCode
	 * @return
	 */
	@RequestMapping("queryMemberStockAnalysisData")
	public Map<String,Object> queryMemberStockAnalysisData(@RequestParam("companyCode") String companyCode){
		Map<String,Object> resultMap=Maps.newHashMap();
		if(StringUtils.isEmpty(companyCode)){
			resultMap.put("code", "0");
			resultMap.put("msg", "companyCode为空");
			return resultMap;
		}
		
		Map<String,Object> dataMap=vmsIndexDataService.queryMemberStockAnalysisData(companyCode);
		
		resultMap.put("code", 1);
		resultMap.put("data", dataMap);
		
		return resultMap;
	}
}
