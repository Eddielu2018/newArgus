package cn.htd.argus.bean;

import java.math.BigDecimal;
import java.util.List;

public class HtyFctOrgAvgDTO {
	private Integer sortNum;
	private BigDecimal companyNow;
	private BigDecimal headAvg;
	private BigDecimal brachAvg;
	private List<CompanySortDTO> companyList;
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	public BigDecimal getCompanyNow() {
		return companyNow;
	}
	public void setCompanyNow(BigDecimal companyNow) {
		this.companyNow = companyNow;
	}
	public BigDecimal getHeadAvg() {
		return headAvg;
	}
	public void setHeadAvg(BigDecimal headAvg) {
		this.headAvg = headAvg;
	}
	public BigDecimal getBrachAvg() {
		return brachAvg;
	}
	public void setBrachAvg(BigDecimal brachAvg) {
		this.brachAvg = brachAvg;
	}
	public List<CompanySortDTO> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<CompanySortDTO> companyList) {
		this.companyList = companyList;
	}
	
}
