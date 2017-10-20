package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctOrgCustIncomeSaleDTO {
    private Long id;

    private String orgCode;

    private String yearDate;

    private Integer custnum;

    private Integer transcustnum;

    private Integer actCustnum;

    private Integer vipNum;

    private BigDecimal busincomeAmt;

    private BigDecimal invoicingAmt;

    private BigDecimal serviceAmt;

    private BigDecimal financeAmt;

    private BigDecimal saleAmt;

    private BigDecimal onlineSaleamt;

    private BigDecimal prodSaleamt;

    private BigDecimal nonprodSaleamt;

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

    public String getYearDate() {
        return yearDate;
    }

    public void setYearDate(String yearDate) {
        this.yearDate = yearDate == null ? null : yearDate.trim();
    }

    public Integer getCustnum() {
        return custnum;
    }

    public void setCustnum(Integer custnum) {
        this.custnum = custnum;
    }

    public Integer getTranscustnum() {
        return transcustnum;
    }

    public void setTranscustnum(Integer transcustnum) {
        this.transcustnum = transcustnum;
    }

    public Integer getActCustnum() {
        return actCustnum;
    }

    public void setActCustnum(Integer actCustnum) {
        this.actCustnum = actCustnum;
    }

    public Integer getVipNum() {
        return vipNum;
    }

    public void setVipNum(Integer vipNum) {
        this.vipNum = vipNum;
    }

    public BigDecimal getBusincomeAmt() {
        return busincomeAmt;
    }

    public void setBusincomeAmt(BigDecimal busincomeAmt) {
        this.busincomeAmt = busincomeAmt;
    }

    public BigDecimal getInvoicingAmt() {
        return invoicingAmt;
    }

    public void setInvoicingAmt(BigDecimal invoicingAmt) {
        this.invoicingAmt = invoicingAmt;
    }

    public BigDecimal getServiceAmt() {
        return serviceAmt;
    }

    public void setServiceAmt(BigDecimal serviceAmt) {
        this.serviceAmt = serviceAmt;
    }

    public BigDecimal getFinanceAmt() {
        return financeAmt;
    }

    public void setFinanceAmt(BigDecimal financeAmt) {
        this.financeAmt = financeAmt;
    }

    public BigDecimal getSaleAmt() {
        return saleAmt;
    }

    public void setSaleAmt(BigDecimal saleAmt) {
        this.saleAmt = saleAmt;
    }

    public BigDecimal getOnlineSaleamt() {
        return onlineSaleamt;
    }

    public void setOnlineSaleamt(BigDecimal onlineSaleamt) {
        this.onlineSaleamt = onlineSaleamt;
    }

    public BigDecimal getProdSaleamt() {
        return prodSaleamt;
    }

    public void setProdSaleamt(BigDecimal prodSaleamt) {
        this.prodSaleamt = prodSaleamt;
    }

    public BigDecimal getNonprodSaleamt() {
        return nonprodSaleamt;
    }

    public void setNonprodSaleamt(BigDecimal nonprodSaleamt) {
        this.nonprodSaleamt = nonprodSaleamt;
    }
}