package cn.htd.argus.dto;

import java.math.BigDecimal;

/**
 * @author suntao
 * @since 2017/10/16
 */
/* 用户行为B2B商城成交单品 */
public class HtyFctSaleCityProdDTO {
	private Long id;
	private String dateKey;// 日期
	private String custProName;// 省份
	private String custCityName;// 市
	private String custCountryName;// 区/县
	private String custTownName;// 镇
	private String plCode;// 品类代码
	private String plName;// 品类名称
	private String ppCode;// 品牌代码
	private String ppName;// 品牌名称
	private String prodCode;// 产品代码
	private String prodName;// 产品名称
	private BigDecimal xsAmt;// 销售金额
	private BigDecimal xsQty;// 销售数量
	private BigDecimal etlDate;// 交换日期
	private String etlTime;// 交换时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateKey() {
        return dateKey;
    }

    public void setDateKey(String dateKey) {
        this.dateKey = dateKey;
    }

    public String getCustProName() {
        return custProName;
    }

    public void setCustProName(String custProName) {
        this.custProName = custProName;
    }

    public String getCustCityName() {
        return custCityName;
    }

    public void setCustCityName(String custCityName) {
        this.custCityName = custCityName;
    }

    public String getCustCountryName() {
        return custCountryName;
    }

    public void setCustCountryName(String custCountryName) {
        this.custCountryName = custCountryName;
    }

    public String getCustTownName() {
        return custTownName;
    }

    public void setCustTownName(String custTownName) {
        this.custTownName = custTownName;
    }

    public String getPlCode() {
        return plCode;
    }

    public void setPlCode(String plCode) {
        this.plCode = plCode;
    }

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName;
    }

    public String getPpCode() {
        return ppCode;
    }

    public void setPpCode(String ppCode) {
        this.ppCode = ppCode;
    }

    public String getPpName() {
        return ppName;
    }

    public void setPpName(String ppName) {
        this.ppName = ppName;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public BigDecimal getXsAmt() {
        return xsAmt;
    }

    public void setXsAmt(BigDecimal xsAmt) {
        this.xsAmt = xsAmt;
    }

    public BigDecimal getXsQty() {
        return xsQty;
    }

    public void setXsQty(BigDecimal xsQty) {
        this.xsQty = xsQty;
    }

    public BigDecimal getEtlDate() {
        return etlDate;
    }

    public void setEtlDate(BigDecimal etlDate) {
        this.etlDate = etlDate;
    }

    public String getEtlTime() {
        return etlTime;
    }

    public void setEtlTime(String etlTime) {
        this.etlTime = etlTime;
    }
}
