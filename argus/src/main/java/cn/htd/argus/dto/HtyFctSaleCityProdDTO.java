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
	private String custProname;// 省份
	private String custCityname;// 市
	private String custCountryname;// 区/县
	private String custTownname;// 镇
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

	public HtyFctSaleCityProdDTO() {
	}

	public HtyFctSaleCityProdDTO(Long id, String dateKey, String custProname, String custCityname,
			String custCountryname, String custTownname, String plCode, String plName, String ppCode, String ppName,
			String prodCode, String prodName, BigDecimal xsAmt, BigDecimal xsQty, BigDecimal etlDate, String etlTime) {
		super();
		this.id = id;
		this.dateKey = dateKey;
		this.custProname = custProname;
		this.custCityname = custCityname;
		this.custCountryname = custCountryname;
		this.custTownname = custTownname;
		this.plCode = plCode;
		this.plName = plName;
		this.ppCode = ppCode;
		this.ppName = ppName;
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.xsAmt = xsAmt;
		this.xsQty = xsQty;
		this.etlDate = etlDate;
		this.etlTime = etlTime;
	}

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

	public String getCustProname() {
		return custProname;
	}

	public void setCustProname(String custProname) {
		this.custProname = custProname;
	}

	public String getCustCityname() {
		return custCityname;
	}

	public void setCustCityname(String custCityname) {
		this.custCityname = custCityname;
	}

	public String getCustCountryname() {
		return custCountryname;
	}

	public void setCustCountryname(String custCountryname) {
		this.custCountryname = custCountryname;
	}

	public String getCustTownname() {
		return custTownname;
	}

	public void setCustTownname(String custTownname) {
		this.custTownname = custTownname;
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

	@Override
	public String toString() {
		return "HtyFctSaleCityProdDTO [id=" + id + ", dateKey=" + dateKey + ", custProname=" + custProname
				+ ", custCityname=" + custCityname + ", custCountryname=" + custCountryname + ", custTownname="
				+ custTownname + ", plCode=" + plCode + ", plName=" + plName + ", ppCode=" + ppCode + ", ppName="
				+ ppName + ", prodCode=" + prodCode + ", prodName=" + prodName + ", xsAmt=" + xsAmt + ", xsQty=" + xsQty
				+ ", etlDate=" + etlDate + ", etlTime=" + etlTime + "]";
	}
}
