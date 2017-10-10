package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctSaleOrgAllDTO {
    private Long id;

    private String dateKey;

    private String orgCode;

    private BigDecimal xsAmt;

    private Integer xsQty;

    private BigDecimal xsZhMl;

    private BigDecimal xsZySr;

    private BigDecimal xsMl;

    private BigDecimal xsLr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateKey() {
        return dateKey;
    }

    public void setDateKey(String dateKey) {
        this.dateKey = dateKey == null ? null : dateKey.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public BigDecimal getXsAmt() {
        return xsAmt;
    }

    public void setXsAmt(BigDecimal xsAmt) {
        this.xsAmt = xsAmt;
    }

    public Integer getXsQty() {
        return xsQty;
    }

    public void setXsQty(Integer xsQty) {
        this.xsQty = xsQty;
    }

    public BigDecimal getXsZhMl() {
        return xsZhMl;
    }

    public void setXsZhMl(BigDecimal xsZhMl) {
        this.xsZhMl = xsZhMl;
    }

    public BigDecimal getXsZySr() {
        return xsZySr;
    }

    public void setXsZySr(BigDecimal xsZySr) {
        this.xsZySr = xsZySr;
    }

    public BigDecimal getXsMl() {
        return xsMl;
    }

    public void setXsMl(BigDecimal xsMl) {
        this.xsMl = xsMl;
    }

    public BigDecimal getXsLr() {
        return xsLr;
    }

    public void setXsLr(BigDecimal xsLr) {
        this.xsLr = xsLr;
    }
}