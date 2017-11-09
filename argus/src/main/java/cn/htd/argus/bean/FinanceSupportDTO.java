package cn.htd.argus.bean;

import java.math.BigDecimal;

/**
 * Created by wangtp on 2017/11/9.
 */
public class FinanceSupportDTO {
    //1.
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

    //2.异常状态0：正常 1：异常
    //白名单覆盖率
    private String whiteRatioState;
    //白名单激活率
    private String actWhiteRatioState;
    //白名单转化率
    private String whiteLoanRatioState;
    //总部新办电票占比
    private String monNewTicketRatioState;
    //财务费用率
    private String financialexpensesRatioState;
    //有效客户绑卡率
    private String tiecardmemberRatioState;

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

    public String getWhiteRatioState() {
        return whiteRatioState;
    }

    public void setWhiteRatioState(String whiteRatioState) {
        this.whiteRatioState = whiteRatioState;
    }

    public String getActWhiteRatioState() {
        return actWhiteRatioState;
    }

    public void setActWhiteRatioState(String actWhiteRatioState) {
        this.actWhiteRatioState = actWhiteRatioState;
    }

    public String getWhiteLoanRatioState() {
        return whiteLoanRatioState;
    }

    public void setWhiteLoanRatioState(String whiteLoanRatioState) {
        this.whiteLoanRatioState = whiteLoanRatioState;
    }

    public String getMonNewTicketRatioState() {
        return monNewTicketRatioState;
    }

    public void setMonNewTicketRatioState(String monNewTicketRatioState) {
        this.monNewTicketRatioState = monNewTicketRatioState;
    }

    public String getFinancialexpensesRatioState() {
        return financialexpensesRatioState;
    }

    public void setFinancialexpensesRatioState(String financialexpensesRatioState) {
        this.financialexpensesRatioState = financialexpensesRatioState;
    }

    public String getTiecardmemberRatioState() {
        return tiecardmemberRatioState;
    }

    public void setTiecardmemberRatioState(String tiecardmemberRatioState) {
        this.tiecardmemberRatioState = tiecardmemberRatioState;
    }
}
