package cn.htd.argus.dto;

import java.io.Serializable;

public class VmsConverMemberDetailDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1135685372867005282L;
	
	private String name;
	private String[] position=new String[2];
	private Integer storeNum;
	private String coverageRate;
	private String contribution;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getPosition() {
		return position;
	}
	public void setPosition(String[] position) {
		this.position = position;
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
