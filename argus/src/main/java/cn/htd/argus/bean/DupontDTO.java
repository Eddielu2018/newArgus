package cn.htd.argus.bean;

import java.math.BigDecimal;

/**
 * Created by wangtp on 2017/11/7.
 */
public class DupontDTO {
    //1.edw_fct_l2_dupont
    //净资产收益率
    private BigDecimal dqRoe;
    private BigDecimal tbRoe;
    //销售毛利率
    private BigDecimal dqGrossProfitRatio;
    private BigDecimal tbGrossProfitRatio;
    //资产负债率
    private BigDecimal dqDebtAssetsRatio;
    private BigDecimal tbDebtAssetsRatio;
    //营业周期
    private BigDecimal dqOperateCycle;
    private BigDecimal tbOperateCycle;
    //当期主营收入增长率
    private BigDecimal dqSaleGrowthRatio;
    private BigDecimal tbSaleGrowthRatio;
    //营业利润率
    private BigDecimal dqOperateProfitRatio;
    private BigDecimal tbOperateProfitRatio;
    //流动比率
    private BigDecimal dqCurrentRatio;
    private BigDecimal tbCurrentRatio;
    //现金周期
    private BigDecimal dqCashCycle;
    private BigDecimal tbCashCycle;
    //净利润增长率
    private BigDecimal dqNetGrowthRatio;
    private BigDecimal tbNetGrowthRatio;
    //三项费用占比
    private BigDecimal dqThirdRatio;
    private BigDecimal tbThirdRatio;
    //速动比率
    private BigDecimal dqQuickRatio;
    private BigDecimal tbQuickRatio;
    //应收账款周转天数
    private BigDecimal dqReceiveConvDays;
    private BigDecimal tbReceiveConvDays;
    //总资产收益率
    private BigDecimal dqRota;
    private BigDecimal tbRota;
    //销售净利率
    private BigDecimal dqSaleNetRatio;
    private BigDecimal tbSaleNetRatio;
    //权益乘数
    private BigDecimal dqQycs;
    private BigDecimal tbQycs;

    //2.
    //当期资产周转率
    private BigDecimal dqAssetsConvRatio;
    private BigDecimal tbAssetsConvRatio;
    //平均资产总额
    private BigDecimal dqAvgAssets;
    private BigDecimal tbAvgAssets;
    //资产总额
    private BigDecimal dqTotalAssets;
    private BigDecimal tbTotalAssets;
    //非流动资产
    private BigDecimal dqLongAssets;
    private BigDecimal tbLongAssets;
    //流动资产
    private BigDecimal dqCurrentAssets;
    private BigDecimal tbCurrentAssets;
    //货币资金
    private BigDecimal dqMoneyFunds;
    private BigDecimal tbMoneyFunds;
    //预付账款
    private BigDecimal dqDepositPayable;
    private BigDecimal tbDepositPayable;
    //负债
    private BigDecimal dqLiabilities;
    private BigDecimal tbTotalLiabilities;
    //非流动负债
    private BigDecimal dqLongLiabilities;
    private BigDecimal tbLongLiabilities;
    //流动负债
    private BigDecimal dqCurrentLiabilities;
    private BigDecimal tbCurrentLiabilities;
    //存货
    private BigDecimal dqInventory;
    private BigDecimal tbInventory;
    //应收账款
    private BigDecimal dqReceivables;
    private BigDecimal tbReceivables;
    //收入
    private BigDecimal dqPrtlossSale;
    private BigDecimal tbPprtlossSale;
    //成本
    private BigDecimal dqPrtlossCost;
    private BigDecimal tbPrtlossCost;
    //利润总额
    private BigDecimal dqPrtlossBefore;
    private BigDecimal tbPrtlossBefore;
    //三项费用合计
    private BigDecimal dqPrtlossExpense;
    private BigDecimal tbPrtlossExpense;
    //净利润
    private BigDecimal dqPrtlossNet;
    private BigDecimal tbPrtlossNet;
    //毛利润
    private BigDecimal dqPrtlossGross;
    private BigDecimal tbPrtlossGross;
    //营业利润
    private BigDecimal dqPrtlossOperate;
    private BigDecimal tbPrtlossOperate;
    //其他利润
    private BigDecimal dqOtherPrtloss;
    private BigDecimal tbOtherPrtloss;



