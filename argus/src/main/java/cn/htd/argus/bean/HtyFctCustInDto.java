package cn.htd.argus.bean;

public class HtyFctCustInDto {
	private String userId;
	private String custStartTime;
	private String custEndTime;
	private String pairFirstTime;
	private String pairSecondTime;
	private Integer dimension;
	private Integer pairFirstStart;
	private Integer pairFirstEnd;
	private Integer pairSecondEnd;
	private Integer pairSecondStart;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCustStartTime() {
		return custStartTime;
	}
	public void setCustStartTime(String custStartTime) {
		this.custStartTime = custStartTime;
	}
	public String getCustEndTime() {
		return custEndTime;
	}
	public void setCustEndTime(String custEndTime) {
		this.custEndTime = custEndTime;
	}
	public String getPairFirstTime() {
		return pairFirstTime;
	}
	public void setPairFirstTime(String pairFirstTime) {
		this.pairFirstTime = pairFirstTime;
	}
	public String getPairSecondTime() {
		return pairSecondTime;
	}
	public void setPairSecondTime(String pairSecondTime) {
		this.pairSecondTime = pairSecondTime;
	}
	public Integer getDimension() {
		return dimension;
	}
	public void setDimension(Integer dimension) {
		this.dimension = dimension;
	}
	public Integer getPairFirstStart() {
		return pairFirstStart;
	}
	public void setPairFirstStart(Integer pairFirstStart) {
		this.pairFirstStart = pairFirstStart;
	}
	public Integer getPairFirstEnd() {
		return pairFirstEnd;
	}
	public void setPairFirstEnd(Integer pairFirstEnd) {
		this.pairFirstEnd = pairFirstEnd;
	}
	public Integer getPairSecondEnd() {
		return pairSecondEnd;
	}
	public void setPairSecondEnd(Integer pairSecondEnd) {
		this.pairSecondEnd = pairSecondEnd;
	}
	public Integer getPairSecondStart() {
		return pairSecondStart;
	}
	public void setPairSecondStart(Integer pairSecondStart) {
		this.pairSecondStart = pairSecondStart;
	}
}
