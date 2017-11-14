package cn.htd.argus.bean;

import java.math.BigDecimal;

public class HtyFctOrgMemberMothOutDTO {
	private String custCode;
	private String custName;
	private BigDecimal xsAmt;
	private Integer xsQty;
	private String sellPoint;
	private String lastDate;
	private Integer lastTime;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public BigDecimal getXsAmt() {
		return xsAmt;
	}
	public void setXsAmt(BigDecimal xsAmt) {
		this.xsAmt = xsAmt;
	}
	public String getSellPoint() {
		return sellPoint;
	}
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public Integer getLastTime() {
		return lastTime;
	}
	public void setLastTime(Integer lastTime) {
		this.lastTime = lastTime;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public Integer getXsQty() {
		return xsQty;
	}
	public void setXsQty(Integer xsQty) {
		this.xsQty = xsQty;
	}
	
}
