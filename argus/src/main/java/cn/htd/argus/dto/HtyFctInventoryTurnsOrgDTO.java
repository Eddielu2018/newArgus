package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctInventoryTurnsOrgDTO {
    //统计日期
    private String statDay;
    //平台公司代码
    private String orgCode;
    //平台公司名称
    private String orgFname;
    //商品编码
    private String prodCode;
    //商品名称
    private String prodFname;
    //商品一级类目代码
    private String plCodeLv1;
    //商品一级类目名称
    private String plNameLv1;
    //商品二级类目代码
    private String plCodeLv2;
    //商品二级类目代码
    private String plNameLv2;
    //商品三级类目代码
    private String plCodeLv3;
    //商品三级类目名称
    private String plNameLv3;
    //品牌代码
    private String ppCode;
    //品牌名称
    private String ppName;
    //实际库存数量
    private BigDecimal stockNumTrue;
    //库存金额
    private BigDecimal stockAmt;
    //不出货预计损失金额
    private BigDecimal lossAmt;
    //商品库存周转天数
    private String shelvesDate;
    //商品库存周转天数
    private BigDecimal turnDays;

    public String getStatDay() {
        return statDay;
    }

    public void setStatDay(String statDay) {
        this.statDay = statDay == null ? null : statDay.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgFname() {
        return orgFname;
    }

    public void setOrgFname(String orgFname) {
        this.orgFname = orgFname == null ? null : orgFname.trim();
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode == null ? null : prodCode.trim();
    }

    public String getProdFname() {
        return prodFname;
    }

    public void setProdFname(String prodFname) {
        this.prodFname = prodFname == null ? null : prodFname.trim();
    }

    public String getPlCodeLv1() {
        return plCodeLv1;
    }

    public void setPlCodeLv1(String plCodeLv1) {
        this.plCodeLv1 = plCodeLv1 == null ? null : plCodeLv1.trim();
    }

    public String getPlNameLv1() {
        return plNameLv1;
    }

    public void setPlNameLv1(String plNameLv1) {
        this.plNameLv1 = plNameLv1 == null ? null : plNameLv1.trim();
    }

    public String getPlCodeLv2() {
        return plCodeLv2;
    }

    public void setPlCodeLv2(String plCodeLv2) {
        this.plCodeLv2 = plCodeLv2 == null ? null : plCodeLv2.trim();
    }

    public String getPlNameLv2() {
        return plNameLv2;
    }

    public void setPlNameLv2(String plNameLv2) {
        this.plNameLv2 = plNameLv2 == null ? null : plNameLv2.trim();
    }

    public String getPlCodeLv3() {
        return plCodeLv3;
    }

    public void setPlCodeLv3(String plCodeLv3) {
        this.plCodeLv3 = plCodeLv3 == null ? null : plCodeLv3.trim();
    }

    public String getPlNameLv3() {
        return plNameLv3;
    }

    public void setPlNameLv3(String plNameLv3) {
        this.plNameLv3 = plNameLv3 == null ? null : plNameLv3.trim();
    }

    public String getPpCode() {
        return ppCode;
    }

    public void setPpCode(String ppCode) {
        this.ppCode = ppCode == null ? null : ppCode.trim();
    }

    public String getPpName() {
        return ppName;
    }

    public void setPpName(String ppName) {
        this.ppName = ppName == null ? null : ppName.trim();
    }

    public BigDecimal getStockNumTrue() {
        return stockNumTrue;
    }

    public void setStockNumTrue(BigDecimal stockNumTrue) {
        this.stockNumTrue = stockNumTrue;
    }

    public BigDecimal getStockAmt() {
        return stockAmt;
    }

    public void setStockAmt(BigDecimal stockAmt) {
        this.stockAmt = stockAmt;
    }

    public BigDecimal getLossAmt() {
        return lossAmt;
    }

    public void setLossAmt(BigDecimal lossAmt) {
        this.lossAmt = lossAmt;
    }

    public String getShelvesDate() {
        return shelvesDate;
    }

    public void setShelvesDate(String shelvesDate) {
        this.shelvesDate = shelvesDate == null ? null : shelvesDate.trim();
    }

    public BigDecimal getTurnDays() {
        return turnDays;
    }

    public void setTurnDays(BigDecimal turnDays) {
        this.turnDays = turnDays;
    }

}