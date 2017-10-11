package cn.htd.argus.bean;

import java.math.BigDecimal;

/**
 * Created by wangtp on 2017/10/11.
 */
public class SaleDetailDTO {
    private String prodName;

    private String plName;

    private String sort;

    private BigDecimal xsPrice;

    private BigDecimal maxXsAmt;

    private BigDecimal minXsAmt;

    private BigDecimal xsQty;

    private BigDecimal M_JC_QTY;

    private BigDecimal xsAmt;

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

    public BigDecimal getM_JC_QTY() {
        return M_JC_QTY;
    }

    public void setM_JC_QTY(BigDecimal m_JC_QTY) {
        M_JC_QTY = m_JC_QTY;
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
}
