package cn.htd.argus.bean;

import java.math.BigDecimal;

/**
 * Created by wangtp on 2017/10/12.
 */
public class SaleXzsDTO {
    private String dateKey;
    private BigDecimal xsAmt;
    private BigDecimal xsAmtXz;
    private Integer cnt;
    private BigDecimal cntXz;
    private BigDecimal rate;
    private BigDecimal rateXz;

    public String getDateKey() {
        return dateKey;
    }

    public void setDateKey(String dateKey) {
        this.dateKey = dateKey;
    }

    public BigDecimal getXsAmt() {
        return xsAmt;
    }

    public void setXsAmt(BigDecimal xsAmt) {
        this.xsAmt = xsAmt;
    }

    public BigDecimal getXsAmtXz() {
        return xsAmtXz;
    }

    public void setXsAmtXz(BigDecimal xsAmtXz) {
        this.xsAmtXz = xsAmtXz;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public BigDecimal getCntXz() {
        return cntXz;
    }

    public void setCntXz(BigDecimal cntXz) {
        this.cntXz = cntXz;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRateXz() {
        return rateXz;
    }

    public void setRateXz(BigDecimal rateXz) {
        this.rateXz = rateXz;
    }
}
