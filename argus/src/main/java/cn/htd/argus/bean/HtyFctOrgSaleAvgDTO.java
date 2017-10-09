package cn.htd.argus.bean;

import java.math.BigDecimal;
import java.util.List;

public class HtyFctOrgSaleAvgDTO {

	private int headSort;
	private int brachSort;
	private BigDecimal salePrice;
	private BigDecimal headAvgPrice;
	private BigDecimal brachAvgPrice;
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
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public BigDecimal getHeadAvgPrice() {
		return headAvgPrice;
	}
	public void setHeadAvgPrice(BigDecimal headAvgPrice) {
		this.headAvgPrice = headAvgPrice;
	}
	public BigDecimal getBrachAvgPrice() {
		return brachAvgPrice;
	}
	public void setBrachAvgPrice(BigDecimal brachAvgPrice) {
		this.brachAvgPrice = brachAvgPrice;
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
