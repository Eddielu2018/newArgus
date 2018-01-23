package cn.htd.argus.dto;

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

    private String custNum;

    private String coverageRate;

    private String purchaseAmt;

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

    public String getCustNum() {
        return custNum;
    }

    public void setCustNum(String custNum) {
        this.custNum = custNum;
    }

    public String getCoverageRate() {
        return coverageRate;
    }

    public void setCoverageRate(String coverageRate) {
        this.coverageRate = coverageRate;
    }

    public String getPurchaseAmt() {
        return purchaseAmt;
    }

    public void setPurchaseAmt(String purchaseAmt) {
        this.purchaseAmt = purchaseAmt;
    }
}