    public BigDecimal getDqGrossProfitRatio() {
        return dqGrossProfitRatio;
    }

    public void setDqGrossProfitRatio(BigDecimal dqGrossProfitRatio) {
        this.dqGrossProfitRatio = dqGrossProfitRatio;
    }

    public BigDecimal getTbGrossProfitRatio() {
        return tbGrossProfitRatio;
    }

    public void setTbGrossProfitRatio(BigDecimal tbGrossProfitRatio) {
        this.tbGrossProfitRatio = tbGrossProfitRatio;
    }

    public BigDecimal getDqDebtAssetsRatio() {
        return dqDebtAssetsRatio;
    }

    public void setDqDebtAssetsRatio(BigDecimal dqDebtAssetsRatio) {
        this.dqDebtAssetsRatio = dqDebtAssetsRatio;
    }

    public BigDecimal getTbDebtAssetsRatio() {
        return tbDebtAssetsRatio;
    }

    public void setTbDebtAssetsRatio(BigDecimal tbDebtAssetsRatio) {
        this.tbDebtAssetsRatio = tbDebtAssetsRatio;
    }

    public BigDecimal getDqOperateCycle() {
        return dqOperateCycle;
    }

    public void setDqOperateCycle(BigDecimal dqOperateCycle) {
        this.dqOperateCycle = dqOperateCycle;
    }

    public BigDecimal getTbOperateCycle() {
        return tbOperateCycle;
    }

    public void setTbOperateCycle(BigDecimal tbOperateCycle) {
        this.tbOperateCycle = tbOperateCycle;
    }

    public BigDecimal getDqSaleGrowthRatio() {
        return dqSaleGrowthRatio;
    }

    public void setDqSaleGrowthRatio(BigDecimal dqSaleGrowthRatio) {
        this.dqSaleGrowthRatio = dqSaleGrowthRatio;
    }

    public BigDecimal getTbSaleGrowthRatio() {
        return tbSaleGrowthRatio;
    }

    public void setTbSaleGrowthRatio(BigDecimal tbSaleGrowthRatio) {
        this.tbSaleGrowthRatio = tbSaleGrowthRatio;
    }

    public BigDecimal getDqOperateProfitRatio() {
        return dqOperateProfitRatio;
    }

    public void setDqOperateProfitRatio(BigDecimal dqOperateProfitRatio) {
        this.dqOperateProfitRatio = dqOperateProfitRatio;
    }

    public BigDecimal getTbOperateProfitRatio() {
        return tbOperateProfitRatio;
    }

    public void setTbOperateProfitRatio(BigDecimal tbOperateProfitRatio) {
        this.tbOperateProfitRatio = tbOperateProfitRatio;
    }

    public BigDecimal getDqCurrentRatio() {
        return dqCurrentRatio;
    }

    public void setDqCurrentRatio(BigDecimal dqCurrentRatio) {
        this.dqCurrentRatio = dqCurrentRatio;
    }

    public BigDecimal getTbCurrentRatio() {
        return tbCurrentRatio;
    }

    public void setTbCurrentRatio(BigDecimal tbCurrentRatio) {
        this.tbCurrentRatio = tbCurrentRatio;
    }

    public BigDecimal getDqCashCycle() {
        return dqCashCycle;
    }

    public void setDqCashCycle(BigDecimal dqCashCycle) {
        this.dqCashCycle = dqCashCycle;
    }

    public BigDecimal getTbCashCycle() {
        return tbCashCycle;
    }

    public void setTbCashCycle(BigDecimal tbCashCycle) {
        this.tbCashCycle = tbCashCycle;
    }

    public BigDecimal getDqNetGrowthRatio() {
        return dqNetGrowthRatio;
    }

    public void setDqNetGrowthRatio(BigDecimal dqNetGrowthRatio) {
        this.dqNetGrowthRatio = dqNetGrowthRatio;
    }

    public BigDecimal getTbNetGrowthRatio() {
        return tbNetGrowthRatio;
    }

    public void setTbNetGrowthRatio(BigDecimal tbNetGrowthRatio) {
        this.tbNetGrowthRatio = tbNetGrowthRatio;
    }

