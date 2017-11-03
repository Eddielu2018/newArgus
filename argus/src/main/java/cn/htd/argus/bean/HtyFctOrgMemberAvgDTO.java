package cn.htd.argus.bean;

import java.util.List;

public class HtyFctOrgMemberAvgDTO {

	private Integer headSort;
	private Integer brachSort;
	private Integer memberNum;
	private Integer headAvgNum;
	private Integer brachAvgNum;
	private List<CompanySortDTO> headCompany;
	private List<CompanySortDTO> brachCompany;
	public Integer getHeadSort() {
		return headSort;
	}
	public void setHeadSort(Integer headSort) {
		this.headSort = headSort;
	}
	public Integer getBrachSort() {
		return brachSort;
	}
	public void setBrachSort(Integer brachSort) {
		this.brachSort = brachSort;
	}
	public Integer getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(Integer memberNum) {
		this.memberNum = memberNum;
	}
	public Integer getHeadAvgNum() {
		return headAvgNum;
	}
	public void setHeadAvgNum(Integer headAvgNum) {
		this.headAvgNum = headAvgNum;
	}
	public Integer getBrachAvgNum() {
		return brachAvgNum;
	}
	public void setBrachAvgNum(Integer brachAvgNum) {
		this.brachAvgNum = brachAvgNum;
	}
	public List<CompanySortDTO> getHeadCompany() {
		return headCompany;
	}
	public void setHeadCompany(List<CompanySortDTO> headCompany) {
		this.headCompany = headCompany;
	}
	public List<CompanySortDTO> getBrachCompany() {
		return brachCompany;
	}
	public void setBrachCompany(List<CompanySortDTO> brachCompany) {
		this.brachCompany = brachCompany;
	}
	
}
