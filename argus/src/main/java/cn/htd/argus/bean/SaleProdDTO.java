package cn.htd.argus.bean;

import java.math.BigDecimal;

/**
 * Created by wangtp on 2017/10/11.
 */
public class SaleProdDTO {
    private String ppName;

    private String plName;

    private BigDecimal xsPrice;

    private BigDecimal xsQty;

    private BigDecimal xsAmt;

    private BigDecimal xsRatio;

    private BigDecimal xsAvg;

    private BigDecimal xsAvgRatio;

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

    public BigDecimal getXsPrice() {
        return xsPrice;
    }

    public void setXsPrice(BigDecimal xsPrice) {
        this.xsPrice = xsPrice;
    }

    public BigDecimal getXsQty() {
        return xsQty;
    }

    public void setXsQty(BigDecimal xsQty) {
        this.xsQty = xsQty;
    }

    public BigDecimal getXsAmt() {
        return xsAmt;
    }

    public void setXsAmt(BigDecimal xsAmt) {
        this.xsAmt = xsAmt;
    }

    public BigDecimal getXsRatio() {
        return xsRatio;
    }

    public void setXsRatio(BigDecimal xsRatio) {
        this.xsRatio = xsRatio;
    }

    public BigDecimal getXsAvg() {
        return xsAvg;
    }

    public void setXsAvg(BigDecimal xsAvg) {
        this.xsAvg = xsAvg;
    }

    public BigDecimal getXsAvgRatio() {
        return xsAvgRatio;
    }

    public void setXsAvgRatio(BigDecimal xsAvgRatio) {
        this.xsAvgRatio = xsAvgRatio;
    }
}
