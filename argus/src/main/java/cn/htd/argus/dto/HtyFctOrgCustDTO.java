package cn.htd.argus.dto;

public class HtyFctOrgCustDTO {
    private Long id;

    private String orgCode;

    private String yearMon;

    private Integer monNewcustnum;

    private Integer lastmonNewcustnum;

    private Integer yearNewcustnum;

    private Integer lastyearNewcustnum;

    private Integer monTranscustnum;

    private Integer yearTranscustnum;

    private Integer actCustnum;

    private Integer morrunactCustnum;

    private Integer vipNum;

    private Integer expire30VipNum;
    
    private Integer custNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getYearMon() {
        return yearMon;
    }

    public void setYearMon(String yearMon) {
        this.yearMon = yearMon == null ? null : yearMon.trim();
    }

    public Integer getMonNewcustnum() {
        return monNewcustnum;
    }

    public void setMonNewcustnum(Integer monNewcustnum) {
        this.monNewcustnum = monNewcustnum;
    }

    public Integer getLastmonNewcustnum() {
        return lastmonNewcustnum;
    }

    public void setLastmonNewcustnum(Integer lastmonNewcustnum) {
        this.lastmonNewcustnum = lastmonNewcustnum;
    }

    public Integer getYearNewcustnum() {
        return yearNewcustnum;
    }

    public void setYearNewcustnum(Integer yearNewcustnum) {
        this.yearNewcustnum = yearNewcustnum;
    }

    public Integer getLastyearNewcustnum() {
        return lastyearNewcustnum;
    }

    public void setLastyearNewcustnum(Integer lastyearNewcustnum) {
        this.lastyearNewcustnum = lastyearNewcustnum;
    }

    public Integer getMonTranscustnum() {
        return monTranscustnum;
    }

    public void setMonTranscustnum(Integer monTranscustnum) {
        this.monTranscustnum = monTranscustnum;
    }

    public Integer getYearTranscustnum() {
        return yearTranscustnum;
    }

    public void setYearTranscustnum(Integer yearTranscustnum) {
        this.yearTranscustnum = yearTranscustnum;
    }

    public Integer getActCustnum() {
        return actCustnum;
    }

    public void setActCustnum(Integer actCustnum) {
        this.actCustnum = actCustnum;
    }

    public Integer getMorrunactCustnum() {
        return morrunactCustnum;
    }

    public void setMorrunactCustnum(Integer morrunactCustnum) {
        this.morrunactCustnum = morrunactCustnum;
    }

    public Integer getVipNum() {
        return vipNum;
    }

    public void setVipNum(Integer vipNum) {
        this.vipNum = vipNum;
    }

    public Integer getExpire30VipNum() {
        return expire30VipNum;
    }

    public void setExpire30VipNum(Integer expire30VipNum) {
        this.expire30VipNum = expire30VipNum;
    }

	public Integer getCustNum() {
		return custNum;
	}

	public void setCustNum(Integer custNum) {
		this.custNum = custNum;
	}
    
}