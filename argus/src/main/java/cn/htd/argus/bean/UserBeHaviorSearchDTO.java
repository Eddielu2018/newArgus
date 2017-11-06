package cn.htd.argus.bean;

import java.math.BigDecimal;
import java.util.List;

import cn.htd.argus.dto.HtyFctSaleCityProdDTO;
import cn.htd.argus.dto.HtyFctXwB2bConvFunnelDTO;
import cn.htd.argus.dto.HtyFctXwB2bItemAccessDTO;
import cn.htd.argus.dto.HtyFctXwB2bLndPageDTO;
import cn.htd.argus.dto.HtyFctXwB2bSearchKeyDTO;

//落地页面的返回bean
public class UserBeHaviorSearchDTO {
    // 落地页面访问数量
    List<String> b2bLndPageList;
    List<BigDecimal> b2bLndPageNumList;
    // 搜索量
    List<String> b2bSearchKeyList;
    List<BigDecimal> b2bSearchKeyNumList;
	// 单品访问数量
    List<String> b2bItemAccessList;
    List<BigDecimal> b2bItemAccessNumList;
	// 单品销售数量
    List<String> b2bSaleCityProdyList;
    List<BigDecimal> b2bSaleCityProdNumList;
	// 漏斗转化
    List<String> b2bConvFunnelList;
    List<BigDecimal> b2bConvFunnelNumList;
    //复购
    List<String> b2bRepeatBuyList;
    List<BigDecimal> b2bRepeatBuyNumList;
    public List<String> getB2bSearchKeyList() {
        return b2bSearchKeyList;
    }

    public void setB2bSearchKeyList(List<String> b2bSearchKeyList) {
        this.b2bSearchKeyList = b2bSearchKeyList;
    }

    public List<BigDecimal> getB2bSearchKeyNumList() {
        return b2bSearchKeyNumList;
    }

    public void setB2bSearchKeyNumList(List<BigDecimal> b2bSearchKeyNumList) {
        this.b2bSearchKeyNumList = b2bSearchKeyNumList;
    }

    public List<String> getB2bLndPageList() {
        return b2bLndPageList;
    }

    public void setB2bLndPageList(List<String> b2bLndPageList) {
        this.b2bLndPageList = b2bLndPageList;
    }

    public List<BigDecimal> getB2bLndPageNumList() {
        return b2bLndPageNumList;
    }

    public void setB2bLndPageNumList(List<BigDecimal> b2bLndPageNumList) {
        this.b2bLndPageNumList = b2bLndPageNumList;
    }

    public List<String> getB2bItemAccessList() {
        return b2bItemAccessList;
    }

    public void setB2bItemAccessList(List<String> b2bItemAccessList) {
        this.b2bItemAccessList = b2bItemAccessList;
    }

    public List<BigDecimal> getB2bItemAccessNumList() {
        return b2bItemAccessNumList;
    }

    public void setB2bItemAccessNumList(List<BigDecimal> b2bItemAccessNumList) {
        this.b2bItemAccessNumList = b2bItemAccessNumList;
    }

    public List<String> getB2bSaleCityProdyList() {
        return b2bSaleCityProdyList;
    }

    public void setB2bSaleCityProdyList(List<String> b2bSaleCityProdyList) {
        this.b2bSaleCityProdyList = b2bSaleCityProdyList;
    }

    public List<BigDecimal> getB2bSaleCityProdNumList() {
        return b2bSaleCityProdNumList;
    }

    public void setB2bSaleCityProdNumList(List<BigDecimal> b2bSaleCityProdNumList) {
        this.b2bSaleCityProdNumList = b2bSaleCityProdNumList;
    }

    public List<String> getB2bConvFunnelList() {
        return b2bConvFunnelList;
    }

    public void setB2bConvFunnelList(List<String> b2bConvFunnelList) {
        this.b2bConvFunnelList = b2bConvFunnelList;
    }

    public List<BigDecimal> getB2bConvFunnelNumList() {
        return b2bConvFunnelNumList;
    }

    public void setB2bConvFunnelNumList(List<BigDecimal> b2bConvFunnelNumList) {
        this.b2bConvFunnelNumList = b2bConvFunnelNumList;
    }

    public List<String> getB2bRepeatBuyList() {
        return b2bRepeatBuyList;
    }

    public void setB2bRepeatBuyList(List<String> b2bRepeatBuyList) {
        this.b2bRepeatBuyList = b2bRepeatBuyList;
    }

    public List<BigDecimal> getB2bRepeatBuyNumList() {
        return b2bRepeatBuyNumList;
    }

    public void setB2bRepeatBuyNumList(List<BigDecimal> b2bRepeatBuyNumList) {
        this.b2bRepeatBuyNumList = b2bRepeatBuyNumList;
    }
}
