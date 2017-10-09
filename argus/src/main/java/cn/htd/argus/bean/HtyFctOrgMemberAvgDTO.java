package cn.htd.argus.bean;

import java.util.List;

public class HtyFctOrgMemberAvgDTO {

	private int headSort;
	private int brachSort;
	private int memberNum;
	private int headAvgNum;
	private int brachAvgNum;
	private List<CompanySortDTO> headCompany;
	private List<CompanySortDTO> brachCompany;
	public int getHeadSort() {
		return headSort;
	}
	public void setHeadSort(int headSort) {
		this.headSort = headSort;
	}
	public int getBrachSort() {
		return brachSort;
	}
	public void setBrachSort(int brachSort) {
		this.brachSort = brachSort;
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
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getHeadAvgNum() {
		return headAvgNum;
	}
	public void setHeadAvgNum(int headAvgNum) {
		this.headAvgNum = headAvgNum;
	}
	public int getBrachAvgNum() {
		return brachAvgNum;
	}
	public void setBrachAvgNum(int brachAvgNum) {
		this.brachAvgNum = brachAvgNum;
	}
	
}
