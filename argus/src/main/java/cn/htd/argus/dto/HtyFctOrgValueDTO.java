package dto;

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
}