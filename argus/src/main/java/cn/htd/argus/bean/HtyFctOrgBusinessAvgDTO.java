package cn.htd.argus.bean;

import java.math.BigDecimal;
import java.util.List;

public class HtyFctOrgBusinessAvgDTO {

	private Integer headSort;
	private Integer brachSort;
	private BigDecimal businessIncome;
	private BigDecimal headAvgIncome;
	private BigDecimal brachAvgIncome;
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
	public BigDecimal getBusinessIncome() {
		return businessIncome;
	}
	public void setBusinessIncome(BigDecimal businessIncome) {
		this.businessIncome = businessIncome;
	}
	public BigDecimal getHeadAvgIncome() {
		return headAvgIncome;
	}
	public void setHeadAvgIncome(BigDecimal headAvgIncome) {
		this.headAvgIncome = headAvgIncome;
	}
	public BigDecimal getBrachAvgIncome() {
		return brachAvgIncome;
	}
	public void setBrachAvgIncome(BigDecimal brachAvgIncome) {
		this.brachAvgIncome = brachAvgIncome;
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
