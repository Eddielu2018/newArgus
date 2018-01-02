package cn.htd.argus.service;

import java.util.Map;

public interface VmsIndexDataService {
	/**
	 * 查询VMS首页基础数据
	 * 
	 * @param companyCode
	 * @return
	 */
	Map<String, Object> queryVmsIndexData(String companyCode);
	
	/**
	 * 查询会员库存商品
	 * 
	 * @param companyCode
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	Map<String,Object> queryPagedHtyFctMemberStock(String companyCode,Integer pageSize,Integer pageNo,String searchWord);
	
	/**
	 * 查询区域贡献度数据
	 * 
	 * @param companyCode
	 * @param cityCode
	 * @return
	 */
	Map<String,Object> queryAreaContributionData(String companyCode,String cityCode);
	
	/**
	 * 查询会员店采购排名数据
	 * 
	 * @param companyCode
	 * @param staticType
	 * @param orderType
	 * @return
	 */
	Map<String,Object> queryMemberPurchaseAmountData(String companyCode,Integer staticType,Integer orderType);
	
	/**
	 * 
	 * 查询会员店库存分析
	 * 
	 * @param companyCode
	 * @return
	 */
	Map<String,Object> queryMemberStockAnalysisData(String companyCode);
}
