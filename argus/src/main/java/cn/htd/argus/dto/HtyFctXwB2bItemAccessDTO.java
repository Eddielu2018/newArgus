package cn.htd.argus.dto;

import java.math.BigDecimal;

/**
 * @author suntao
 * @since 2017/10/16
 */
/* 用户行为B2B商城单品访问 */
public class HtyFctXwB2bItemAccessDTO {
	private Long id;
	private String dateKey;// 访问日期
	private String itemId;// 单品ID
	private String countryName;// 客户访问IP所在的国家
	private String provinceName;// 客户访问IP所在的省
	private String cityName;// 客户访问IP所在的市
	private BigDecimal accessQty;// 访问量
	private BigDecimal etlDate;// 运行日期，如：20170816
	private String etlTime;// 运行时间 年月日时分秒，如：20170816121212

	public HtyFctXwB2bItemAccessDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HtyFctXwB2bItemAccessDTO(Long id, String dateKey, String itemId, String countryName, String provinceName,
			String cityName, BigDecimal accessQty, BigDecimal etlDate, String etlTime) {
		super();
		this.id = id;
		this.dateKey = dateKey;
		this.itemId = itemId;
		this.countryName = countryName;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.accessQty = accessQty;
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

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
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

	public BigDecimal getAccessQty() {
		return accessQty;
	}

	public void setAccessQty(BigDecimal accessQty) {
		this.accessQty = accessQty;
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
		return "HtyFctXwB2bItemAccessDTO [id=" + id + ", dateKey=" + dateKey + ", itemId=" + itemId + ", countryName="
				+ countryName + ", provinceName=" + provinceName + ", cityName=" + cityName + ", accessQty=" + accessQty
				+ ", etlDate=" + etlDate + ", etlTime=" + etlTime + "]";
	}
}
