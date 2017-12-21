package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctHomePageCust {
    private String pkKey;

    private String pkKeyTown;

    private String custCode;

    private String custName;

    private BigDecimal purchaseAmtYear;

    private String orgaddrss;

    private BigDecimal orgaddresslng;

    private BigDecimal orgaddresslat;

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

    public BigDecimal getPurchaseAmtYear() {
        return purchaseAmtYear;
    }

    public void setPurchaseAmtYear(BigDecimal purchaseAmtYear) {
        this.purchaseAmtYear = purchaseAmtYear;
    }

    public String getOrgaddrss() {
        return orgaddrss;
    }

    public void setOrgaddrss(String orgaddrss) {
        this.orgaddrss = orgaddrss == null ? null : orgaddrss.trim();
    }

    public BigDecimal getOrgaddresslng() {
        return orgaddresslng;
    }

    public void setOrgaddresslng(BigDecimal orgaddresslng) {
        this.orgaddresslng = orgaddresslng;
    }

    public BigDecimal getOrgaddresslat() {
        return orgaddresslat;
    }

    public void setOrgaddresslat(BigDecimal orgaddresslat) {
        this.orgaddresslat = orgaddresslat;
    }
}