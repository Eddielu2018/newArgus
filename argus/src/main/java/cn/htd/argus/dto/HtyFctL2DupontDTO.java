package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctL2DupontDTO {
    private Long id;

    private String dtime;

    private String yearMon;

    private String orgCode;

    private BigDecimal dqCurrentRatio;

    private BigDecimal tqCurrentRatio;

    private BigDecimal tbCurrentRatio;

    private BigDecimal snCurrentRatio;

    private BigDecimal dqQuickRatio;

    private BigDecimal tqQuickRatio;

    private BigDecimal tbQuickRatio;

    private BigDecimal snQuickRatio;

    private BigDecimal dqDebtAssetsRatio;

    private BigDecimal tqDebtAssetsRatio;

    private BigDecimal tbDebtAssetsRatio;

    private BigDecimal snDebtAssetsRatio;

    private BigDecimal dqSupExposureDays;

    private BigDecimal tqSupExposureDays;

    private BigDecimal snSupExposureDays;

    private BigDecimal dqReceiveConvRatio;

    private BigDecimal tqReceiveConvRatio;

    private BigDecimal tbReceiveConvRatio;

    private BigDecimal snReceiveConvRatio;

    private BigDecimal dqReceiveConvDays;

    private BigDecimal tqReceiveConvDays;

    private BigDecimal tbReceiveConvDays;

    private BigDecimal snReceiveConvDays;

    private BigDecimal dqDepRecConvRatio;

    private BigDecimal tqDepRecConvRatio;

    private BigDecimal snDepRecConvRatio;

    private BigDecimal dqDepRecConvDays;

    private BigDecimal tqDepRecConvDays;

    private BigDecimal snDepRecConvDays;

    private BigDecimal dqInventoryConvRatio;

    private BigDecimal tqInventoryConvRatio;

    private BigDecimal snInventoryConvRatio;

    private BigDecimal dqInventoryConvDays;

    private BigDecimal tqInventoryConvDays;

    private BigDecimal snInventoryConvDays;

    private BigDecimal dqDepPayConvRatio;

    private BigDecimal tqDepPayConvRatio;

    private BigDecimal snDepPayConvRatio;

    private BigDecimal dqDepPayConvDays;

    private BigDecimal tqDepPayConvDays;

    private BigDecimal snDepPayConvDays;

    private BigDecimal dqAccPayConvRatio;

    private BigDecimal tqAccPayConvRatio;

    private BigDecimal snAccPayConvRatio;

    private BigDecimal dqAccPayConvDays;

    private BigDecimal tqAccPayConvDays;

    private BigDecimal snAccPayConvDays;

    private BigDecimal dqOperateCycle;

    private BigDecimal tqOperateCycle;

    private BigDecimal tbOperateCycle;

    private BigDecimal snOperateCycle;

    private BigDecimal dqCashCycle;

    private BigDecimal tqCashCycle;

    private BigDecimal tbCashCycle;

    private BigDecimal snCashCycle;

    private BigDecimal dqRota;

    private BigDecimal tqRota;

    private BigDecimal tbRota;

    private BigDecimal snRota;

    private BigDecimal dqRoe;

    private BigDecimal tqRoe;

    private BigDecimal tbRoe;

    private BigDecimal snRoe;

    private BigDecimal dqGrossProfitRatio;

    private BigDecimal tqGrossProfitRatio;

    private BigDecimal tbGrossProfitRatio;

    private BigDecimal snGrossProfitRatio;

    private BigDecimal dqSaleGrowthRatio;

    private BigDecimal tqSaleGrowthRatio;

    private BigDecimal tbSaleGrowthRatio;

    private BigDecimal snSaleGrowthRatio;

    private BigDecimal dqNetGrowthRatio;

    private BigDecimal tqNetGrowthRatio;

    private BigDecimal tbNetGrowthRatio;

    private BigDecimal snNetGrowthRatio;

    private BigDecimal dqOperateProfitRatio;

    private BigDecimal tqOperateProfitRatio;

    private BigDecimal tbOperateProfitRatio;

    private BigDecimal snOperateProfitRatio;

    private BigDecimal dqSaleNetRatio;

    private BigDecimal tqSaleNetRatio;

    private BigDecimal tbSaleNetRatio;

    private BigDecimal snSaleNetRatio;

    private BigDecimal dqThirdRatio;

    private BigDecimal tqThirdRatio;

    private BigDecimal tbThirdRatio;

    private BigDecimal snThirdRatio;

    private BigDecimal dqQycs;

    private BigDecimal tbQycs;

    private String lvl;

    private Integer etlDate;

    private String etlTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BigDecimal getDqCurrentRatio() {
        return dqCurrentRatio;
    }

    public void setDqCurrentRatio(BigDecimal dqCurrentRatio) {
        this.dqCurrentRatio = dqCurrentRatio;
    }

    public BigDecimal getTqCurrentRatio() {
        return tqCurrentRatio;
    }

    public void setTqCurrentRatio(BigDecimal tqCurrentRatio) {
        this.tqCurrentRatio = tqCurrentRatio;
    }

    public BigDecimal getSnCurrentRatio() {
        return snCurrentRatio;
    }

    public void setSnCurrentRatio(BigDecimal snCurrentRatio) {
        this.snCurrentRatio = snCurrentRatio;
    }

    public BigDecimal getDqQuickRatio() {
        return dqQuickRatio;
    }

    public void setDqQuickRatio(BigDecimal dqQuickRatio) {
        this.dqQuickRatio = dqQuickRatio;
    }

    public BigDecimal getTqQuickRatio() {
        return tqQuickRatio;
    }

    public void setTqQuickRatio(BigDecimal tqQuickRatio) {
        this.tqQuickRatio = tqQuickRatio;
    }

    public BigDecimal getSnQuickRatio() {
        return snQuickRatio;
    }

    public void setSnQuickRatio(BigDecimal snQuickRatio) {
        this.snQuickRatio = snQuickRatio;
    }

    public BigDecimal getDqDebtAssetsRatio() {
        return dqDebtAssetsRatio;
    }

    public void setDqDebtAssetsRatio(BigDecimal dqDebtAssetsRatio) {
        this.dqDebtAssetsRatio = dqDebtAssetsRatio;
    }

    public BigDecimal getTqDebtAssetsRatio() {
        return tqDebtAssetsRatio;
    }

    public void setTqDebtAssetsRatio(BigDecimal tqDebtAssetsRatio) {
        this.tqDebtAssetsRatio = tqDebtAssetsRatio;
    }

    public BigDecimal getSnDebtAssetsRatio() {
        return snDebtAssetsRatio;
    }

    public void setSnDebtAssetsRatio(BigDecimal snDebtAssetsRatio) {
        this.snDebtAssetsRatio = snDebtAssetsRatio;
    }

    public BigDecimal getDqSupExposureDays() {
        return dqSupExposureDays;
    }

    public void setDqSupExposureDays(BigDecimal dqSupExposureDays) {
        this.dqSupExposureDays = dqSupExposureDays;
    }

    public BigDecimal getTqSupExposureDays() {
        return tqSupExposureDays;
    }

    public void setTqSupExposureDays(BigDecimal tqSupExposureDays) {
        this.tqSupExposureDays = tqSupExposureDays;
    }

    public BigDecimal getSnSupExposureDays() {
        return snSupExposureDays;
    }

    public void setSnSupExposureDays(BigDecimal snSupExposureDays) {
        this.snSupExposureDays = snSupExposureDays;
    }

    public BigDecimal getDqReceiveConvRatio() {
        return dqReceiveConvRatio;
    }

    public void setDqReceiveConvRatio(BigDecimal dqReceiveConvRatio) {
        this.dqReceiveConvRatio = dqReceiveConvRatio;
    }

    public BigDecimal getTqReceiveConvRatio() {
        return tqReceiveConvRatio;
    }

    public void setTqReceiveConvRatio(BigDecimal tqReceiveConvRatio) {
        this.tqReceiveConvRatio = tqReceiveConvRatio;
    }

    public BigDecimal getSnReceiveConvRatio() {
        return snReceiveConvRatio;
    }

    public void setSnReceiveConvRatio(BigDecimal snReceiveConvRatio) {
        this.snReceiveConvRatio = snReceiveConvRatio;
    }

    public BigDecimal getDqReceiveConvDays() {
        return dqReceiveConvDays;
    }

    public void setDqReceiveConvDays(BigDecimal dqReceiveConvDays) {
        this.dqReceiveConvDays = dqReceiveConvDays;
    }

    public BigDecimal getTqReceiveConvDays() {
        return tqReceiveConvDays;
    }

    public void setTqReceiveConvDays(BigDecimal tqReceiveConvDays) {
        this.tqReceiveConvDays = tqReceiveConvDays;
    }

    public BigDecimal getSnReceiveConvDays() {
        return snReceiveConvDays;
    }

    public void setSnReceiveConvDays(BigDecimal snReceiveConvDays) {
        this.snReceiveConvDays = snReceiveConvDays;
    }

    public BigDecimal getDqDepRecConvRatio() {
        return dqDepRecConvRatio;
    }

    public void setDqDepRecConvRatio(BigDecimal dqDepRecConvRatio) {
        this.dqDepRecConvRatio = dqDepRecConvRatio;
    }

    public BigDecimal getTqDepRecConvRatio() {
        return tqDepRecConvRatio;
    }

    public void setTqDepRecConvRatio(BigDecimal tqDepRecConvRatio) {
        this.tqDepRecConvRatio = tqDepRecConvRatio;
    }

    public BigDecimal getSnDepRecConvRatio() {
        return snDepRecConvRatio;
    }

    public void setSnDepRecConvRatio(BigDecimal snDepRecConvRatio) {
        this.snDepRecConvRatio = snDepRecConvRatio;
    }

    public BigDecimal getDqDepRecConvDays() {
        return dqDepRecConvDays;
    }

    public void setDqDepRecConvDays(BigDecimal dqDepRecConvDays) {
        this.dqDepRecConvDays = dqDepRecConvDays;
    }

    public BigDecimal getTqDepRecConvDays() {
        return tqDepRecConvDays;
    }

    public void setTqDepRecConvDays(BigDecimal tqDepRecConvDays) {
        this.tqDepRecConvDays = tqDepRecConvDays;
    }

    public BigDecimal getSnDepRecConvDays() {
        return snDepRecConvDays;
    }

    public void setSnDepRecConvDays(BigDecimal snDepRecConvDays) {
        this.snDepRecConvDays = snDepRecConvDays;
    }

    public BigDecimal getDqInventoryConvRatio() {
        return dqInventoryConvRatio;
    }

    public void setDqInventoryConvRatio(BigDecimal dqInventoryConvRatio) {
        this.dqInventoryConvRatio = dqInventoryConvRatio;
    }

    public BigDecimal getTqInventoryConvRatio() {
        return tqInventoryConvRatio;
    }

    public void setTqInventoryConvRatio(BigDecimal tqInventoryConvRatio) {
        this.tqInventoryConvRatio = tqInventoryConvRatio;
    }

    public BigDecimal getSnInventoryConvRatio() {
        return snInventoryConvRatio;
    }

    public void setSnInventoryConvRatio(BigDecimal snInventoryConvRatio) {
        this.snInventoryConvRatio = snInventoryConvRatio;
    }

    public BigDecimal getDqInventoryConvDays() {
        return dqInventoryConvDays;
    }

    public void setDqInventoryConvDays(BigDecimal dqInventoryConvDays) {
        this.dqInventoryConvDays = dqInventoryConvDays;
    }

    public BigDecimal getTqInventoryConvDays() {
        return tqInventoryConvDays;
    }

    public void setTqInventoryConvDays(BigDecimal tqInventoryConvDays) {
        this.tqInventoryConvDays = tqInventoryConvDays;
    }

    public BigDecimal getSnInventoryConvDays() {
        return snInventoryConvDays;
    }

    public void setSnInventoryConvDays(BigDecimal snInventoryConvDays) {
        this.snInventoryConvDays = snInventoryConvDays;
    }

    public BigDecimal getDqDepPayConvRatio() {
        return dqDepPayConvRatio;
    }

    public void setDqDepPayConvRatio(BigDecimal dqDepPayConvRatio) {
        this.dqDepPayConvRatio = dqDepPayConvRatio;
    }

    public BigDecimal getTqDepPayConvRatio() {
        return tqDepPayConvRatio;
    }

    public void setTqDepPayConvRatio(BigDecimal tqDepPayConvRatio) {
        this.tqDepPayConvRatio = tqDepPayConvRatio;
    }

    public BigDecimal getSnDepPayConvRatio() {
        return snDepPayConvRatio;
    }

    public void setSnDepPayConvRatio(BigDecimal snDepPayConvRatio) {
        this.snDepPayConvRatio = snDepPayConvRatio;
    }

    public BigDecimal getDqDepPayConvDays() {
        return dqDepPayConvDays;
    }

    public void setDqDepPayConvDays(BigDecimal dqDepPayConvDays) {
        this.dqDepPayConvDays = dqDepPayConvDays;
    }

    public BigDecimal getTqDepPayConvDays() {
        return tqDepPayConvDays;
    }

    public void setTqDepPayConvDays(BigDecimal tqDepPayConvDays) {
        this.tqDepPayConvDays = tqDepPayConvDays;
    }

    public BigDecimal getSnDepPayConvDays() {
        return snDepPayConvDays;
    }

    public void setSnDepPayConvDays(BigDecimal snDepPayConvDays) {
        this.snDepPayConvDays = snDepPayConvDays;
    }

    public BigDecimal getDqAccPayConvRatio() {
        return dqAccPayConvRatio;
    }

    public void setDqAccPayConvRatio(BigDecimal dqAccPayConvRatio) {
        this.dqAccPayConvRatio = dqAccPayConvRatio;
    }

    public BigDecimal getTqAccPayConvRatio() {
        return tqAccPayConvRatio;
    }

    public void setTqAccPayConvRatio(BigDecimal tqAccPayConvRatio) {
        this.tqAccPayConvRatio = tqAccPayConvRatio;
    }

    public BigDecimal getSnAccPayConvRatio() {
        return snAccPayConvRatio;
    }

    public void setSnAccPayConvRatio(BigDecimal snAccPayConvRatio) {
        this.snAccPayConvRatio = snAccPayConvRatio;
    }

    public BigDecimal getDqAccPayConvDays() {
        return dqAccPayConvDays;
    }

    public void setDqAccPayConvDays(BigDecimal dqAccPayConvDays) {
        this.dqAccPayConvDays = dqAccPayConvDays;
    }

    public BigDecimal getTqAccPayConvDays() {
        return tqAccPayConvDays;
    }

    public void setTqAccPayConvDays(BigDecimal tqAccPayConvDays) {
        this.tqAccPayConvDays = tqAccPayConvDays;
    }

    public BigDecimal getSnAccPayConvDays() {
        return snAccPayConvDays;
    }

    public void setSnAccPayConvDays(BigDecimal snAccPayConvDays) {
        this.snAccPayConvDays = snAccPayConvDays;
    }

    public BigDecimal getDqOperateCycle() {
        return dqOperateCycle;
    }

    public void setDqOperateCycle(BigDecimal dqOperateCycle) {
        this.dqOperateCycle = dqOperateCycle;
    }

    public BigDecimal getTqOperateCycle() {
        return tqOperateCycle;
    }

    public void setTqOperateCycle(BigDecimal tqOperateCycle) {
        this.tqOperateCycle = tqOperateCycle;
    }

    public BigDecimal getSnOperateCycle() {
        return snOperateCycle;
    }

    public void setSnOperateCycle(BigDecimal snOperateCycle) {
        this.snOperateCycle = snOperateCycle;
    }

    public BigDecimal getDqCashCycle() {
        return dqCashCycle;
    }

    public void setDqCashCycle(BigDecimal dqCashCycle) {
        this.dqCashCycle = dqCashCycle;
    }

    public BigDecimal getTqCashCycle() {
        return tqCashCycle;
    }

    public void setTqCashCycle(BigDecimal tqCashCycle) {
        this.tqCashCycle = tqCashCycle;
    }

    public BigDecimal getSnCashCycle() {
        return snCashCycle;
    }

    public void setSnCashCycle(BigDecimal snCashCycle) {
        this.snCashCycle = snCashCycle;
    }

    public BigDecimal getDqRota() {
        return dqRota;
    }

    public void setDqRota(BigDecimal dqRota) {
        this.dqRota = dqRota;
    }

    public BigDecimal getTqRota() {
        return tqRota;
    }

    public void setTqRota(BigDecimal tqRota) {
        this.tqRota = tqRota;
    }

    public BigDecimal getSnRota() {
        return snRota;
    }

    public void setSnRota(BigDecimal snRota) {
        this.snRota = snRota;
    }

    public BigDecimal getDqRoe() {
        return dqRoe;
    }

    public void setDqRoe(BigDecimal dqRoe) {
        this.dqRoe = dqRoe;
    }

    public BigDecimal getTqRoe() {
        return tqRoe;
    }

    public void setTqRoe(BigDecimal tqRoe) {
        this.tqRoe = tqRoe;
    }

    public BigDecimal getSnRoe() {
        return snRoe;
    }

    public void setSnRoe(BigDecimal snRoe) {
        this.snRoe = snRoe;
    }

    public BigDecimal getDqGrossProfitRatio() {
        return dqGrossProfitRatio;
    }

    public void setDqGrossProfitRatio(BigDecimal dqGrossProfitRatio) {
        this.dqGrossProfitRatio = dqGrossProfitRatio;
    }

    public BigDecimal getTqGrossProfitRatio() {
        return tqGrossProfitRatio;
    }

    public void setTqGrossProfitRatio(BigDecimal tqGrossProfitRatio) {
        this.tqGrossProfitRatio = tqGrossProfitRatio;
    }

    public BigDecimal getSnGrossProfitRatio() {
        return snGrossProfitRatio;
    }

    public void setSnGrossProfitRatio(BigDecimal snGrossProfitRatio) {
        this.snGrossProfitRatio = snGrossProfitRatio;
    }

    public BigDecimal getDqSaleGrowthRatio() {
        return dqSaleGrowthRatio;
    }

    public void setDqSaleGrowthRatio(BigDecimal dqSaleGrowthRatio) {
        this.dqSaleGrowthRatio = dqSaleGrowthRatio;
    }

    public BigDecimal getTqSaleGrowthRatio() {
        return tqSaleGrowthRatio;
    }

    public void setTqSaleGrowthRatio(BigDecimal tqSaleGrowthRatio) {
        this.tqSaleGrowthRatio = tqSaleGrowthRatio;
    }

    public BigDecimal getSnSaleGrowthRatio() {
        return snSaleGrowthRatio;
    }

    public void setSnSaleGrowthRatio(BigDecimal snSaleGrowthRatio) {
        this.snSaleGrowthRatio = snSaleGrowthRatio;
    }

    public BigDecimal getDqNetGrowthRatio() {
        return dqNetGrowthRatio;
    }

    public void setDqNetGrowthRatio(BigDecimal dqNetGrowthRatio) {
        this.dqNetGrowthRatio = dqNetGrowthRatio;
    }

    public BigDecimal getTqNetGrowthRatio() {
        return tqNetGrowthRatio;
    }

    public void setTqNetGrowthRatio(BigDecimal tqNetGrowthRatio) {
        this.tqNetGrowthRatio = tqNetGrowthRatio;
    }

    public BigDecimal getSnNetGrowthRatio() {
        return snNetGrowthRatio;
    }

    public void setSnNetGrowthRatio(BigDecimal snNetGrowthRatio) {
        this.snNetGrowthRatio = snNetGrowthRatio;
    }

    public BigDecimal getDqOperateProfitRatio() {
        return dqOperateProfitRatio;
    }

    public void setDqOperateProfitRatio(BigDecimal dqOperateProfitRatio) {
        this.dqOperateProfitRatio = dqOperateProfitRatio;
    }

    public BigDecimal getTqOperateProfitRatio() {
        return tqOperateProfitRatio;
    }

    public void setTqOperateProfitRatio(BigDecimal tqOperateProfitRatio) {
        this.tqOperateProfitRatio = tqOperateProfitRatio;
    }

    public BigDecimal getSnOperateProfitRatio() {
        return snOperateProfitRatio;
    }

    public void setSnOperateProfitRatio(BigDecimal snOperateProfitRatio) {
        this.snOperateProfitRatio = snOperateProfitRatio;
    }

    public BigDecimal getDqSaleNetRatio() {
        return dqSaleNetRatio;
    }

    public void setDqSaleNetRatio(BigDecimal dqSaleNetRatio) {
        this.dqSaleNetRatio = dqSaleNetRatio;
    }

    public BigDecimal getTqSaleNetRatio() {
        return tqSaleNetRatio;
    }

    public void setTqSaleNetRatio(BigDecimal tqSaleNetRatio) {
        this.tqSaleNetRatio = tqSaleNetRatio;
    }

    public BigDecimal getSnSaleNetRatio() {
        return snSaleNetRatio;
    }

    public void setSnSaleNetRatio(BigDecimal snSaleNetRatio) {
        this.snSaleNetRatio = snSaleNetRatio;
    }

    public BigDecimal getDqThirdRatio() {
        return dqThirdRatio;
    }

    public void setDqThirdRatio(BigDecimal dqThirdRatio) {
        this.dqThirdRatio = dqThirdRatio;
    }

    public BigDecimal getTqThirdRatio() {
        return tqThirdRatio;
    }

    public void setTqThirdRatio(BigDecimal tqThirdRatio) {
        this.tqThirdRatio = tqThirdRatio;
    }

    public BigDecimal getSnThirdRatio() {
        return snThirdRatio;
    }

    public void setSnThirdRatio(BigDecimal snThirdRatio) {
        this.snThirdRatio = snThirdRatio;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl == null ? null : lvl.trim();
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

    public BigDecimal getTbCurrentRatio() {
        return tbCurrentRatio;
    }

    public void setTbCurrentRatio(BigDecimal tbCurrentRatio) {
        this.tbCurrentRatio = tbCurrentRatio;
    }

    public BigDecimal getTbQuickRatio() {
        return tbQuickRatio;
    }

    public void setTbQuickRatio(BigDecimal tbQuickRatio) {
        this.tbQuickRatio = tbQuickRatio;
    }

    public BigDecimal getTbDebtAssetsRatio() {
        return tbDebtAssetsRatio;
    }

    public void setTbDebtAssetsRatio(BigDecimal tbDebtAssetsRatio) {
        this.tbDebtAssetsRatio = tbDebtAssetsRatio;
    }

    public BigDecimal getTbReceiveConvRatio() {
        return tbReceiveConvRatio;
    }

    public void setTbReceiveConvRatio(BigDecimal tbReceiveConvRatio) {
        this.tbReceiveConvRatio = tbReceiveConvRatio;
    }

    public BigDecimal getTbReceiveConvDays() {
        return tbReceiveConvDays;
    }

    public void setTbReceiveConvDays(BigDecimal tbReceiveConvDays) {
        this.tbReceiveConvDays = tbReceiveConvDays;
    }

    public BigDecimal getTbOperateCycle() {
        return tbOperateCycle;
    }

    public void setTbOperateCycle(BigDecimal tbOperateCycle) {
        this.tbOperateCycle = tbOperateCycle;
    }

    public BigDecimal getTbCashCycle() {
        return tbCashCycle;
    }

    public void setTbCashCycle(BigDecimal tbCashCycle) {
        this.tbCashCycle = tbCashCycle;
    }

    public BigDecimal getTbRota() {
        return tbRota;
    }

    public void setTbRota(BigDecimal tbRota) {
        this.tbRota = tbRota;
    }

    public BigDecimal getTbRoe() {
        return tbRoe;
    }

    public void setTbRoe(BigDecimal tbRoe) {
        this.tbRoe = tbRoe;
    }

    public BigDecimal getTbGrossProfitRatio() {
        return tbGrossProfitRatio;
    }

    public void setTbGrossProfitRatio(BigDecimal tbGrossProfitRatio) {
        this.tbGrossProfitRatio = tbGrossProfitRatio;
    }

    public BigDecimal getTbSaleGrowthRatio() {
        return tbSaleGrowthRatio;
    }

    public void setTbSaleGrowthRatio(BigDecimal tbSaleGrowthRatio) {
        this.tbSaleGrowthRatio = tbSaleGrowthRatio;
    }

    public BigDecimal getTbNetGrowthRatio() {
        return tbNetGrowthRatio;
    }

    public void setTbNetGrowthRatio(BigDecimal tbNetGrowthRatio) {
        this.tbNetGrowthRatio = tbNetGrowthRatio;
    }

    public BigDecimal getTbOperateProfitRatio() {
        return tbOperateProfitRatio;
    }

    public void setTbOperateProfitRatio(BigDecimal tbOperateProfitRatio) {
        this.tbOperateProfitRatio = tbOperateProfitRatio;
    }

    public BigDecimal getTbSaleNetRatio() {
        return tbSaleNetRatio;
    }

    public void setTbSaleNetRatio(BigDecimal tbSaleNetRatio) {
        this.tbSaleNetRatio = tbSaleNetRatio;
    }

    public BigDecimal getTbThirdRatio() {
        return tbThirdRatio;
    }

    public void setTbThirdRatio(BigDecimal tbThirdRatio) {
        this.tbThirdRatio = tbThirdRatio;
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

}