package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctProdDetailOrgDTO {

    //排名
    private String rn;
    //时间
    private String statDay;
    //平台公司代码
    private String orgCode;
    //平台公司名称
    private String orgFname;
    //商品编码
    private String prodCode;
    //商品名称
    private String prodFname;
    //品牌代码
    private String ppCode;
    //品牌名称
    private String ppName;
    //商品一级类目代码
    private String plCodeLv1;
    //商品一级类目名称
    private String plNameLv1;
    //商品二级类目代码
    private String plCodeLv2;
    //商品二级类目名称
    private String plNameLv2;
    //商品三级类目代码
    private String plCodeLv3;
    //商品三级类目名称
    private String plNameLv3;
    //销售渠道
    private String saleFlag;
    //当年销售金额
    private BigDecimal saleAmtYear;
    //当年销售数量
    private BigDecimal saleQvtYear;
    //当年所有商品销售金额
    private BigDecimal saleAmtAll;
    //销售额占比
    private BigDecimal saleAvg;

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

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

    public String getSaleFlag() {
        return saleFlag;
    }

    public void setSaleFlag(String saleFlag) {
        this.saleFlag = saleFlag == null ? null : saleFlag.trim();
    }

    public BigDecimal getSaleAmtYear() {
        return saleAmtYear;
    }

    public void setSaleAmtYear(BigDecimal saleAmtYear) {
        this.saleAmtYear = saleAmtYear;
    }

    public BigDecimal getSaleQvtYear() {
        return saleQvtYear;
    }

    public void setSaleQvtYear(BigDecimal saleQvtYear) {
        this.saleQvtYear = saleQvtYear;
    }

    public BigDecimal getSaleAmtAll() {
        return saleAmtAll;
    }

    public void setSaleAmtAll(BigDecimal saleAmtAll) {
        this.saleAmtAll = saleAmtAll;
    }

    public BigDecimal getSaleAvg() {
        return saleAvg;
    }

    public void setSaleAvg(BigDecimal saleAvg) {
        this.saleAvg = saleAvg;
    }
}