package cn.htd.argus.dto;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/10/30.
 */
public class HtyFctOrgMemberDetailDTO {
    private Long id;
    private String dateKey;
    private String orgCode;
    private String custCode;
    private BigDecimal xsAmt;
    private BigDecimal xsQty;
    private String lastDate;
    private int sortType;
    private String custName;
    private int outType;
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

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
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

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

	public int getSortType() {
		return sortType;
	}

	public void setSortType(int sortType) {
		this.sortType = sortType;
	}
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getOutType() {
		return outType;
	}

	public void setOutType(int outType) {
		this.outType = outType;
	}
    
}
