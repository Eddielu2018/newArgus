package cn.htd.argus.bean;

import cn.htd.argus.dto.HtyFctCustAllDto;
import cn.htd.argus.dto.HtyFctMemberOrgDetail;

import java.math.BigDecimal;
import java.util.List;

public class HtyFctCustAllOutDTO {
    //活跃会员店
    List<HtyFctCustAllDto> htyFctCustAllDtoList;
    //导出明细
    List<HtyFctCustAllDto> custAllExportList;
    //导出明细 vip
    List<HtyFctCustAllDto> exportVipList;
    //导出明细 月度分析 销售占比
    List<HtyFctMemberOrgDetail>saleNumEachShopAllList;
    //销售占比页面
        //会员店名称
    List<String> hyNameList;
        //销售额
    List<BigDecimal>hyShopSaleNumList;
        //销售占比
    List<BigDecimal>saleRatioList;
    //最近一次购买日期
    List<String>lastBuyDateList;
    //间隔天数
    List<Integer>intervalDaysList;
    //近6个月趋势
    List<String>dateListLastSixMonth;
    List<BigDecimal> saleLastSixMonthList;
    //购买频次排序
    List<BigDecimal>buyCountList;
    //间隔日期排序
    List<Integer>intervalDaysSortList;

    public List<HtyFctCustAllDto> getHtyFctCustAllDtoList() {
        return htyFctCustAllDtoList;
    }

    public void setHtyFctCustAllDtoList(List<HtyFctCustAllDto> htyFctCustAllDtoList) {
        this.htyFctCustAllDtoList = htyFctCustAllDtoList;
    }
    public void setCustAllExportList(List<HtyFctCustAllDto> custAllExportList) {
        this.custAllExportList = custAllExportList;
    }

    public List<HtyFctCustAllDto> getExportVipList() {
        return exportVipList;
    }

    public void setExportVipList(List<HtyFctCustAllDto> exportVipList) {
        this.exportVipList = exportVipList;
    }

    public List<String> getHyNameList() {
        return hyNameList;
    }

    public void setHyNameList(List<String> hyNameList) {
        this.hyNameList = hyNameList;
    }

    public List<BigDecimal> getHyShopSaleNumList() {
        return hyShopSaleNumList;
    }

    public void setHyShopSaleNumList(List<BigDecimal> hyShopSaleNumList) {
        this.hyShopSaleNumList = hyShopSaleNumList;
    }

    public List<BigDecimal> getSaleRatioList() {
        return saleRatioList;
    }

    public void setSaleRatioList(List<BigDecimal> saleRatioList) {
        this.saleRatioList = saleRatioList;
    }

    public List<String> getLastBuyDateList() {
        return lastBuyDateList;
    }

    public void setLastBuyDateList(List<String> lastBuyDateList) {
        this.lastBuyDateList = lastBuyDateList;
    }

    public List<Integer> getIntervalDaysList() {
        return intervalDaysList;
    }

    public void setIntervalDaysList(List<Integer> intervalDaysList) {
        this.intervalDaysList = intervalDaysList;
    }

    public List<String> getDateListLastSixMonth() {
        return dateListLastSixMonth;
    }

    public void setDateListLastSixMonth(List<String> dateListLastSixMonth) {
        this.dateListLastSixMonth = dateListLastSixMonth;
    }

    public List<BigDecimal> getSaleLastSixMonthList() {
        return saleLastSixMonthList;
    }

    public void setSaleLastSixMonthList(List<BigDecimal> saleLastSixMonthList) {
        this.saleLastSixMonthList = saleLastSixMonthList;
    }

    public List<HtyFctMemberOrgDetail> getSaleNumEachShopAllList() {
        return saleNumEachShopAllList;
    }

    public void setSaleNumEachShopAllList(List<HtyFctMemberOrgDetail> saleNumEachShopAllList) {
        this.saleNumEachShopAllList = saleNumEachShopAllList;
    }

    public List<HtyFctCustAllDto> getCustAllExportList() {
        return custAllExportList;
    }

    public List<BigDecimal> getBuyCountList() {
        return buyCountList;
    }

    public void setBuyCountList(List<BigDecimal> buyCountList) {
        this.buyCountList = buyCountList;
    }

    public List<Integer> getIntervalDaysSortList() {
        return intervalDaysSortList;
    }

    public void setIntervalDaysSortList(List<Integer> intervalDaysSortList) {
        this.intervalDaysSortList = intervalDaysSortList;
    }
}

