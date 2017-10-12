package cn.htd.argus.bean;

import java.math.BigDecimal;

/**
 * Created by wangtp on 2017/10/11.
 */
public class SaleDetailDTO {
    private String prodName;

    private String ppName;

    private String plName;

    private String sort;

    private BigDecimal xsPrice;

    private BigDecimal maxXsAmt;

    private BigDecimal minXsAmt;

    private BigDecimal xsQty;

    private BigDecimal mJcQty;

    private BigDecimal xsAmt;

    private BigDecimal xsDd;

    private BigDecimal salesRing;

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public BigDecimal getXsPrice() {
        return xsPrice;
    }

    public void setXsPrice(BigDecimal xsPrice) {
        this.xsPrice = xsPrice;
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

    public BigDecimal getXsQty() {
        return xsQty;
    }

    public void setXsQty(BigDecimal xsQty) {
        this.xsQty = xsQty;
    }

    public BigDecimal getmJcQty() {
        return mJcQty;
    }

    public void setmJcQty(BigDecimal mJcQty) {
        this.mJcQty = mJcQty;
    }

    public BigDecimal getXsAmt() {
        return xsAmt;
    }

    public void setXsAmt(BigDecimal xsAmt) {
        this.xsAmt = xsAmt;
    }

    public BigDecimal getSalesRing() {
        return salesRing;
    }

    public void setSalesRing(BigDecimal salesRing) {
        this.salesRing = salesRing;
    }

    public String getPpName() {
        return ppName;
    }

    public void setPpName(String ppName) {
        this.ppName = ppName;
    }

    public BigDecimal getXsDd() {
        return xsDd;
    }

    public void setXsDd(BigDecimal xsDd) {
        this.xsDd = xsDd;
    }
}
