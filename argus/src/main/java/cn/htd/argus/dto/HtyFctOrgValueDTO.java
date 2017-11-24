package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctOrgValueDTO {
    private Long id;

    private String yearmon;

    private String orgCode;

    private Integer ptgz;

    private BigDecimal psgz;

    private BigDecimal pegz;

    private BigDecimal pbgz;

    private BigDecimal cvmgz;

    private BigDecimal zhnl;

    private Integer fbpm;

    private Integer ztpm;

    private BigDecimal starNum;
    
    private BigDecimal maxZhnl;
    
    private BigDecimal maxPbgz;
    
    private BigDecimal maxPsgz;
    
    private BigDecimal maxPegz;
    
    private BigDecimal maxCvmgz;
    
    private BigDecimal nowZhnl;
    
    private BigDecimal nowPbgz;
    
    private BigDecimal nowPsgz;
    
    private BigDecimal nowPegz;
    
    private BigDecimal nowCvmgz;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYearmon() {
        return yearmon;
    }

    public void setYearmon(String yearmon) {
        this.yearmon = yearmon == null ? null : yearmon.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public Integer getPtgz() {
        return ptgz;
    }

    public void setPtgz(Integer ptgz) {
        this.ptgz = ptgz;
    }

    public BigDecimal getPsgz() {
        return psgz;
    }

    public void setPsgz(BigDecimal psgz) {
        this.psgz = psgz;
    }

    public BigDecimal getPegz() {
        return pegz;
    }

    public void setPegz(BigDecimal pegz) {
        this.pegz = pegz;
    }

    public BigDecimal getPbgz() {
        return pbgz;
    }

    public void setPbgz(BigDecimal pbgz) {
        this.pbgz = pbgz;
    }

    public BigDecimal getCvmgz() {
        return cvmgz;
    }

    public void setCvmgz(BigDecimal cvmgz) {
        this.cvmgz = cvmgz;
    }

    public BigDecimal getZhnl() {
        return zhnl;
    }

    public void setZhnl(BigDecimal zhnl) {
        this.zhnl = zhnl;
    }

    public Integer getFbpm() {
        return fbpm;
    }

    public void setFbpm(Integer fbpm) {
        this.fbpm = fbpm;
    }

    public Integer getZtpm() {
        return ztpm;
    }

    public void setZtpm(Integer ztpm) {
        this.ztpm = ztpm;
    }

	public BigDecimal getStarNum() {
		return starNum;
	}

	public void setStarNum(BigDecimal starNum) {
		this.starNum = starNum;
	}

	public BigDecimal getMaxZhnl() {
		return maxZhnl;
	}

	public void setMaxZhnl(BigDecimal maxZhnl) {
		this.maxZhnl = maxZhnl;
	}

	public BigDecimal getMaxPbgz() {
		return maxPbgz;
	}

	public void setMaxPbgz(BigDecimal maxPbgz) {
		this.maxPbgz = maxPbgz;
	}

	public BigDecimal getMaxPsgz() {
		return maxPsgz;
	}

	public void setMaxPsgz(BigDecimal maxPsgz) {
		this.maxPsgz = maxPsgz;
	}

	public BigDecimal getMaxPegz() {
		return maxPegz;
	}

	public void setMaxPegz(BigDecimal maxPegz) {
		this.maxPegz = maxPegz;
	}

	public BigDecimal getMaxCvmgz() {
		return maxCvmgz;
	}

	public void setMaxCvmgz(BigDecimal maxCvmgz) {
		this.maxCvmgz = maxCvmgz;
	}

	public BigDecimal getNowZhnl() {
		return nowZhnl;
	}

	public void setNowZhnl(BigDecimal nowZhnl) {
		this.nowZhnl = nowZhnl;
	}

	public BigDecimal getNowPbgz() {
		return nowPbgz;
	}

	public void setNowPbgz(BigDecimal nowPbgz) {
		this.nowPbgz = nowPbgz;
	}

	public BigDecimal getNowPsgz() {
		return nowPsgz;
	}

	public void setNowPsgz(BigDecimal nowPsgz) {
		this.nowPsgz = nowPsgz;
	}

	public BigDecimal getNowPegz() {
		return nowPegz;
	}

	public void setNowPegz(BigDecimal nowPegz) {
		this.nowPegz = nowPegz;
	}

	public BigDecimal getNowCvmgz() {
		return nowCvmgz;
	}

	public void setNowCvmgz(BigDecimal nowCvmgz) {
		this.nowCvmgz = nowCvmgz;
	}
	
}