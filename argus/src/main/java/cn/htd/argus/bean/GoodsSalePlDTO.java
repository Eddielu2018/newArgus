package cn.htd.argus.bean;

import cn.htd.argus.dto.HtyFctSalePlAnalysisOrgDTO;
import cn.htd.argus.dto.HtyFctSalePpAnalysisOrgDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by wangtp on 2018/1/10.
 */
public class GoodsSalePlDTO {
    //品类圆形图
    private List<Map<String,String>> wholePl;
    //品类销售总额
    private BigDecimal amtAllPl;
    //品类
    List<HtyFctSalePlAnalysisOrgDTO> plList;
    //品牌圆形图
    private List<Map<String,String>> wholePp;
    //品牌
    List<HtyFctSalePpAnalysisOrgDTO> ppList;
    //品牌销售总额
    private BigDecimal amtAllPp;

    public List<Map<String, String>> getWholePl() {
        return wholePl;
    }

    public void setWholePl(List<Map<String, String>> wholePl) {
        this.wholePl = wholePl;
    }

    public List<HtyFctSalePlAnalysisOrgDTO> getPlList() {
        return plList;
    }

    public void setPlList(List<HtyFctSalePlAnalysisOrgDTO> plList) {
        this.plList = plList;
    }

    public List<Map<String, String>> getWholePp() {
        return wholePp;
    }

    public void setWholePp(List<Map<String, String>> wholePp) {
        this.wholePp = wholePp;
    }

    public List<HtyFctSalePpAnalysisOrgDTO> getPpList() {
        return ppList;
    }

    public void setPpList(List<HtyFctSalePpAnalysisOrgDTO> ppList) {
        this.ppList = ppList;
    }

    public BigDecimal getAmtAllPl() {
        return amtAllPl;
    }

    public void setAmtAllPl(BigDecimal amtAllPl) {
        this.amtAllPl = amtAllPl;
    }

    public BigDecimal getAmtAllPp() {
        return amtAllPp;
    }

    public void setAmtAllPp(BigDecimal amtAllPp) {
        this.amtAllPp = amtAllPp;
    }
}
