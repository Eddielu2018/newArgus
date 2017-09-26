package dto;

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
}