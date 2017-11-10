package cn.htd.argus.dto;

import java.math.BigDecimal;

public class EdwFctl1DupontDetailDTO {
    private String dtime;

    private String yearMon;

    private String orgCode;

    private BigDecimal turnNum;

    private BigDecimal currentAssets;

    private BigDecimal dqCurrentAssets;

    private BigDecimal tbCurrentAssets;

    private BigDecimal currentLiabilities;

    private BigDecimal dqCurrentLiabilities;

    private BigDecimal tbCurrentLiabilities;

    private BigDecimal totalAssets;

    private BigDecimal dqTotalAssets;

    private BigDecimal tbTotalAssets;

    private BigDecimal totalLiabilities;

    private BigDecimal dqLiabilities;

    private BigDecimal tbTotalLiabilities;

    private BigDecimal openReceivables;

    private BigDecimal dqReceivables;

    private BigDecimal tbReceivables;

    private BigDecimal endReceivables;

    private BigDecimal openDepositReceived;

    private BigDecimal endDepositReceived;

    private BigDecimal openDepositPayable;

    private BigDecimal dqDepositPayable;

    private BigDecimal tbDepositPayable;

    private BigDecimal endDepositPayable;

    private BigDecimal openInventory;

    private BigDecimal dqInventory;

    private BigDecimal tbInventory;

    private BigDecimal endInventory;

    private BigDecimal openAccountsPayable;

    private BigDecimal endAccountsPayable;

    private BigDecimal endAssets;

    private BigDecimal prtlossSaleDq;

    private BigDecimal dqPrtlossSale;

    private BigDecimal tbPprtlossSale;

    private BigDecimal prtlossSaleTq;

    private BigDecimal prtlossCostDq;

    private BigDecimal dqPrtlossCost;

    private BigDecimal tbPrtlossCost;

    private BigDecimal prtlossCostTq;

    private BigDecimal prtlossGross;

    private BigDecimal dqPrtlossGross;

    private BigDecimal tbPrtlossGross;

    private BigDecimal prtlossExpense;

    private BigDecimal dqPrtlossExpense;

    private BigDecimal tbPrtlossExpense;

    private BigDecimal prtlossOperate;

    private BigDecimal dqPrtlossOperate;

    private BigDecimal tbPrtlossOperate;

    private BigDecimal prtlossBefore;

    private BigDecimal dqPrtlossBefore;

    private BigDecimal tbPrtlossBefore;

    private BigDecimal prtlossNetDq;

    private BigDecimal dqPrtlossNet;

    private BigDecimal tbPrtlossNet;

    private BigDecimal prtlossNetTq;

    private BigDecimal exposureAmt;

    private BigDecimal tqTotalAssets;

    private BigDecimal tqEndAssets;

    private BigDecimal tqTotalLiabilities;

    private BigDecimal dqEndLiabilities;

    private BigDecimal dqLongLiabilities;

    private BigDecimal tbLongLiabilities;

    private BigDecimal tqLongLiabilities;

    private BigDecimal dqEndLongLiabilities;

    private BigDecimal tqCurrentLiabilities;

    private BigDecimal dqEndCurrentLiabilities;

    private BigDecimal tqCurrentAssets;

    private BigDecimal dqEndCurrentAssets;

    private BigDecimal dqLongAssets;

    private BigDecimal tbLongAssets;

    private BigDecimal tqLongAssets;

    private BigDecimal dqEndLongAssets;

    private BigDecimal dqMoneyFunds;

    private BigDecimal tbMoneyFunds;

    private BigDecimal tqMoneyFunds;

    private BigDecimal dqEndMoneyFunds;

    private BigDecimal tqInventory;

    private BigDecimal tqOtherPrtloss;

    private BigDecimal dqOtherPrtloss;

    private BigDecimal tbOtherPrtloss;

    private BigDecimal tqPrtlossBefore;

    private BigDecimal tqPrtlossExpense;

    private BigDecimal tqPrtlossGross;

    private BigDecimal tqPrtlossOperate;

    private BigDecimal tqDepositPayable;

    private BigDecimal tqReceivables;

    private BigDecimal dqAvgAssets;

    private BigDecimal tbAvgAssets;

    private BigDecimal tqAvgAssets;

    private BigDecimal dqAssetsConvRatio;

    private BigDecimal tbAssetsConvRatio;

    private BigDecimal tqAssetsConvRatio;

    private Integer etlDate;

    private String etlTime;

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime == null ? null : dtime.trim();
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

    public BigDecimal getTurnNum() {
        return turnNum;
    }

    public void setTurnNum(BigDecimal turnNum) {
        this.turnNum = turnNum;
    }

