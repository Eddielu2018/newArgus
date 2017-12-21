package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctHomePageLvl {
    private String statDay;

    private String orgCode;

    private String orgFname;

    private String custCode;

    private String custName;

    private BigDecimal purchaseAmt;

    private BigDecimal purchaseAmtMon;

    private BigDecimal purchaseAmtMon6;

    private BigDecimal purchaseAmtYear;

    private BigDecimal purchaseAmtL;

    private BigDecimal purchaseAmtLmon6;

    private BigDecimal purchaseAmtLmon;

    private BigDecimal purchaseAmtLyear;

    private BigDecimal saleAvg;

    private BigDecimal saleAvgMon;

    private BigDecimal saleAvgMon6;

    private BigDecimal saleAvgYear;

    private String managerName;

    private BigDecimal custPlNum;

    private BigDecimal orgPlNum;

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

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode == null ? null : custCode.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public BigDecimal getPurchaseAmt() {
        return purchaseAmt;
    }

    public void setPurchaseAmt(BigDecimal purchaseAmt) {
        this.purchaseAmt = purchaseAmt;
    }

    public BigDecimal getPurchaseAmtMon() {
        return purchaseAmtMon;
    }

    public void setPurchaseAmtMon(BigDecimal purchaseAmtMon) {
        this.purchaseAmtMon = purchaseAmtMon;
    }

    public BigDecimal getPurchaseAmtMon6() {
        return purchaseAmtMon6;
    }

    public void setPurchaseAmtMon6(BigDecimal purchaseAmtMon6) {
        this.purchaseAmtMon6 = purchaseAmtMon6;
    }

    public BigDecimal getPurchaseAmtYear() {
        return purchaseAmtYear;
    }

    public void setPurchaseAmtYear(BigDecimal purchaseAmtYear) {
        this.purchaseAmtYear = purchaseAmtYear;
    }

    public BigDecimal getPurchaseAmtL() {
        return purchaseAmtL;
    }

    public void setPurchaseAmtL(BigDecimal purchaseAmtL) {
        this.purchaseAmtL = purchaseAmtL;
    }

    public BigDecimal getPurchaseAmtLmon6() {
        return purchaseAmtLmon6;
    }

    public void setPurchaseAmtLmon6(BigDecimal purchaseAmtLmon6) {
        this.purchaseAmtLmon6 = purchaseAmtLmon6;
    }

    public BigDecimal getPurchaseAmtLmon() {
        return purchaseAmtLmon;
    }

    public void setPurchaseAmtLmon(BigDecimal purchaseAmtLmon) {
        this.purchaseAmtLmon = purchaseAmtLmon;
    }

    public BigDecimal getPurchaseAmtLyear() {
        return purchaseAmtLyear;
    }

    public void setPurchaseAmtLyear(BigDecimal purchaseAmtLyear) {
        this.purchaseAmtLyear = purchaseAmtLyear;
    }

    public BigDecimal getSaleAvg() {
        return saleAvg;
    }

    public void setSaleAvg(BigDecimal saleAvg) {
        this.saleAvg = saleAvg;
    }

    public BigDecimal getSaleAvgMon() {
        return saleAvgMon;
    }

    public void setSaleAvgMon(BigDecimal saleAvgMon) {
        this.saleAvgMon = saleAvgMon;
    }

    public BigDecimal getSaleAvgMon6() {
        return saleAvgMon6;
    }

    public void setSaleAvgMon6(BigDecimal saleAvgMon6) {
        this.saleAvgMon6 = saleAvgMon6;
    }

    public BigDecimal getSaleAvgYear() {
        return saleAvgYear;
    }

    public void setSaleAvgYear(BigDecimal saleAvgYear) {
        this.saleAvgYear = saleAvgYear;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public BigDecimal getCustPlNum() {
        return custPlNum;
    }

    public void setCustPlNum(BigDecimal custPlNum) {
        this.custPlNum = custPlNum;
    }

    public BigDecimal getOrgPlNum() {
        return orgPlNum;
    }

    public void setOrgPlNum(BigDecimal orgPlNum) {
        this.orgPlNum = orgPlNum;
    }
}