package cn.htd.argus.dto;

import java.math.BigDecimal;

public class EdwFctZsdFinanceDTO {
    private String orgCode;

    private String yearDate;

    private BigDecimal overdueAmt;

    private BigDecimal creditAmt;

    private BigDecimal overdueCustnum;

    private BigDecimal loanCustnum;

    private BigDecimal over30loanAmt;

    private BigDecimal loanAmt;

    private BigDecimal whiteCustnum;

    private BigDecimal whiteLoanCustnum;

    private BigDecimal actWhiteCustnum;

    private BigDecimal financeCustnum;

    private BigDecimal monNewticketAmt;

    private BigDecimal monNewloanAmt;

    private BigDecimal financialexpensesAmt;

    private BigDecimal salerevenueAmt;

    private BigDecimal tiecardmemberNum;

    private BigDecimal actmumberNum;

    private Integer etlDate;

    private String etlTime;

    //平台金融服务逾期金额率
    private BigDecimal overdueAmtRatio;
    //供应链金融逾期家数占比
    private BigDecimal overdueCustnumRatio;
    //超30天个人借款占比
    private BigDecimal over30Ratio;
    //白名单覆盖率
    private BigDecimal whiteRatio;
    //白名单激活率
    private BigDecimal actWhiteRatio;
    //白名单转化率
    private BigDecimal whiteLoanRatio;
    //总部新办电票占比
    private BigDecimal monNewTicketRatio;
    //财务费用率
    private BigDecimal financialexpensesRatio;
    //有效客户绑卡率
    private BigDecimal tiecardmemberRatio;

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

    public BigDecimal getOverdueAmt() {
        return overdueAmt;
    }

    public void setOverdueAmt(BigDecimal overdueAmt) {
        this.overdueAmt = overdueAmt;
    }

    public BigDecimal getCreditAmt() {
        return creditAmt;
    }

    public void setCreditAmt(BigDecimal creditAmt) {
        this.creditAmt = creditAmt;
    }

    public BigDecimal getOverdueCustnum() {
        return overdueCustnum;
    }

    public void setOverdueCustnum(BigDecimal overdueCustnum) {
        this.overdueCustnum = overdueCustnum;
    }

    public BigDecimal getLoanCustnum() {
        return loanCustnum;
    }

    public void setLoanCustnum(BigDecimal loanCustnum) {
        this.loanCustnum = loanCustnum;
    }

    public BigDecimal getOver30loanAmt() {
        return over30loanAmt;
    }

    public void setOver30loanAmt(BigDecimal over30loanAmt) {
        this.over30loanAmt = over30loanAmt;
    }

    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(BigDecimal loanAmt) {
        this.loanAmt = loanAmt;
    }

    public BigDecimal getWhiteCustnum() {
        return whiteCustnum;
    }

    public void setWhiteCustnum(BigDecimal whiteCustnum) {
        this.whiteCustnum = whiteCustnum;
    }

    public BigDecimal getWhiteLoanCustnum() {
        return whiteLoanCustnum;
    }

    public void setWhiteLoanCustnum(BigDecimal whiteLoanCustnum) {
        this.whiteLoanCustnum = whiteLoanCustnum;
    }

    public BigDecimal getActWhiteCustnum() {
        return actWhiteCustnum;
    }

    public void setActWhiteCustnum(BigDecimal actWhiteCustnum) {
        this.actWhiteCustnum = actWhiteCustnum;
    }

    public BigDecimal getFinanceCustnum() {
        return financeCustnum;
    }

    public void setFinanceCustnum(BigDecimal financeCustnum) {
        this.financeCustnum = financeCustnum;
    }

    public BigDecimal getMonNewticketAmt() {
        return monNewticketAmt;
    }

    public void setMonNewticketAmt(BigDecimal monNewticketAmt) {
        this.monNewticketAmt = monNewticketAmt;
    }

    public BigDecimal getMonNewloanAmt() {
        return monNewloanAmt;
    }

    public void setMonNewloanAmt(BigDecimal monNewloanAmt) {
        this.monNewloanAmt = monNewloanAmt;
    }

    public BigDecimal getFinancialexpensesAmt() {
        return financialexpensesAmt;
    }

    public void setFinancialexpensesAmt(BigDecimal financialexpensesAmt) {
        this.financialexpensesAmt = financialexpensesAmt;
    }

    public BigDecimal getSalerevenueAmt() {
        return salerevenueAmt;
    }

    public void setSalerevenueAmt(BigDecimal salerevenueAmt) {
        this.salerevenueAmt = salerevenueAmt;
    }

    public BigDecimal getTiecardmemberNum() {
        return tiecardmemberNum;
    }

    public void setTiecardmemberNum(BigDecimal tiecardmemberNum) {
        this.tiecardmemberNum = tiecardmemberNum;
    }

    public BigDecimal getActmumberNum() {
        return actmumberNum;
    }

    public void setActmumberNum(BigDecimal actmumberNum) {
        this.actmumberNum = actmumberNum;
    }

    public Integer getEtlDate() {
        return etlDate;
    }

    public void setEtlDate(Integer etlDate) {
        this.etlDate = etlDate;
    }

    public String getEtlTime() {
        return etlTime;
    }

    public void setEtlTime(String etlTime) {
        this.etlTime = etlTime == null ? null : etlTime.trim();
    }

    public BigDecimal getOverdueAmtRatio() {
        return overdueAmtRatio;
    }

    public void setOverdueAmtRatio(BigDecimal overdueAmtRatio) {
        this.overdueAmtRatio = overdueAmtRatio;
    }

    public BigDecimal getOverdueCustnumRatio() {
        return overdueCustnumRatio;
    }

    public void setOverdueCustnumRatio(BigDecimal overdueCustnumRatio) {
        this.overdueCustnumRatio = overdueCustnumRatio;
    }

    public BigDecimal getOver30Ratio() {
        return over30Ratio;
    }

    public void setOver30Ratio(BigDecimal over30Ratio) {
        this.over30Ratio = over30Ratio;
    }

    public BigDecimal getWhiteRatio() {
        return whiteRatio;
    }

    public void setWhiteRatio(BigDecimal whiteRatio) {
        this.whiteRatio = whiteRatio;
    }

    public BigDecimal getActWhiteRatio() {
        return actWhiteRatio;
    }

    public void setActWhiteRatio(BigDecimal actWhiteRatio) {
        this.actWhiteRatio = actWhiteRatio;
    }

    public BigDecimal getWhiteLoanRatio() {
        return whiteLoanRatio;
    }

    public void setWhiteLoanRatio(BigDecimal whiteLoanRatio) {
        this.whiteLoanRatio = whiteLoanRatio;
    }

    public BigDecimal getMonNewTicketRatio() {
        return monNewTicketRatio;
    }

    public void setMonNewTicketRatio(BigDecimal monNewTicketRatio) {
        this.monNewTicketRatio = monNewTicketRatio;
    }

    public BigDecimal getFinancialexpensesRatio() {
        return financialexpensesRatio;
    }

    public void setFinancialexpensesRatio(BigDecimal financialexpensesRatio) {
        this.financialexpensesRatio = financialexpensesRatio;
    }

    public BigDecimal getTiecardmemberRatio() {
        return tiecardmemberRatio;
    }

    public void setTiecardmemberRatio(BigDecimal tiecardmemberRatio) {
        this.tiecardmemberRatio = tiecardmemberRatio;
    }
}