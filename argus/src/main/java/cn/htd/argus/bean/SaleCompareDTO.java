package cn.htd.argus.bean;

import java.math.BigDecimal;

/**
 * Created by wangtp on 2017/10/16.
 */
public class SaleCompareDTO {
    private BigDecimal xsAmt;

    private Integer xsQty;

    private BigDecimal xsMl;

    private BigDecimal xsLr;

    private Integer xsRanking;

    //上期
    private BigDecimal upperXsAmt;

    private Integer upperXsQty;

    private BigDecimal upperXsMl;

    private BigDecimal upperXsLr;

    private Integer upperXsRanking;

    //同比
    private BigDecimal xsAmtAn;

    private BigDecimal xsQtyAn;

    private BigDecimal xsMlAn;

    private BigDecimal xsLrAn;

    private BigDecimal xsRankingAn;

    //排序
    private String xsAmtSort;

    private String xsQtySort;

    private String xsMlSort;

    private String xsLrSort;

    private String xsRankingSort;

    public BigDecimal getXsAmt() {
        return xsAmt;
    }

    public void setXsAmt(BigDecimal xsAmt) {
        this.xsAmt = xsAmt;
    }

    public Integer getXsQty() {
        return xsQty;
    }

    public void setXsQty(Integer xsQty) {
        this.xsQty = xsQty;
    }

    public BigDecimal getXsMl() {
        return xsMl;
    }

    public void setXsMl(BigDecimal xsMl) {
        this.xsMl = xsMl;
    }

    public BigDecimal getXsLr() {
        return xsLr;
    }

    public void setXsLr(BigDecimal xsLr) {
        this.xsLr = xsLr;
    }

    public BigDecimal getUpperXsAmt() {
        return upperXsAmt;
    }

    public void setUpperXsAmt(BigDecimal upperXsAmt) {
        this.upperXsAmt = upperXsAmt;
    }

    public Integer getUpperXsQty() {
        return upperXsQty;
    }

    public void setUpperXsQty(Integer upperXsQty) {
        this.upperXsQty = upperXsQty;
    }

    public BigDecimal getUpperXsMl() {
        return upperXsMl;
    }

    public void setUpperXsMl(BigDecimal upperXsMl) {
        this.upperXsMl = upperXsMl;
    }

    public BigDecimal getUpperXsLr() {
        return upperXsLr;
    }

    public void setUpperXsLr(BigDecimal upperXsLr) {
        this.upperXsLr = upperXsLr;
    }

    public BigDecimal getXsAmtAn() {
        return xsAmtAn;
    }

    public void setXsAmtAn(BigDecimal xsAmtAn) {
        this.xsAmtAn = xsAmtAn;
    }

    public BigDecimal getXsQtyAn() {
        return xsQtyAn;
    }

    public void setXsQtyAn(BigDecimal xsQtyAn) {
        this.xsQtyAn = xsQtyAn;
    }

    public BigDecimal getXsMlAn() {
        return xsMlAn;
    }

    public void setXsMlAn(BigDecimal xsMlAn) {
        this.xsMlAn = xsMlAn;
    }

    public BigDecimal getXsLrAn() {
        return xsLrAn;
    }

    public void setXsLrAn(BigDecimal xsLrAn) {
        this.xsLrAn = xsLrAn;
    }

    public BigDecimal getXsRankingAn() {
        return xsRankingAn;
    }

    public void setXsRankingAn(BigDecimal xsRankingAn) {
        this.xsRankingAn = xsRankingAn;
    }

    public String getXsAmtSort() {
        return xsAmtSort;
    }

    public void setXsAmtSort(String xsAmtSort) {
        this.xsAmtSort = xsAmtSort;
    }

    public String getXsQtySort() {
        return xsQtySort;
    }

    public void setXsQtySort(String xsQtySort) {
        this.xsQtySort = xsQtySort;
    }

    public String getXsMlSort() {
        return xsMlSort;
    }

    public void setXsMlSort(String xsMlSort) {
        this.xsMlSort = xsMlSort;
    }

    public String getXsLrSort() {
        return xsLrSort;
    }

    public void setXsLrSort(String xsLrSort) {
        this.xsLrSort = xsLrSort;
    }

    public String getXsRankingSort() {
        return xsRankingSort;
    }

    public void setXsRankingSort(String xsRankingSort) {
        this.xsRankingSort = xsRankingSort;
    }

    public Integer getXsRanking() {
        return xsRanking;
    }

    public void setXsRanking(Integer xsRanking) {
        this.xsRanking = xsRanking;
    }

    public Integer getUpperXsRanking() {
        return upperXsRanking;
    }

    public void setUpperXsRanking(Integer upperXsRanking) {
        this.upperXsRanking = upperXsRanking;
    }
}
