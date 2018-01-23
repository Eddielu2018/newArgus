package cn.htd.argus.dto;


public class HtyFctHomePageCust {
    private String pkKey;

    private String pkKeyTown;

    private String custCode;

    private String custName;

    private String purchaseAmtYear;

    private String orgaddrss;

    private String orgaddresslng;

    private String orgaddresslat;

    public String getPkKey() {
        return pkKey;
    }

    public void setPkKey(String pkKey) {
        this.pkKey = pkKey == null ? null : pkKey.trim();
    }

    public String getPkKeyTown() {
        return pkKeyTown;
    }

    public void setPkKeyTown(String pkKeyTown) {
        this.pkKeyTown = pkKeyTown == null ? null : pkKeyTown.trim();
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

    public String getPurchaseAmtYear() {
        return purchaseAmtYear;
    }

    public void setPurchaseAmtYear(String purchaseAmtYear) {
        this.purchaseAmtYear = purchaseAmtYear;
    }

    public String getOrgaddrss() {
        return orgaddrss;
    }

    public void setOrgaddrss(String orgaddrss) {
        this.orgaddrss = orgaddrss == null ? null : orgaddrss.trim();
    }

    public String getOrgaddresslng() {
        return orgaddresslng;
    }

    public void setOrgaddresslng(String orgaddresslng) {
        this.orgaddresslng = orgaddresslng;
    }

    public String getOrgaddresslat() {
        return orgaddresslat;
    }

    public void setOrgaddresslat(String orgaddresslat) {
        this.orgaddresslat = orgaddresslat;
    }
}