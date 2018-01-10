package cn.htd.argus.bean;

import cn.htd.argus.dto.HtyFctInventoryWarnsDTO;

import java.util.List;

/**
 * Created by wangtp on 2017/12/20.
 */
public class GoodsWarningDTO {
    private List<HtyFctInventoryWarnsDTO> list;

    private Integer num;

    public List<HtyFctInventoryWarnsDTO> getList() {
        return list;
    }

    public void setList(List<HtyFctInventoryWarnsDTO> list) {
        this.list = list;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
