package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctSaleOrgDetailDTO {
    private Long id;

    private String dateKey;

    private String orgCode;

    private String plCode;

    private String plName;

    private String ppCode;

    private String ppName;

    private String prodCode;

    private String prodName;

    private BigDecimal xsAmt;

    private BigDecimal xsQty;

    private BigDecimal maxXsAmt;

    private BigDecimal minXsAmt;

    private BigDecimal xsDd;

    private BigDecimal mJcQty;

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

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode == null ? null : prodCode.trim();
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName == null ? null : prodName.trim();
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

    public BigDecimal getMaxXsAmt() {
        return maxXsAmt;
    }

    public void setMaxXsAmt(BigDecimal maxXsAmt) {
        this.maxXsAmt = maxXsAmt;
    }

    public BigDecimal getMinXsAmt() {
        return minXsAmt;
    }

    public void setMinXsAmt(BigDecimal minXsAmt) {
        this.minXsAmt = minXsAmt;
    }

    public BigDecimal getXsDd() {
        return xsDd;
    }

    public void setXsDd(BigDecimal xsDd) {
        this.xsDd = xsDd;
    }

    public BigDecimal getmJcQty() {
        return mJcQty;
    }

    public void setmJcQty(BigDecimal mJcQty) {
        this.mJcQty = mJcQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HtyFctSaleOrgDetailDTO detailDTO = (HtyFctSaleOrgDetailDTO) o;

        if (prodCode != null ? !prodCode.equals(detailDTO.prodCode) : detailDTO.prodCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return prodCode != null ? prodCode.hashCode() : 0;
    }
}