    public BigDecimal getDqThirdRatio() {
        return dqThirdRatio;
    }

    public void setDqThirdRatio(BigDecimal dqThirdRatio) {
        this.dqThirdRatio = dqThirdRatio;
    }

    public BigDecimal getTbThirdRatio() {
        return tbThirdRatio;
    }

    public void setTbThirdRatio(BigDecimal tbThirdRatio) {
        this.tbThirdRatio = tbThirdRatio;
    }

    public BigDecimal getDqQuickRatio() {
        return dqQuickRatio;
    }

    public void setDqQuickRatio(BigDecimal dqQuickRatio) {
        this.dqQuickRatio = dqQuickRatio;
    }

    public BigDecimal getTbQuickRatio() {
        return tbQuickRatio;
    }

    public void setTbQuickRatio(BigDecimal tbQuickRatio) {
        this.tbQuickRatio = tbQuickRatio;
    }

    public BigDecimal getDqReceiveConvDays() {
        return dqReceiveConvDays;
    }

    public void setDqReceiveConvDays(BigDecimal dqReceiveConvDays) {
        this.dqReceiveConvDays = dqReceiveConvDays;
    }

    public BigDecimal getTbReceiveConvDays() {
        return tbReceiveConvDays;
    }

    public void setTbReceiveConvDays(BigDecimal tbReceiveConvDays) {
        this.tbReceiveConvDays = tbReceiveConvDays;
    }

    public BigDecimal getDqRota() {
        return dqRota;
    }

    public void setDqRota(BigDecimal dqRota) {
        this.dqRota = dqRota;
    }

    public BigDecimal getTbRota() {
        return tbRota;
    }

    public void setTbRota(BigDecimal tbRota) {
        this.tbRota = tbRota;
    }

    public BigDecimal getDqSaleNetRatio() {
        return dqSaleNetRatio;
    }

    public void setDqSaleNetRatio(BigDecimal dqSaleNetRatio) {
        this.dqSaleNetRatio = dqSaleNetRatio;
    }

    public BigDecimal getTbSaleNetRatio() {
        return tbSaleNetRatio;
    }

    public void setTbSaleNetRatio(BigDecimal tbSaleNetRatio) {
        this.tbSaleNetRatio = tbSaleNetRatio;
    }

    public BigDecimal getDqRoe() {
        return dqRoe;
    }

    public void setDqRoe(BigDecimal dqRoe) {
        this.dqRoe = dqRoe;
    }

    public BigDecimal getTbRoe() {
        return tbRoe;
    }

    public void setTbRoe(BigDecimal tbRoe) {
        this.tbRoe = tbRoe;
    }

    public BigDecimal getDqQycs() {
        return dqQycs;
    }

    public void setDqQycs(BigDecimal dqQycs) {
        this.dqQycs = dqQycs;
    }

    public BigDecimal getTbQycs() {
        return tbQycs;
    }

    public void setTbQycs(BigDecimal tbQycs) {
        this.tbQycs = tbQycs;
    }

    public BigDecimal getDqAssetsConvRatio() {
        return dqAssetsConvRatio;
    }

    public void setDqAssetsConvRatio(BigDecimal dqAssetsConvRatio) {
        this.dqAssetsConvRatio = dqAssetsConvRatio;
    }

    public BigDecimal getTbAssetsConvRatio() {
        return tbAssetsConvRatio;
    }

    public void setTbAssetsConvRatio(BigDecimal tbAssetsConvRatio) {
        this.tbAssetsConvRatio = tbAssetsConvRatio;
    }

    public BigDecimal getDqAvgAssets() {
        return dqAvgAssets;
    }

    public void setDqAvgAssets(BigDecimal dqAvgAssets) {
        this.dqAvgAssets = dqAvgAssets;
    }

    public BigDecimal getTbAvgAssets() {
        return tbAvgAssets;
    }

    public void setTbAvgAssets(BigDecimal tbAvgAssets) {
        this.tbAvgAssets = tbAvgAssets;
    }

    public BigDecimal getDqTotalAssets() {
        return dqTotalAssets;
    }

