package cn.htd.argus.bean;

import java.math.BigDecimal;

/**
 * Created by wangtp on 2017/11/9.
 */
public class FinanceDTO {
    //1.实际值
    //1.1EDW_FCT_L2_OKR_KPI_FINANCE
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

    //1.2EDW_FCT_ZSD_FINANCE
    //平台金融服务逾期金额率
    private BigDecimal overdueAmtRatio;
    //供应链金融逾期家数占比
    private BigDecimal overdueCustnumRatio;
    //超30天个人借款占比
    private BigDecimal over30Ratio;


    //2.异常状态0：正常 1：异常
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

    //平台金融服务逾期金额率
    private String overdueAmtRatioState;
    //供应链金融逾期家数占比
    private String overdueCustnumRatioState;
    //超30天个人借款占比
    private String over30RatioState;

    //3,参考值
    //收现金营业款占比（收款）
    private BigDecimal xjYyRatioRe;
    //超90天应收占比
    private BigDecimal ys90RatioRe;
    //前15天回款预算完成率
    private BigDecimal hk15BgtRatioRe;
    //超90天预付占比
    private BigDecimal yf90RatioRe;
    //单客户销售占比
    private BigDecimal singleCustXsRatioRe;
    //盘点差异率
    private BigDecimal pdDiffRatioRe;
    //保险配比率最大值
    private BigDecimal bxPbRatioReMax;
    //保险配比率最小值
    private BigDecimal bxPbRatioReMin;
    //坪效差异率
    private BigDecimal pxDiffRatioRe;

    //平台金融服务逾期金额率
    private BigDecimal overdueAmtRatioRe;
    //供应链金融逾期家数占比
    private BigDecimal overdueCustnumRatioRe;
    //超30天个人借款占比
    private BigDecimal over30RatioRe;

    //需要关注数量
    private Integer num;
    //分数
    private BigDecimal score;



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

    public BigDecimal getXjYyRatioRe() {
        return xjYyRatioRe;
    }

    public void setXjYyRatioRe(BigDecimal xjYyRatioRe) {
        this.xjYyRatioRe = xjYyRatioRe;
    }

    public BigDecimal getYs90RatioRe() {
        return ys90RatioRe;
    }

    public void setYs90RatioRe(BigDecimal ys90RatioRe) {
        this.ys90RatioRe = ys90RatioRe;
    }

    public BigDecimal getHk15BgtRatioRe() {
        return hk15BgtRatioRe;
    }

    public void setHk15BgtRatioRe(BigDecimal hk15BgtRatioRe) {
        this.hk15BgtRatioRe = hk15BgtRatioRe;
    }

    public BigDecimal getYf90RatioRe() {
        return yf90RatioRe;
    }

    public void setYf90RatioRe(BigDecimal yf90RatioRe) {
        this.yf90RatioRe = yf90RatioRe;
    }

    public BigDecimal getSingleCustXsRatioRe() {
        return singleCustXsRatioRe;
    }

    public void setSingleCustXsRatioRe(BigDecimal singleCustXsRatioRe) {
        this.singleCustXsRatioRe = singleCustXsRatioRe;
    }

    public BigDecimal getPdDiffRatioRe() {
        return pdDiffRatioRe;
    }

    public void setPdDiffRatioRe(BigDecimal pdDiffRatioRe) {
        this.pdDiffRatioRe = pdDiffRatioRe;
    }

    public BigDecimal getBxPbRatioReMax() {
        return bxPbRatioReMax;
    }

    public void setBxPbRatioReMax(BigDecimal bxPbRatioReMax) {
        this.bxPbRatioReMax = bxPbRatioReMax;
    }

    public BigDecimal getBxPbRatioReMin() {
        return bxPbRatioReMin;
    }

    public void setBxPbRatioReMin(BigDecimal bxPbRatioReMin) {
        this.bxPbRatioReMin = bxPbRatioReMin;
    }

    public BigDecimal getPxDiffRatioRe() {
        return pxDiffRatioRe;
    }

    public void setPxDiffRatioRe(BigDecimal pxDiffRatioRe) {
        this.pxDiffRatioRe = pxDiffRatioRe;
    }

    public BigDecimal getOverdueAmtRatioRe() {
        return overdueAmtRatioRe;
    }

    public void setOverdueAmtRatioRe(BigDecimal overdueAmtRatioRe) {
        this.overdueAmtRatioRe = overdueAmtRatioRe;
    }

    public BigDecimal getOverdueCustnumRatioRe() {
        return overdueCustnumRatioRe;
    }

    public void setOverdueCustnumRatioRe(BigDecimal overdueCustnumRatioRe) {
        this.overdueCustnumRatioRe = overdueCustnumRatioRe;
    }

    public BigDecimal getOver30RatioRe() {
        return over30RatioRe;
    }

    public void setOver30RatioRe(BigDecimal over30RatioRe) {
        this.over30RatioRe = over30RatioRe;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
