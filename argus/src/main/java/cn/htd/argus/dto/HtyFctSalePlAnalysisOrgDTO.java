package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctSalePlAnalysisOrgDTO {
    //统计日期
    private String statDay;
    //统计日期
    private String orgCode;
    //平台公司名称
    private String orgFname;
    //商品三级类目代码
    private String plCodeLv3;
    //商品三级类目名称
    private String plNameLv3;
    //当年平台公司总销售额
    private BigDecimal saleAmtAll;
    //销量
    private BigDecimal saleQvt;
    //当年累计销售额
    private BigDecimal saleAmtYear;
    //当月累计销售额
    private BigDecimal saleAmtMon;
    //月末标识
    private String isEndflag;
    //占比
    private BigDecimal saleAvg;

    public String getStatDay() {
        return statDay;
    }

    public void setStatDay(String statDay) {
        this.statDay = statDay == null ? null : statDay.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgFname() {
        return orgFname;
    }

    public void setOrgFname(String orgFname) {
        this.orgFname = orgFname == null ? null : orgFname.trim();
    }

    public String getPlCodeLv3() {
        return plCodeLv3;
    }

    public void setPlCodeLv3(String plCodeLv3) {
        this.plCodeLv3 = plCodeLv3 == null ? null : plCodeLv3.trim();
    }

    public String getPlNameLv3() {
        return plNameLv3;
    }

    public void setPlNameLv3(String plNameLv3) {
        this.plNameLv3 = plNameLv3 == null ? null : plNameLv3.trim();
    }

    public BigDecimal getSaleAmtAll() {
        return saleAmtAll;
    }

    public void setSaleAmtAll(BigDecimal saleAmtAll) {
        this.saleAmtAll = saleAmtAll;
    }

    public BigDecimal getSaleQvt() {
        return saleQvt;
    }

    public void setSaleQvt(BigDecimal saleQvt) {
        this.saleQvt = saleQvt;
    }

    public BigDecimal getSaleAmtYear() {
        return saleAmtYear;
    }

    public void setSaleAmtYear(BigDecimal saleAmtYear) {
        this.saleAmtYear = saleAmtYear;
    }

    public BigDecimal getSaleAmtMon() {
        return saleAmtMon;
    }

    public void setSaleAmtMon(BigDecimal saleAmtMon) {
        this.saleAmtMon = saleAmtMon;
    }

    public String getIsEndflag() {
        return isEndflag;
    }

    public void setIsEndflag(String isEndflag) {
        this.isEndflag = isEndflag == null ? null : isEndflag.trim();
    }

    public BigDecimal getSaleAvg() {
        return saleAvg;
    }

    public void setSaleAvg(BigDecimal saleAvg) {
        this.saleAvg = saleAvg;
    }
}