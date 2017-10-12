package cn.htd.argus.bean;

import java.util.List;

/**
 * Created by wangtp on 2017/10/11.
 */
public class SaleProdListDTO {
    private Long saleProdnum;
    private List<SaleProdDTO> saleProdDTOList;

    public Long getSaleProdnum() {
        return saleProdnum;
    }

    public void setSaleProdnum(Long saleProdnum) {
        this.saleProdnum = saleProdnum;
    }

    public List<SaleProdDTO> getSaleProdDTOList() {
        return saleProdDTOList;
    }

    public void setSaleProdDTOList(List<SaleProdDTO> saleProdDTOList) {
        this.saleProdDTOList = saleProdDTOList;
    }
}
