package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctSalePpAnalysisOrgDTO {
    private String statDay;

    private String orgCode;

    private String orgFname;

    private String ppCode;

    private String ppName;

    private BigDecimal saleAmtAll;

    private BigDecimal saleQvt;

    private BigDecimal saleAmtYear;

    private BigDecimal saleAmtMon;

    private String isEndflag;

    private BigDecimal saleAvg;

    public String getStatDay() {
        return statDay;
    }

    public void setStatDay(String statDay) {
        this.statDay = statDay == null ? null : statDay.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgFname() {
        return orgFname;
    }

    public void setOrgFname(String orgFname) {
        this.orgFname = orgFname == null ? null : orgFname.trim();
    }

    public String getPpCode() {
        return ppCode;
    }

    public void setPpCode(String ppCode) {
        this.ppCode = ppCode == null ? null : ppCode.trim();
    }

    public String getPpName() {
        return ppName;
    }

    public void setPpName(String ppName) {
        this.ppName = ppName == null ? null : ppName.trim();
    }

    public BigDecimal getSaleAmtAll() {
        return saleAmtAll;
    }

    public void setSaleAmtAll(BigDecimal saleAmtAll) {
        this.saleAmtAll = saleAmtAll;
    }

    public BigDecimal getSaleQvt() {
        return saleQvt;
    }

    public void setSaleQvt(BigDecimal saleQvt) {
        this.saleQvt = saleQvt;
    }

    public BigDecimal getSaleAmtYear() {
        return saleAmtYear;
    }

    public void setSaleAmtYear(BigDecimal saleAmtYear) {
        this.saleAmtYear = saleAmtYear;
    }

    public BigDecimal getSaleAmtMon() {
        return saleAmtMon;
    }

    public void setSaleAmtMon(BigDecimal saleAmtMon) {
        this.saleAmtMon = saleAmtMon;
    }

    public String getIsEndflag() {
        return isEndflag;
    }

    public void setIsEndflag(String isEndflag) {
        this.isEndflag = isEndflag == null ? null : isEndflag.trim();
    }

    public BigDecimal getSaleAvg() {
        return saleAvg;
    }

    public void setSaleAvg(BigDecimal saleAvg) {
        this.saleAvg = saleAvg;
    }
}