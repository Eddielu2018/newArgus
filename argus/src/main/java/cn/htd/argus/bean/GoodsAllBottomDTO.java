package cn.htd.argus.bean;

import cn.htd.argus.dto.HtyFctProdDetailOrgDTO;

import java.util.List;

/**
 * Created by wangtp on 2017/12/19.
 */
public class GoodsAllBottomDTO {
    private Integer num;

    private List<HtyFctProdDetailOrgDTO> list;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<HtyFctProdDetailOrgDTO> getList() {
        return list;
    }

    public void setList(List<HtyFctProdDetailOrgDTO> list) {
        this.list = list;
    }
}
