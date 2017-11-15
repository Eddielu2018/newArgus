package cn.htd.argus.bean;

public class HtyFctCustAnalysisInDTO {

	private String userId;
	private String startTime;
	private String endTime;
	private int type;
	private int avgType;
	private int bossType;
	private String nowTime;
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAvgType() {
		return avgType;
	}
	public void setAvgType(int avgType) {
		this.avgType = avgType;
	}
	public int getBossType() {
		return bossType;
	}
	public void setBossType(int bossType) {
		this.bossType = bossType;
	}
	public String getNowTime() {
		return nowTime;
	}
	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}
	
}
