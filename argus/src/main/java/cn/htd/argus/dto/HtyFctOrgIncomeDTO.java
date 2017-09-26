package dto;

import java.math.BigDecimal;

public class HtyFctOrgIncomeDTO {
    private Long id;

    private String yearMon;

    private String orgCode;

    private BigDecimal monBusincomeAmt;

    private BigDecimal lastMonBusincomeAmt;

    private BigDecimal yearBusincomeAmt;

    private BigDecimal lastyearBusincomeAmt;

    private BigDecimal monInvoicingAmt;

    private BigDecimal yearInvoicingAmt;

    private BigDecimal lastMonInvoicingAmt;

    private BigDecimal lastYearInvoicingAmt;

    private BigDecimal monServiceAmt;

    private BigDecimal yearServiceAmt;

    private BigDecimal lastMonServiceAmt;

    private BigDecimal lastYearServiceAmt;

    private BigDecimal monFinanceAmt;

    private BigDecimal yearFinanceAmt;

    private BigDecimal lastMonFinanceAmt;

    private BigDecimal lastYearFinanceAmt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYearMon() {
        return yearMon;
    }

    public void setYearMon(String yearMon) {
        this.yearMon = yearMon == null ? null : yearMon.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public BigDecimal getMonBusincomeAmt() {
        return monBusincomeAmt;
    }

    public void setMonBusincomeAmt(BigDecimal monBusincomeAmt) {
        this.monBusincomeAmt = monBusincomeAmt;
    }

    public BigDecimal getLastMonBusincomeAmt() {
        return lastMonBusincomeAmt;
    }

    public void setLastMonBusincomeAmt(BigDecimal lastMonBusincomeAmt) {
        this.lastMonBusincomeAmt = lastMonBusincomeAmt;
    }

    public BigDecimal getYearBusincomeAmt() {
        return yearBusincomeAmt;
    }

    public void setYearBusincomeAmt(BigDecimal yearBusincomeAmt) {
        this.yearBusincomeAmt = yearBusincomeAmt;
    }

    public BigDecimal getLastyearBusincomeAmt() {
        return lastyearBusincomeAmt;
    }

    public void setLastyearBusincomeAmt(BigDecimal lastyearBusincomeAmt) {
        this.lastyearBusincomeAmt = lastyearBusincomeAmt;
    }

    public BigDecimal getMonInvoicingAmt() {
        return monInvoicingAmt;
    }

    public void setMonInvoicingAmt(BigDecimal monInvoicingAmt) {
        this.monInvoicingAmt = monInvoicingAmt;
    }

    public BigDecimal getYearInvoicingAmt() {
        return yearInvoicingAmt;
    }

    public void setYearInvoicingAmt(BigDecimal yearInvoicingAmt) {
        this.yearInvoicingAmt = yearInvoicingAmt;
    }

    public BigDecimal getLastMonInvoicingAmt() {
        return lastMonInvoicingAmt;
    }

    public void setLastMonInvoicingAmt(BigDecimal lastMonInvoicingAmt) {
        this.lastMonInvoicingAmt = lastMonInvoicingAmt;
    }

    public BigDecimal getLastYearInvoicingAmt() {
        return lastYearInvoicingAmt;
    }

    public void setLastYearInvoicingAmt(BigDecimal lastYearInvoicingAmt) {
        this.lastYearInvoicingAmt = lastYearInvoicingAmt;
    }

    public BigDecimal getMonServiceAmt() {
        return monServiceAmt;
    }

    public void setMonServiceAmt(BigDecimal monServiceAmt) {
        this.monServiceAmt = monServiceAmt;
    }

    public BigDecimal getYearServiceAmt() {
        return yearServiceAmt;
    }

    public void setYearServiceAmt(BigDecimal yearServiceAmt) {
        this.yearServiceAmt = yearServiceAmt;
    }

    public BigDecimal getLastMonServiceAmt() {
        return lastMonServiceAmt;
    }

    public void setLastMonServiceAmt(BigDecimal lastMonServiceAmt) {
        this.lastMonServiceAmt = lastMonServiceAmt;
    }

    public BigDecimal getLastYearServiceAmt() {
        return lastYearServiceAmt;
    }

    public void setLastYearServiceAmt(BigDecimal lastYearServiceAmt) {
        this.lastYearServiceAmt = lastYearServiceAmt;
    }

    public BigDecimal getMonFinanceAmt() {
        return monFinanceAmt;
    }

    public void setMonFinanceAmt(BigDecimal monFinanceAmt) {
        this.monFinanceAmt = monFinanceAmt;
    }

    public BigDecimal getYearFinanceAmt() {
        return yearFinanceAmt;
    }

    public void setYearFinanceAmt(BigDecimal yearFinanceAmt) {
        this.yearFinanceAmt = yearFinanceAmt;
    }

    public BigDecimal getLastMonFinanceAmt() {
        return lastMonFinanceAmt;
    }

    public void setLastMonFinanceAmt(BigDecimal lastMonFinanceAmt) {
        this.lastMonFinanceAmt = lastMonFinanceAmt;
    }

    public BigDecimal getLastYearFinanceAmt() {
        return lastYearFinanceAmt;
    }

    public void setLastYearFinanceAmt(BigDecimal lastYearFinanceAmt) {
        this.lastYearFinanceAmt = lastYearFinanceAmt;
    }
}