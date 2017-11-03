package cn.htd.argus.bean;

public class HtyFctCustInDto {
	private String userId;
	private String custStartTime;
	private String custEndTime;
	private String firstTime;
	private Integer dimension;
	private Integer start;
	private Integer end;
	private Integer kind;
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
	public Integer getDimension() {
		return dimension;
	}
	public void setDimension(Integer dimension) {
		this.dimension = dimension;
	}
	public String getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public Integer getKind() {
		return kind;
	}
	public void setKind(Integer kind) {
		this.kind = kind;
	}
}
