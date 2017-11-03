package cn.htd.argus.dto;

import java.math.BigDecimal;

/**
 * @author suntao
 * @since 2017/10/16
 */
/* 用户行为B2B商城落地页 */
public class HtyFctXwB2bLndPageDTO {
	private Long id;
	private String dateKey;// 访问日期
	private String pagePath;// 页面路径
	private String pageTitle;// 页面标题
	private String countryName;// 客户访问IP所在的国家
	private String provinceName;// 客户访问IP所在的省
	private String cityName;// 客户访问IP所在的市
	private BigDecimal accessQty;// 访问量
	private BigDecimal etlDate;// 运行日期，如：20170816
	private String etlTime;// 运行时间 年月日时分秒，如：20170816121212

	public HtyFctXwB2bLndPageDTO() {
		super();
	}

	public HtyFctXwB2bLndPageDTO(Long id, String dateKey, String pagePath, String pageTitle, String countryName,
			String provinceName, String cityName, BigDecimal accessQty, BigDecimal etlDate, String etlTime) {
		super();
		this.id = id;
		this.dateKey = dateKey;
		this.pagePath = pagePath;
		this.pageTitle = pageTitle;
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

	public String getPagePath() {
		return pagePath;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
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
}
