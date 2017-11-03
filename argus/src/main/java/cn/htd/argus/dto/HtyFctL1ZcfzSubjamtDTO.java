package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctL1ZcfzSubjamtDTO {
    private Long id;

    private String dtime;

    private String yearMon;

    private String orgCode;

    private String pSubjcode;

    private String subjcode;

    private BigDecimal zcfzAmount;

    private Integer etlDate;

    private String etlTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime == null ? null : dtime.trim();
    }

    public String getYearMon() {
        return yearMon;
    }

    public void setYearMon(String yearMon) {
        this.yearMon = yearMon == null ? null : yearMon.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getpSubjcode() {
        return pSubjcode;
    }

    public void setpSubjcode(String pSubjcode) {
        this.pSubjcode = pSubjcode == null ? null : pSubjcode.trim();
    }

    public String getSubjcode() {
        return subjcode;
    }

    public void setSubjcode(String subjcode) {
        this.subjcode = subjcode == null ? null : subjcode.trim();
    }

    public BigDecimal getZcfzAmount() {
        return zcfzAmount;
    }

    public void setZcfzAmount(BigDecimal zcfzAmount) {
        this.zcfzAmount = zcfzAmount;
    }

    public Integer getEtlDate() {
        return etlDate;
    }

    public void setEtlDate(Integer etlDate) {
        this.etlDate = etlDate;
    }

    public String getEtlTime() {
        return etlTime;
    }

    public void setEtlTime(String etlTime) {
        this.etlTime = etlTime == null ? null : etlTime.trim();
    }
}