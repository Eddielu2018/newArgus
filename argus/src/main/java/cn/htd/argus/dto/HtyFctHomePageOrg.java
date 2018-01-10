package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctHomePageOrg {
    private String statDay;

    private String orgCode;

    private String orgFname;

    private BigDecimal saleAmt;

    private BigDecimal saleAmtMon;

    private BigDecimal stockWarNum;

    private BigDecimal stockUnsNum;

    private BigDecimal memberNum;

    private String companyValuation;

    private BigDecimal fbNum;

    private BigDecimal zbNum;

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

    public BigDecimal getSaleAmt() {
        return saleAmt;
    }

    public void setSaleAmt(BigDecimal saleAmt) {
        this.saleAmt = saleAmt;
    }

    public BigDecimal getSaleAmtMon() {
        return saleAmtMon;
    }

    public void setSaleAmtMon(BigDecimal saleAmtMon) {
        this.saleAmtMon = saleAmtMon;
    }

    public BigDecimal getStockWarNum() {
        return stockWarNum;
    }

    public void setStockWarNum(BigDecimal stockWarNum) {
        this.stockWarNum = stockWarNum;
    }

    public BigDecimal getStockUnsNum() {
        return stockUnsNum;
    }

    public void setStockUnsNum(BigDecimal stockUnsNum) {
        this.stockUnsNum = stockUnsNum;
    }

    public BigDecimal getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(BigDecimal memberNum) {
        this.memberNum = memberNum;
    }

    public String getCompanyValuation() {
        return companyValuation;
    }

    public void setCompanyValuation(String companyValuation) {
        this.companyValuation = companyValuation == null ? null : companyValuation.trim();
    }

    public BigDecimal getFbNum() {
        return fbNum;
    }

    public void setFbNum(BigDecimal fbNum) {
        this.fbNum = fbNum;
    }

    public BigDecimal getZbNum() {
        return zbNum;
    }

    public void setZbNum(BigDecimal zbNum) {
        this.zbNum = zbNum;
    }
}