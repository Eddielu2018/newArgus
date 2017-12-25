package cn.htd.argus.service;

import java.util.Map;

public interface VmsIndexDataService {
	Map<String, Object> queryVmsIndexData(String companyCode);
	
	Map<String,Object> queryPagedHtyFctMemberStock(String companyCode,Integer pageSize,Integer pageNo);
	
	Map<String,Object> queryAreaContributionData(String companyCode,String cityCode);
}
