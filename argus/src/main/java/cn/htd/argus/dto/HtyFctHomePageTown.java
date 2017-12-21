package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctHomePageTown {
    private String pkKeyTown;

    private String statDay;

    private String orgCode;

    private String orgFname;

    private String areaProcode;

    private String areaProname;

    private String areaCitycode;

    private String areaCityname;

    private String areaCountycode;

    private String areaCountyname;

    private BigDecimal custNum;

    private BigDecimal coverageRate;

    private BigDecimal purchaseAmt;

    public String getPkKeyTown() {
        return pkKeyTown;
    }

    public void setPkKeyTown(String pkKeyTown) {
        this.pkKeyTown = pkKeyTown == null ? null : pkKeyTown.trim();
    }

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

    public String getAreaProcode() {
        return areaProcode;
    }

    public void setAreaProcode(String areaProcode) {
        this.areaProcode = areaProcode == null ? null : areaProcode.trim();
    }

    public String getAreaProname() {
        return areaProname;
    }

    public void setAreaProname(String areaProname) {
        this.areaProname = areaProname == null ? null : areaProname.trim();
    }

    public String getAreaCitycode() {
        return areaCitycode;
    }

    public void setAreaCitycode(String areaCitycode) {
        this.areaCitycode = areaCitycode == null ? null : areaCitycode.trim();
    }

    public String getAreaCityname() {
        return areaCityname;
    }

    public void setAreaCityname(String areaCityname) {
        this.areaCityname = areaCityname == null ? null : areaCityname.trim();
    }

    public String getAreaCountycode() {
        return areaCountycode;
    }

    public void setAreaCountycode(String areaCountycode) {
        this.areaCountycode = areaCountycode == null ? null : areaCountycode.trim();
    }

    public String getAreaCountyname() {
        return areaCountyname;
    }

    public void setAreaCountyname(String areaCountyname) {
        this.areaCountyname = areaCountyname == null ? null : areaCountyname.trim();
    }

    public BigDecimal getCustNum() {
        return custNum;
    }

    public void setCustNum(BigDecimal custNum) {
        this.custNum = custNum;
    }

    public BigDecimal getCoverageRate() {
        return coverageRate;
    }

    public void setCoverageRate(BigDecimal coverageRate) {
        this.coverageRate = coverageRate;
    }

    public BigDecimal getPurchaseAmt() {
        return purchaseAmt;
    }

    public void setPurchaseAmt(BigDecimal purchaseAmt) {
        this.purchaseAmt = purchaseAmt;
    }
}