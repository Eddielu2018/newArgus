package cn.htd.argus.bean;

import java.math.BigDecimal;

/**
 * Created by wangtp on 2017/12/18.
 */
public class GoodsAllHeadDTO {
    //商品总数
    private BigDecimal prodNum;
    //下架商品
    private BigDecimal prodNumDown;
    //有销售记录商品
    private BigDecimal prodNumSale;
    //包厢上架数
    private BigDecimal prodNumBx;
    //区域上架数
    private BigDecimal prodNumQy;

    //商品总数环比
    private BigDecimal prodNumWk;
    //下架商品环比
    private BigDecimal prodNumDownWk;
    //有销售记录商品环比
    private BigDecimal prodNumSaleWk;
    //包厢上架数环比
    private BigDecimal prodNumBxWk;
    //区域上架数环比
    private BigDecimal prodNumQyWk;

    public BigDecimal getProdNum() {
        return prodNum;
    }

    public void setProdNum(BigDecimal prodNum) {
        this.prodNum = prodNum;
    }

    public BigDecimal getProdNumDown() {
        return prodNumDown;
    }

    public void setProdNumDown(BigDecimal prodNumDown) {
        this.prodNumDown = prodNumDown;
    }

    public BigDecimal getProdNumSale() {
        return prodNumSale;
    }

    public void setProdNumSale(BigDecimal prodNumSale) {
        this.prodNumSale = prodNumSale;
    }

    public BigDecimal getProdNumBx() {
        return prodNumBx;
    }

    public void setProdNumBx(BigDecimal prodNumBx) {
        this.prodNumBx = prodNumBx;
    }

    public BigDecimal getProdNumQy() {
        return prodNumQy;
    }

    public void setProdNumQy(BigDecimal prodNumQy) {
        this.prodNumQy = prodNumQy;
    }

    public BigDecimal getProdNumWk() {
        return prodNumWk;
    }

    public void setProdNumWk(BigDecimal prodNumWk) {
        this.prodNumWk = prodNumWk;
    }

    public BigDecimal getProdNumDownWk() {
        return prodNumDownWk;
    }

    public void setProdNumDownWk(BigDecimal prodNumDownWk) {
        this.prodNumDownWk = prodNumDownWk;
    }

    public BigDecimal getProdNumSaleWk() {
        return prodNumSaleWk;
    }

    public void setProdNumSaleWk(BigDecimal prodNumSaleWk) {
        this.prodNumSaleWk = prodNumSaleWk;
    }

    public BigDecimal getProdNumBxWk() {
        return prodNumBxWk;
    }

    public void setProdNumBxWk(BigDecimal prodNumBxWk) {
        this.prodNumBxWk = prodNumBxWk;
    }

    public BigDecimal getProdNumQyWk() {
        return prodNumQyWk;
    }

    public void setProdNumQyWk(BigDecimal prodNumQyWk) {
        this.prodNumQyWk = prodNumQyWk;
    }
}
