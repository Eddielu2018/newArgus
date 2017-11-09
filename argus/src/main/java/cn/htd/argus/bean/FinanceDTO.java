package cn.htd.argus.bean;

import java.math.BigDecimal;

/**
 * Created by wangtp on 2017/11/9.
 */
public class FinanceDTO {
    //1.EDW_FCT_L2_OKR_KPI_FINANCE
    //收现金营业款占比（收款）
    private BigDecimal xjYyRatio;
    //超90天应收占比
    private BigDecimal ys90Ratio;
    //前15天回款预算完成率
    private BigDecimal hk15BgtRatio;
    //超90天预付占比
    private BigDecimal yf90Ratio;
    //单客户销售占比
    private BigDecimal singleCustXsRatio;
    //盘点差异率
    private BigDecimal pdDiffRatio;
    //保险配比率
    private BigDecimal bxPbRatio;
    //坪效差异率
    private BigDecimal pxDiffRatio;

    //2.EDW_FCT_ZSD_FINANCE
    //平台金融服务逾期金额率
    private BigDecimal overdueAmtRatio;
    //供应链金融逾期家数占比
    private BigDecimal overdueCustnumRatio;
    //超30天个人借款占比
    private BigDecimal over30Ratio;


    //1.异常状态0：正常 1：异常
    //收现金营业款占比（收款）
    private String xjYyRatioState;
    //超90天应收占比
    private String ys90RatioState;
    //前15天回款预算完成率
    private String hk15BgtRatioState;
    //超90天预付占比
    private String yf90RatioState;
    //单客户销售占比
    private String singleCustXsRatioState;
    //盘点差异率
    private String pdDiffRatioState;
    //保险配比率
    private String bxPbRatioState;
    //坪效差异率
    private String pxDiffRatioState;

    //2.EDW_FCT_ZSD_FINANCE
    //平台金融服务逾期金额率
    private String overdueAmtRatioState;
    //供应链金融逾期家数占比
    private String overdueCustnumRatioState;
    //超30天个人借款占比
    private String over30RatioState;


    public BigDecimal getXjYyRatio() {
        return xjYyRatio;
    }

    public void setXjYyRatio(BigDecimal xjYyRatio) {
        this.xjYyRatio = xjYyRatio;
    }

    public BigDecimal getYs90Ratio() {
        return ys90Ratio;
    }

    public void setYs90Ratio(BigDecimal ys90Ratio) {
        this.ys90Ratio = ys90Ratio;
    }

    public BigDecimal getHk15BgtRatio() {
        return hk15BgtRatio;
    }

    public void setHk15BgtRatio(BigDecimal hk15BgtRatio) {
        this.hk15BgtRatio = hk15BgtRatio;
    }

    public BigDecimal getYf90Ratio() {
        return yf90Ratio;
    }

    public void setYf90Ratio(BigDecimal yf90Ratio) {
        this.yf90Ratio = yf90Ratio;
    }

    public BigDecimal getSingleCustXsRatio() {
        return singleCustXsRatio;
    }

    public void setSingleCustXsRatio(BigDecimal singleCustXsRatio) {
        this.singleCustXsRatio = singleCustXsRatio;
    }

    public BigDecimal getPdDiffRatio() {
        return pdDiffRatio;
    }

    public void setPdDiffRatio(BigDecimal pdDiffRatio) {
        this.pdDiffRatio = pdDiffRatio;
    }

    public BigDecimal getBxPbRatio() {
        return bxPbRatio;
    }

    public void setBxPbRatio(BigDecimal bxPbRatio) {
        this.bxPbRatio = bxPbRatio;
    }

    public BigDecimal getPxDiffRatio() {
        return pxDiffRatio;
    }

    public void setPxDiffRatio(BigDecimal pxDiffRatio) {
        this.pxDiffRatio = pxDiffRatio;
    }

    public BigDecimal getOverdueAmtRatio() {
        return overdueAmtRatio;
    }

    public void setOverdueAmtRatio(BigDecimal overdueAmtRatio) {
        this.overdueAmtRatio = overdueAmtRatio;
    }

    public BigDecimal getOverdueCustnumRatio() {
        return overdueCustnumRatio;
    }

    public void setOverdueCustnumRatio(BigDecimal overdueCustnumRatio) {
        this.overdueCustnumRatio = overdueCustnumRatio;
    }

    public BigDecimal getOver30Ratio() {
        return over30Ratio;
    }

    public void setOver30Ratio(BigDecimal over30Ratio) {
        this.over30Ratio = over30Ratio;
    }

    public String getXjYyRatioState() {
        return xjYyRatioState;
    }

    public void setXjYyRatioState(String xjYyRatioState) {
        this.xjYyRatioState = xjYyRatioState;
    }

    public String getYs90RatioState() {
        return ys90RatioState;
    }

    public void setYs90RatioState(String ys90RatioState) {
        this.ys90RatioState = ys90RatioState;
    }

    public String getHk15BgtRatioState() {
        return hk15BgtRatioState;
    }

    public void setHk15BgtRatioState(String hk15BgtRatioState) {
        this.hk15BgtRatioState = hk15BgtRatioState;
    }

    public String getYf90RatioState() {
        return yf90RatioState;
    }

    public void setYf90RatioState(String yf90RatioState) {
        this.yf90RatioState = yf90RatioState;
    }

    public String getSingleCustXsRatioState() {
        return singleCustXsRatioState;
    }

    public void setSingleCustXsRatioState(String singleCustXsRatioState) {
        this.singleCustXsRatioState = singleCustXsRatioState;
    }

    public String getPdDiffRatioState() {
        return pdDiffRatioState;
    }

    public void setPdDiffRatioState(String pdDiffRatioState) {
        this.pdDiffRatioState = pdDiffRatioState;
    }

    public String getBxPbRatioState() {
        return bxPbRatioState;
    }

    public void setBxPbRatioState(String bxPbRatioState) {
        this.bxPbRatioState = bxPbRatioState;
    }

    public String getPxDiffRatioState() {
        return pxDiffRatioState;
    }

    public void setPxDiffRatioState(String pxDiffRatioState) {
        this.pxDiffRatioState = pxDiffRatioState;
    }

    public String getOverdueAmtRatioState() {
        return overdueAmtRatioState;
    }

    public void setOverdueAmtRatioState(String overdueAmtRatioState) {
        this.overdueAmtRatioState = overdueAmtRatioState;
    }

    public String getOverdueCustnumRatioState() {
        return overdueCustnumRatioState;
    }

    public void setOverdueCustnumRatioState(String overdueCustnumRatioState) {
        this.overdueCustnumRatioState = overdueCustnumRatioState;
    }

    public String getOver30RatioState() {
        return over30RatioState;
    }

    public void setOver30RatioState(String over30RatioState) {
        this.over30RatioState = over30RatioState;
    }
}
