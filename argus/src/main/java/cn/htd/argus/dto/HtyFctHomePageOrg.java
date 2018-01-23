package cn.htd.argus.dto;


public class HtyFctHomePageOrg {
    private String statDay;

    private String orgCode;

    private String orgFname;

    private String saleAmt;

    private String saleAmtMon;

    private String stockWarNum;

    private String stockUnsNum;

    private String memberNum;

    private String companyValuation;

    private String fbNum;

    private String zbNum;

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

    public String getSaleAmt() {
        return saleAmt;
    }

    public void setSaleAmt(String saleAmt) {
        this.saleAmt = saleAmt;
    }

    public String getSaleAmtMon() {
        return saleAmtMon;
    }

    public void setSaleAmtMon(String saleAmtMon) {
        this.saleAmtMon = saleAmtMon;
    }

    public String getStockWarNum() {
        return stockWarNum;
    }

    public void setStockWarNum(String stockWarNum) {
        this.stockWarNum = stockWarNum;
    }

    public String getStockUnsNum() {
        return stockUnsNum;
    }

    public void setStockUnsNum(String stockUnsNum) {
        this.stockUnsNum = stockUnsNum;
    }

    public String getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
    }

    public String getCompanyValuation() {
        return companyValuation;
    }

    public void setCompanyValuation(String companyValuation) {
        this.companyValuation = companyValuation == null ? null : companyValuation.trim();
    }

    public String getFbNum() {
        return fbNum;
    }

    public void setFbNum(String fbNum) {
        this.fbNum = fbNum;
    }

    public String getZbNum() {
        return zbNum;
    }

    public void setZbNum(String zbNum) {
        this.zbNum = zbNum;
    }
}