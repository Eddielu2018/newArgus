package cn.htd.argus.dto;

import java.io.Serializable;

public class HtyFctMemberStockOrgDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5983807548862274187L;
	
	private String thirdLevelCatName;
	private String thirdLevelCatCode;
	private Integer storeNum;
	public String getThirdLevelCatName() {
		return thirdLevelCatName;
	}
	public void setThirdLevelCatName(String thirdLevelCatName) {
		this.thirdLevelCatName = thirdLevelCatName;
	}
	public String getThirdLevelCatCode() {
		return thirdLevelCatCode;
	}
	public void setThirdLevelCatCode(String thirdLevelCatCode) {
		this.thirdLevelCatCode = thirdLevelCatCode;
	}
	public Integer getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(Integer storeNum) {
		this.storeNum = storeNum;
	}
	
}
