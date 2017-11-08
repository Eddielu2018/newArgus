package cn.htd.argus.bean;

import java.math.BigDecimal;

/**
 * Created by wangtp on 2017/11/8.
 */
public class DupontRadarDTO {
    //整体
    private BigDecimal whole;
    //利润
    private BigDecimal profit;
    //偿债
    private BigDecimal sinking;
    //运营
    private BigDecimal operate;
    //成长
    private BigDecimal grow;

    public BigDecimal getWhole() {
        return whole;
    }

    public void setWhole(BigDecimal whole) {
        this.whole = whole;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getSinking() {
        return sinking;
    }

    public void setSinking(BigDecimal sinking) {
        this.sinking = sinking;
    }

    public BigDecimal getOperate() {
        return operate;
    }

    public void setOperate(BigDecimal operate) {
        this.operate = operate;
    }

    public BigDecimal getGrow() {
        return grow;
    }

    public void setGrow(BigDecimal grow) {
        this.grow = grow;
    }
}
