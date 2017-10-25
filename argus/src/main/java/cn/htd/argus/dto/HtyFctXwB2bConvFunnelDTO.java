package cn.htd.argus.dto;

import java.math.BigDecimal;

/**
 * @author suntao
 * @since 2017/10/16
 */
/* 用户行为B2B商城转化漏斗 */
public class HtyFctXwB2bConvFunnelDTO {
	private Long id;
	private String dateKey;// 购买日期
	private String stepName;// 漏斗关键路径的访问步骤
	private BigDecimal stepSequence;// 该访问步骤在漏斗关键路径的次序
	private String custId;// 客户ID
	private String countryName;// 客户访问IP所在的国家
	private String provinceName;// 客户访问IP所在的省
	private String cityName;// 客户访问IP所在的市
	private BigDecimal etlDate;// 运行日期，如：20170816
	private String etlTime;// 运行时间 年月日时分秒，如：20170816121212

	public HtyFctXwB2bConvFunnelDTO() {
	}

	public HtyFctXwB2bConvFunnelDTO(Long id, String dateKey, String stepName, BigDecimal stepSequence, String custId,
			String countryName, String provinceName, String cityName, BigDecimal etlDate, String etlTime) {
		super();
		this.id = id;
		this.dateKey = dateKey;
		this.stepName = stepName;
		this.stepSequence = stepSequence;
		this.custId = custId;
		this.countryName = countryName;
		this.provinceName = provinceName;
		this.cityName = cityName;
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

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public BigDecimal getStepSequence() {
		return stepSequence;
	}

	public void setStepSequence(BigDecimal stepSequence) {
		this.stepSequence = stepSequence;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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
		return "HtyFctXwB2bConvFunnelDTO [id=" + id + ", dateKey=" + dateKey + ", stepName=" + stepName
				+ ", stepSequence=" + stepSequence + ", custId=" + custId + ", countryName=" + countryName
				+ ", provinceName=" + provinceName + ", cityName=" + cityName + ", etlDate=" + etlDate + ", etlTime="
				+ etlTime + "]";
	}
}