    public BigDecimal getCurrentAssets() {
        return currentAssets;
    }

    public void setCurrentAssets(BigDecimal currentAssets) {
        this.currentAssets = currentAssets;
    }

    public BigDecimal getCurrentLiabilities() {
        return currentLiabilities;
    }

    public void setCurrentLiabilities(BigDecimal currentLiabilities) {
        this.currentLiabilities = currentLiabilities;
    }

    public BigDecimal getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(BigDecimal totalAssets) {
        this.totalAssets = totalAssets;
    }

    public BigDecimal getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(BigDecimal totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public BigDecimal getOpenReceivables() {
        return openReceivables;
    }

    public void setOpenReceivables(BigDecimal openReceivables) {
        this.openReceivables = openReceivables;
    }

    public BigDecimal getEndReceivables() {
        return endReceivables;
    }

    public void setEndReceivables(BigDecimal endReceivables) {
        this.endReceivables = endReceivables;
    }

    public BigDecimal getOpenDepositReceived() {
        return openDepositReceived;
    }

    public void setOpenDepositReceived(BigDecimal openDepositReceived) {
        this.openDepositReceived = openDepositReceived;
    }

    public BigDecimal getEndDepositReceived() {
        return endDepositReceived;
    }

    public void setEndDepositReceived(BigDecimal endDepositReceived) {
        this.endDepositReceived = endDepositReceived;
    }

    public BigDecimal getOpenDepositPayable() {
        return openDepositPayable;
    }

    public void setOpenDepositPayable(BigDecimal openDepositPayable) {
        this.openDepositPayable = openDepositPayable;
    }

    public BigDecimal getEndDepositPayable() {
        return endDepositPayable;
    }

    public void setEndDepositPayable(BigDecimal endDepositPayable) {
        this.endDepositPayable = endDepositPayable;
    }

    public BigDecimal getOpenInventory() {
        return openInventory;
    }

    public void setOpenInventory(BigDecimal openInventory) {
        this.openInventory = openInventory;
    }

    public BigDecimal getEndInventory() {
        return endInventory;
    }

    public void setEndInventory(BigDecimal endInventory) {
        this.endInventory = endInventory;
    }

    public BigDecimal getOpenAccountsPayable() {
        return openAccountsPayable;
    }

    public void setOpenAccountsPayable(BigDecimal openAccountsPayable) {
        this.openAccountsPayable = openAccountsPayable;
    }

    public BigDecimal getEndAccountsPayable() {
        return endAccountsPayable;
    }

    public void setEndAccountsPayable(BigDecimal endAccountsPayable) {
        this.endAccountsPayable = endAccountsPayable;
    }

    public BigDecimal getEndAssets() {
        return endAssets;
    }

    public void setEndAssets(BigDecimal endAssets) {
        this.endAssets = endAssets;
    }

    public BigDecimal getPrtlossSaleDq() {
        return prtlossSaleDq;
    }

    public void setPrtlossSaleDq(BigDecimal prtlossSaleDq) {
        this.prtlossSaleDq = prtlossSaleDq;
    }

    public BigDecimal getPrtlossSaleTq() {
        return prtlossSaleTq;
    }

    public void setPrtlossSaleTq(BigDecimal prtlossSaleTq) {
        this.prtlossSaleTq = prtlossSaleTq;
    }

    public BigDecimal getPrtlossCostDq() {
        return prtlossCostDq;
    }

    public void setPrtlossCostDq(BigDecimal prtlossCostDq) {
        this.prtlossCostDq = prtlossCostDq;
    }

    public BigDecimal getPrtlossCostTq() {
        return prtlossCostTq;
    }

    public void setPrtlossCostTq(BigDecimal prtlossCostTq) {
        this.prtlossCostTq = prtlossCostTq;
    }

    public BigDecimal getPrtlossGross() {
        return prtlossGross;
    }

    public void setPrtlossGross(BigDecimal prtlossGross) {
        this.prtlossGross = prtlossGross;
    }

    public BigDecimal getPrtlossExpense() {
        return prtlossExpense;
    }

    public void setPrtlossExpense(BigDecimal prtlossExpense) {
        this.prtlossExpense = prtlossExpense;
    }

    public BigDecimal getPrtlossOperate() {
        return prtlossOperate;
    }

    public void setPrtlossOperate(BigDecimal prtlossOperate) {
        this.prtlossOperate = prtlossOperate;
    }

    public BigDecimal getPrtlossBefore() {
        return prtlossBefore;
    }

    public void setPrtlossBefore(BigDecimal prtlossBefore) {
        this.prtlossBefore = prtlossBefore;
    }

    public BigDecimal getPrtlossNetDq() {
        return prtlossNetDq;
    }

    public void setPrtlossNetDq(BigDecimal prtlossNetDq) {
        this.prtlossNetDq = prtlossNetDq;
    }

    public BigDecimal getPrtlossNetTq() {
        return prtlossNetTq;
    }

    public void setPrtlossNetTq(BigDecimal prtlossNetTq) {
        this.prtlossNetTq = prtlossNetTq;
    }

    public BigDecimal getExposureAmt() {
        return exposureAmt;
    }

    public void setExposureAmt(BigDecimal exposureAmt) {
        this.exposureAmt = exposureAmt;
    }

    public BigDecimal getTqTotalAssets() {
        return tqTotalAssets;
    }

    public void setTqTotalAssets(BigDecimal tqTotalAssets) {
        this.tqTotalAssets = tqTotalAssets;
    }

    public BigDecimal getTqEndAssets() {
        return tqEndAssets;
    }

    public void setTqEndAssets(BigDecimal tqEndAssets) {
        this.tqEndAssets = tqEndAssets;
    }

    public BigDecimal getTqTotalLiabilities() {
        return tqTotalLiabilities;
    }

    public void setTqTotalLiabilities(BigDecimal tqTotalLiabilities) {
        this.tqTotalLiabilities = tqTotalLiabilities;
    }

    public BigDecimal getDqEndLiabilities() {
        return dqEndLiabilities;
    }

    public void setDqEndLiabilities(BigDecimal dqEndLiabilities) {
        this.dqEndLiabilities = dqEndLiabilities;
    }

    public BigDecimal getDqLongLiabilities() {
        return dqLongLiabilities;
    }

    public void setDqLongLiabilities(BigDecimal dqLongLiabilities) {
        this.dqLongLiabilities = dqLongLiabilities;
    }

    public BigDecimal getTqLongLiabilities() {
        return tqLongLiabilities;
    }

    public void setTqLongLiabilities(BigDecimal tqLongLiabilities) {
        this.tqLongLiabilities = tqLongLiabilities;
    }

    public BigDecimal getDqEndLongLiabilities() {
        return dqEndLongLiabilities;
    }

    public void setDqEndLongLiabilities(BigDecimal dqEndLongLiabilities) {
        this.dqEndLongLiabilities = dqEndLongLiabilities;
    }

    public BigDecimal getTqCurrentLiabilities() {
        return tqCurrentLiabilities;
    }

    public void setTqCurrentLiabilities(BigDecimal tqCurrentLiabilities) {
        this.tqCurrentLiabilities = tqCurrentLiabilities;
    }

    public BigDecimal getDqEndCurrentLiabilities() {
        return dqEndCurrentLiabilities;
    }

    public void setDqEndCurrentLiabilities(BigDecimal dqEndCurrentLiabilities) {
        this.dqEndCurrentLiabilities = dqEndCurrentLiabilities;
    }

    public BigDecimal getTqCurrentAssets() {
        return tqCurrentAssets;
    }

    public void setTqCurrentAssets(BigDecimal tqCurrentAssets) {
        this.tqCurrentAssets = tqCurrentAssets;
    }

    public BigDecimal getDqEndCurrentAssets() {
        return dqEndCurrentAssets;
    }

    public void setDqEndCurrentAssets(BigDecimal dqEndCurrentAssets) {
        this.dqEndCurrentAssets = dqEndCurrentAssets;
    }

    public BigDecimal getDqLongAssets() {
        return dqLongAssets;
    }

    public void setDqLongAssets(BigDecimal dqLongAssets) {
        this.dqLongAssets = dqLongAssets;
    }

    public BigDecimal getTqLongAssets() {
        return tqLongAssets;
    }

    public void setTqLongAssets(BigDecimal tqLongAssets) {
        this.tqLongAssets = tqLongAssets;
    }

    public BigDecimal getDqEndLongAssets() {
        return dqEndLongAssets;
    }

    public void setDqEndLongAssets(BigDecimal dqEndLongAssets) {
        this.dqEndLongAssets = dqEndLongAssets;
    }

    public BigDecimal getDqMoneyFunds() {
        return dqMoneyFunds;
    }

    public void setDqMoneyFunds(BigDecimal dqMoneyFunds) {
        this.dqMoneyFunds = dqMoneyFunds;
    }

    public BigDecimal getTqMoneyFunds() {
        return tqMoneyFunds;
    }

    public void setTqMoneyFunds(BigDecimal tqMoneyFunds) {
        this.tqMoneyFunds = tqMoneyFunds;
    }

    public BigDecimal getDqEndMoneyFunds() {
        return dqEndMoneyFunds;
    }

    public void setDqEndMoneyFunds(BigDecimal dqEndMoneyFunds) {
        this.dqEndMoneyFunds = dqEndMoneyFunds;
    }

    public BigDecimal getTqInventory() {
        return tqInventory;
    }

    public void setTqInventory(BigDecimal tqInventory) {
        this.tqInventory = tqInventory;
    }

    public BigDecimal getTqOtherPrtloss() {
        return tqOtherPrtloss;
    }

    public void setTqOtherPrtloss(BigDecimal tqOtherPrtloss) {
        this.tqOtherPrtloss = tqOtherPrtloss;
    }

    public BigDecimal getDqOtherPrtloss() {
        return dqOtherPrtloss;
    }

    public void setDqOtherPrtloss(BigDecimal dqOtherPrtloss) {
        this.dqOtherPrtloss = dqOtherPrtloss;
    }

    public BigDecimal getTqPrtlossBefore() {
        return tqPrtlossBefore;
    }

    public void setTqPrtlossBefore(BigDecimal tqPrtlossBefore) {
        this.tqPrtlossBefore = tqPrtlossBefore;
    }

    public BigDecimal getTqPrtlossExpense() {
        return tqPrtlossExpense;
    }

    public void setTqPrtlossExpense(BigDecimal tqPrtlossExpense) {
        this.tqPrtlossExpense = tqPrtlossExpense;
    }

    public BigDecimal getTqPrtlossGross() {
        return tqPrtlossGross;
    }

    public void setTqPrtlossGross(BigDecimal tqPrtlossGross) {
        this.tqPrtlossGross = tqPrtlossGross;
    }

    public BigDecimal getTqPrtlossOperate() {
        return tqPrtlossOperate;
    }

    public void setTqPrtlossOperate(BigDecimal tqPrtlossOperate) {
        this.tqPrtlossOperate = tqPrtlossOperate;
    }

    public BigDecimal getTqDepositPayable() {
        return tqDepositPayable;
    }

    public void setTqDepositPayable(BigDecimal tqDepositPayable) {
        this.tqDepositPayable = tqDepositPayable;
    }

    public BigDecimal getTqReceivables() {
        return tqReceivables;
    }

    public void setTqReceivables(BigDecimal tqReceivables) {
        this.tqReceivables = tqReceivables;
    }

    public BigDecimal getDqAvgAssets() {
        return dqAvgAssets;
    }

    public void setDqAvgAssets(BigDecimal dqAvgAssets) {
        this.dqAvgAssets = dqAvgAssets;
    }

    public BigDecimal getTqAvgAssets() {
        return tqAvgAssets;
    }

    public void setTqAvgAssets(BigDecimal tqAvgAssets) {
        this.tqAvgAssets = tqAvgAssets;
    }

    public BigDecimal getDqAssetsConvRatio() {
        return dqAssetsConvRatio;
    }

    public void setDqAssetsConvRatio(BigDecimal dqAssetsConvRatio) {
        this.dqAssetsConvRatio = dqAssetsConvRatio;
    }

    public BigDecimal getTqAssetsConvRatio() {
        return tqAssetsConvRatio;
    }

    public void setTqAssetsConvRatio(BigDecimal tqAssetsConvRatio) {
        this.tqAssetsConvRatio = tqAssetsConvRatio;
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

    public BigDecimal getTbLongLiabilities() {
        return tbLongLiabilities;
    }

    public void setTbLongLiabilities(BigDecimal tbLongLiabilities) {
        this.tbLongLiabilities = tbLongLiabilities;
    }

    public BigDecimal getTbLongAssets() {
        return tbLongAssets;
    }

    public void setTbLongAssets(BigDecimal tbLongAssets) {
        this.tbLongAssets = tbLongAssets;
    }

    public BigDecimal getTbMoneyFunds() {
        return tbMoneyFunds;
    }

    public void setTbMoneyFunds(BigDecimal tbMoneyFunds) {
        this.tbMoneyFunds = tbMoneyFunds;
    }

    public BigDecimal getTbOtherPrtloss() {
        return tbOtherPrtloss;
    }

    public void setTbOtherPrtloss(BigDecimal tbOtherPrtloss) {
        this.tbOtherPrtloss = tbOtherPrtloss;
    }

    public BigDecimal getTbAvgAssets() {
        return tbAvgAssets;
    }

    public void setTbAvgAssets(BigDecimal tbAvgAssets) {
        this.tbAvgAssets = tbAvgAssets;
    }

    public BigDecimal getTbAssetsConvRatio() {
        return tbAssetsConvRatio;
    }

    public void setTbAssetsConvRatio(BigDecimal tbAssetsConvRatio) {
        this.tbAssetsConvRatio = tbAssetsConvRatio;
    }
}