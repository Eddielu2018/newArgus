package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctSaleOrgProdDTO {
    private Long id;

    private String dateKey;

    private String orgCode;

    private String plCode;

    private String plName;

    private String ppCode;

    private String ppName;

    private BigDecimal xsAmt;

    private BigDecimal xsQty;

    private BigDecimal xsAmtAll;

    private BigDecimal xsQtyAll;

    private BigDecimal xsCb;

    private BigDecimal xsSr;

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

    public String getPlCode() {
        return plCode;
    }

    public void setPlCode(String plCode) {
        this.plCode = plCode == null ? null : plCode.trim();
    }

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName == null ? null : plName.trim();
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

    public BigDecimal getXsAmt() {
        return xsAmt;
    }

    public void setXsAmt(BigDecimal xsAmt) {
        this.xsAmt = xsAmt;
    }

    public BigDecimal getXsQty() {
        return xsQty;
    }

    public void setXsQty(BigDecimal xsQty) {
        this.xsQty = xsQty;
    }

    public BigDecimal getXsAmtAll() {
        return xsAmtAll;
    }

    public void setXsAmtAll(BigDecimal xsAmtAll) {
        this.xsAmtAll = xsAmtAll;
    }

    public BigDecimal getXsQtyAll() {
        return xsQtyAll;
    }

    public void setXsQtyAll(BigDecimal xsQtyAll) {
        this.xsQtyAll = xsQtyAll;
    }

    public BigDecimal getXsCb() {
        return xsCb;
    }

    public void setXsCb(BigDecimal xsCb) {
        this.xsCb = xsCb;
    }

    public BigDecimal getXsSr() {
        return xsSr;
    }

    public void setXsSr(BigDecimal xsSr) {
        this.xsSr = xsSr;
    }
}