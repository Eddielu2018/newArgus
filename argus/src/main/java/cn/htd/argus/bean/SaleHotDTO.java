package cn.htd.argus.bean;

import java.math.BigDecimal;

/**
 * Created by wangtp on 2017/10/12.
 */
public class SaleHotDTO {
    private String ppName;

    private String plName;

    private String prodName;

    private  String prodCode;

    private BigDecimal maxXsAmt;

    private BigDecimal minXsAmt;

    private BigDecimal qtyAvg;

    public String getPpName() {
        return ppName;
    }

    public void setPpName(String ppName) {
        this.ppName = ppName;
    }

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
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

    public BigDecimal getQtyAvg() {
        return qtyAvg;
    }

    public void setQtyAvg(BigDecimal qtyAvg) {
        this.qtyAvg = qtyAvg;
    }
}