    public void setDqTotalAssets(BigDecimal dqTotalAssets) {
        this.dqTotalAssets = dqTotalAssets;
    }

    public BigDecimal getTbTotalAssets() {
        return tbTotalAssets;
    }

    public void setTbTotalAssets(BigDecimal tbTotalAssets) {
        this.tbTotalAssets = tbTotalAssets;
    }

    public BigDecimal getDqLongAssets() {
        return dqLongAssets;
    }

    public void setDqLongAssets(BigDecimal dqLongAssets) {
        this.dqLongAssets = dqLongAssets;
    }

    public BigDecimal getTbLongAssets() {
        return tbLongAssets;
    }

    public void setTbLongAssets(BigDecimal tbLongAssets) {
        this.tbLongAssets = tbLongAssets;
    }

    public BigDecimal getDqCurrentAssets() {
        return dqCurrentAssets;
    }

    public void setDqCurrentAssets(BigDecimal dqCurrentAssets) {
        this.dqCurrentAssets = dqCurrentAssets;
    }

    public BigDecimal getTbCurrentAssets() {
        return tbCurrentAssets;
    }

    public void setTbCurrentAssets(BigDecimal tbCurrentAssets) {
        this.tbCurrentAssets = tbCurrentAssets;
    }

    public BigDecimal getDqMoneyFunds() {
        return dqMoneyFunds;
    }

    public void setDqMoneyFunds(BigDecimal dqMoneyFunds) {
        this.dqMoneyFunds = dqMoneyFunds;
    }

    public BigDecimal getTbMoneyFunds() {
        return tbMoneyFunds;
    }

    public void setTbMoneyFunds(BigDecimal tbMoneyFunds) {
        this.tbMoneyFunds = tbMoneyFunds;
    }

    public BigDecimal getDqDepositPayable() {
        return dqDepositPayable;
    }

    public void setDqDepositPayable(BigDecimal dqDepositPayable) {
        this.dqDepositPayable = dqDepositPayable;
    }

    public BigDecimal getTbDepositPayable() {
        return tbDepositPayable;
    }

    public void setTbDepositPayable(BigDecimal tbDepositPayable) {
        this.tbDepositPayable = tbDepositPayable;
    }

    public BigDecimal getDqLiabilities() {
        return dqLiabilities;
    }

    public void setDqLiabilities(BigDecimal dqLiabilities) {
        this.dqLiabilities = dqLiabilities;
    }

    public BigDecimal getTbTotalLiabilities() {
        return tbTotalLiabilities;
    }

    public void setTbTotalLiabilities(BigDecimal tbTotalLiabilities) {
        this.tbTotalLiabilities = tbTotalLiabilities;
    }

    public BigDecimal getDqLongLiabilities() {
        return dqLongLiabilities;
    }

    public void setDqLongLiabilities(BigDecimal dqLongLiabilities) {
        this.dqLongLiabilities = dqLongLiabilities;
    }

    public BigDecimal getTbLongLiabilities() {
        return tbLongLiabilities;
    }

    public void setTbLongLiabilities(BigDecimal tbLongLiabilities) {
        this.tbLongLiabilities = tbLongLiabilities;
    }

    public BigDecimal getDqCurrentLiabilities() {
        return dqCurrentLiabilities;
    }

    public void setDqCurrentLiabilities(BigDecimal dqCurrentLiabilities) {
        this.dqCurrentLiabilities = dqCurrentLiabilities;
    }

    public BigDecimal getTbCurrentLiabilities() {
        return tbCurrentLiabilities;
    }

    public void setTbCurrentLiabilities(BigDecimal tbCurrentLiabilities) {
        this.tbCurrentLiabilities = tbCurrentLiabilities;
    }

    public BigDecimal getDqInventory() {
        return dqInventory;
    }

    public void setDqInventory(BigDecimal dqInventory) {
        this.dqInventory = dqInventory;
    }

    public BigDecimal getTbInventory() {
        return tbInventory;
    }

    public void setTbInventory(BigDecimal tbInventory) {
        this.tbInventory = tbInventory;
    }

    public BigDecimal getDqReceivables() {
        return dqReceivables;
    }

    public void setDqReceivables(BigDecimal dqReceivables) {
        this.dqReceivables = dqReceivables;
    }

