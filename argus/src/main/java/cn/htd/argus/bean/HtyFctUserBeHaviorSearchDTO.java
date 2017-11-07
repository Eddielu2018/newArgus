package cn.htd.argus.bean;

import java.math.BigDecimal;
import java.util.Date;

public class HtyFctUserBeHaviorSearchDTO {
	private String endTime;// 日历2
	private String startTime;// 日历1
    private String userId;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
