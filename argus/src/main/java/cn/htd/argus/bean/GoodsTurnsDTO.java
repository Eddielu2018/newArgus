package cn.htd.argus.bean;

import cn.htd.argus.dto.HtyFctInventoryTurnsOrgDTO;

import java.util.List;

/**
 * Created by wangtp on 2017/12/20.
 */
public class GoodsTurnsDTO {
    private List<HtyFctInventoryTurnsOrgDTO> list;

    private Integer num;

    public List<HtyFctInventoryTurnsOrgDTO> getList() {
        return list;
    }

    public void setList(List<HtyFctInventoryTurnsOrgDTO> list) {
        this.list = list;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