    public BigDecimal getTbReceivables() {
        return tbReceivables;
    }

    public void setTbReceivables(BigDecimal tbReceivables) {
        this.tbReceivables = tbReceivables;
    }

    public BigDecimal getDqPrtlossSale() {
        return dqPrtlossSale;
    }

    public void setDqPrtlossSale(BigDecimal dqPrtlossSale) {
        this.dqPrtlossSale = dqPrtlossSale;
    }

    public BigDecimal getTbPprtlossSale() {
        return tbPprtlossSale;
    }

    public void setTbPprtlossSale(BigDecimal tbPprtlossSale) {
        this.tbPprtlossSale = tbPprtlossSale;
    }

    public BigDecimal getDqPrtlossCost() {
        return dqPrtlossCost;
    }

    public void setDqPrtlossCost(BigDecimal dqPrtlossCost) {
        this.dqPrtlossCost = dqPrtlossCost;
    }

    public BigDecimal getTbPrtlossCost() {
        return tbPrtlossCost;
    }

    public void setTbPrtlossCost(BigDecimal tbPrtlossCost) {
        this.tbPrtlossCost = tbPrtlossCost;
    }

    public BigDecimal getDqPrtlossBefore() {
        return dqPrtlossBefore;
    }

    public void setDqPrtlossBefore(BigDecimal dqPrtlossBefore) {
        this.dqPrtlossBefore = dqPrtlossBefore;
    }

    public BigDecimal getTbPrtlossBefore() {
        return tbPrtlossBefore;
    }

    public void setTbPrtlossBefore(BigDecimal tbPrtlossBefore) {
        this.tbPrtlossBefore = tbPrtlossBefore;
    }

    public BigDecimal getDqPrtlossExpense() {
        return dqPrtlossExpense;
    }

    public void setDqPrtlossExpense(BigDecimal dqPrtlossExpense) {
        this.dqPrtlossExpense = dqPrtlossExpense;
    }

    public BigDecimal getTbPrtlossExpense() {
        return tbPrtlossExpense;
    }

    public void setTbPrtlossExpense(BigDecimal tbPrtlossExpense) {
        this.tbPrtlossExpense = tbPrtlossExpense;
    }

    public BigDecimal getDqPrtlossNet() {
        return dqPrtlossNet;
    }

    public void setDqPrtlossNet(BigDecimal dqPrtlossNet) {
        this.dqPrtlossNet = dqPrtlossNet;
    }

    public BigDecimal getTbPrtlossNet() {
        return tbPrtlossNet;
    }

    public void setTbPrtlossNet(BigDecimal tbPrtlossNet) {
        this.tbPrtlossNet = tbPrtlossNet;
    }

    public BigDecimal getDqPrtlossGross() {
        return dqPrtlossGross;
    }

    public void setDqPrtlossGross(BigDecimal dqPrtlossGross) {
        this.dqPrtlossGross = dqPrtlossGross;
    }

    public BigDecimal getTbPrtlossGross() {
        return tbPrtlossGross;
    }

    public void setTbPrtlossGross(BigDecimal tbPrtlossGross) {
        this.tbPrtlossGross = tbPrtlossGross;
    }

    public BigDecimal getDqPrtlossOperate() {
        return dqPrtlossOperate;
    }

    public void setDqPrtlossOperate(BigDecimal dqPrtlossOperate) {
        this.dqPrtlossOperate = dqPrtlossOperate;
    }

    public BigDecimal getTbPrtlossOperate() {
        return tbPrtlossOperate;
    }

    public void setTbPrtlossOperate(BigDecimal tbPrtlossOperate) {
        this.tbPrtlossOperate = tbPrtlossOperate;
    }

    public BigDecimal getDqOtherPrtloss() {
        return dqOtherPrtloss;
    }

    public void setDqOtherPrtloss(BigDecimal dqOtherPrtloss) {
        this.dqOtherPrtloss = dqOtherPrtloss;
    }

    public BigDecimal getTbOtherPrtloss() {
        return tbOtherPrtloss;
    }

    public void setTbOtherPrtloss(BigDecimal tbOtherPrtloss) {
        this.tbOtherPrtloss = tbOtherPrtloss;
    }
}
