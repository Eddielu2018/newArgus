package cn.htd.argus.dto;

import java.io.Serializable;

public class VmsConverMemberInfoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 277412334101453544L;
	
	private String name;
	private Integer value;
	private Integer storeNum;
	private String coverageRate;
	private String contribution;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(Integer storeNum) {
		this.storeNum = storeNum;
	}
	public String getCoverageRate() {
		return coverageRate;
	}
	public void setCoverageRate(String coverageRate) {
		this.coverageRate = coverageRate;
	}
	public String getContribution() {
		return contribution;
	}
	public void setContribution(String contribution) {
		this.contribution = contribution;
	}
	

}
