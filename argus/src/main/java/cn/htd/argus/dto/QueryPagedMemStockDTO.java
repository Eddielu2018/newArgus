package cn.htd.argus.dto;

import java.io.Serializable;

public class QueryPagedMemStockDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6786335589747823884L;
	private String companyCode;
	private Integer pageSize;
	private Integer pageNo;
	private String memberNameOrCode;
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public String getMemberNameOrCode() {
		return memberNameOrCode;
	}
	public void setMemberNameOrCode(String memberNameOrCode) {
		this.memberNameOrCode = memberNameOrCode;
	}

}
