package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctOrgSaleDTO {
    private Long id;

    private String orgCode;

    private String yearMon;

    private BigDecimal monAmt;

    private BigDecimal lastmonAmt;

    private BigDecimal yearAmt;

    private BigDecimal lastyearAmt;

    private BigDecimal monOnlineSaleamt;

    private BigDecimal yearOnlineSaleamt;

    private BigDecimal monWaitSaleamt;

    private BigDecimal yearWaitSaleamt;

    private BigDecimal monSpSaleamt;

    private BigDecimal yearSpSaleamt;
    
    private BigDecimal lastmonOnlineSaleamt;
    
    private BigDecimal lastyearOnlineSaleamt;
    
    private BigDecimal lastmonWaitSaleamt;
    
    private BigDecimal lastyearWaitSaleamt;
    
    private BigDecimal lastmonSpSaleamt;
    
    private BigDecimal lastyearSpSaleamt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getYearMon() {
        return yearMon;
    }

    public void setYearMon(String yearMon) {
        this.yearMon = yearMon == null ? null : yearMon.trim();
    }

    public BigDecimal getMonAmt() {
        return monAmt;
    }

    public void setMonAmt(BigDecimal monAmt) {
        this.monAmt = monAmt;
    }

    public BigDecimal getLastmonAmt() {
        return lastmonAmt;
    }

    public void setLastmonAmt(BigDecimal lastmonAmt) {
        this.lastmonAmt = lastmonAmt;
    }

    public BigDecimal getYearAmt() {
        return yearAmt;
    }

    public void setYearAmt(BigDecimal yearAmt) {
        this.yearAmt = yearAmt;
    }

    public BigDecimal getLastyearAmt() {
        return lastyearAmt;
    }

    public void setLastyearAmt(BigDecimal lastyearAmt) {
        this.lastyearAmt = lastyearAmt;
    }

    public BigDecimal getMonOnlineSaleamt() {
        return monOnlineSaleamt;
    }

    public void setMonOnlineSaleamt(BigDecimal monOnlineSaleamt) {
        this.monOnlineSaleamt = monOnlineSaleamt;
    }

    public BigDecimal getYearOnlineSaleamt() {
        return yearOnlineSaleamt;
    }

    public void setYearOnlineSaleamt(BigDecimal yearOnlineSaleamt) {
        this.yearOnlineSaleamt = yearOnlineSaleamt;
    }

    public BigDecimal getMonWaitSaleamt() {
        return monWaitSaleamt;
    }

    public void setMonWaitSaleamt(BigDecimal monWaitSaleamt) {
        this.monWaitSaleamt = monWaitSaleamt;
    }

    public BigDecimal getYearWaitSaleamt() {
        return yearWaitSaleamt;
    }

    public void setYearWaitSaleamt(BigDecimal yearWaitSaleamt) {
        this.yearWaitSaleamt = yearWaitSaleamt;
    }

    public BigDecimal getMonSpSaleamt() {
        return monSpSaleamt;
    }

    public void setMonSpSaleamt(BigDecimal monSpSaleamt) {
        this.monSpSaleamt = monSpSaleamt;
    }

    public BigDecimal getYearSpSaleamt() {
        return yearSpSaleamt;
    }

    public void setYearSpSaleamt(BigDecimal yearSpSaleamt) {
        this.yearSpSaleamt = yearSpSaleamt;
    }

	public BigDecimal getLastmonOnlineSaleamt() {
		return lastmonOnlineSaleamt;
	}

	public void setLastmonOnlineSaleamt(BigDecimal lastmonOnlineSaleamt) {
		this.lastmonOnlineSaleamt = lastmonOnlineSaleamt;
	}

	public BigDecimal getLastyearOnlineSaleamt() {
		return lastyearOnlineSaleamt;
	}

	public void setLastyearOnlineSaleamt(BigDecimal lastyearOnlineSaleamt) {
		this.lastyearOnlineSaleamt = lastyearOnlineSaleamt;
	}

	public BigDecimal getLastmonWaitSaleamt() {
		return lastmonWaitSaleamt;
	}

	public void setLastmonWaitSaleamt(BigDecimal lastmonWaitSaleamt) {
		this.lastmonWaitSaleamt = lastmonWaitSaleamt;
	}

	public BigDecimal getLastyearWaitSaleamt() {
		return lastyearWaitSaleamt;
	}

	public void setLastyearWaitSaleamt(BigDecimal lastyearWaitSaleamt) {
		this.lastyearWaitSaleamt = lastyearWaitSaleamt;
	}

	public BigDecimal getLastmonSpSaleamt() {
		return lastmonSpSaleamt;
	}

	public void setLastmonSpSaleamt(BigDecimal lastmonSpSaleamt) {
		this.lastmonSpSaleamt = lastmonSpSaleamt;
	}

	public BigDecimal getLastyearSpSaleamt() {
		return lastyearSpSaleamt;
	}

	public void setLastyearSpSaleamt(BigDecimal lastyearSpSaleamt) {
		this.lastyearSpSaleamt = lastyearSpSaleamt;
	}
    
}