package cn.htd.argus.dto;

import java.math.BigDecimal;

/**
 * @author suntao
 * @since 2017/10/16
 */
/* 用户行为B2B商城搜索词 */
public class HtyFctXwB2bSearchKeyDTO {
	private Long id;
	private String dateKey;// 搜索日期
	private String searchKeyword;// 搜索词
	private String searchType;// 搜索类型：商品，供应商
	private String countryName;// 客户访问IP所在的国家
	private String provinceName;// 客户访问IP所在的省
	private String cityName;// 客户访问IP所在的市
	private BigDecimal searchQty;// 搜索量
	private BigDecimal etlDate;// 运行日期，如：20170816
	private String etlTime;// 运行时间 年月日时分秒，如：20170816121212

	public HtyFctXwB2bSearchKeyDTO() {
	}

	public HtyFctXwB2bSearchKeyDTO(Long id, String dateKey, String searchKeyword, String searchType, String countryName,
			String provinceName, String cityName, BigDecimal searchQty, BigDecimal etlDate, String etlTime) {
		super();
		this.id = id;
		this.dateKey = dateKey;
		this.searchKeyword = searchKeyword;
		this.searchType = searchType;
		this.countryName = countryName;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.searchQty = searchQty;
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

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
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

	public BigDecimal getSearchQty() {
		return searchQty;
	}

	public void setSearchQty(BigDecimal searchQty) {
		this.searchQty = searchQty;
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
		return "HtyFctXwB2bSearchKeyDTO [id=" + id + ", dateKey=" + dateKey + ", searchKeyword=" + searchKeyword
				+ ", searchType=" + searchType + ", countryName=" + countryName + ", provinceName=" + provinceName
				+ ", cityName=" + cityName + ", searchQty=" + searchQty + ", etlDate=" + etlDate + ", etlTime="
				+ etlTime + "]";
	}
}
