package cn.htd.argus.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

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
		vmsIndexDataService.queryVmsIndexData(companyCode);
		return vmsIndexDataService.queryPagedHtyFctMemberStock(companyCode, 10, 1);
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
		resultMap.put("msg", dataMap);
		return resultMap;
	}
}
