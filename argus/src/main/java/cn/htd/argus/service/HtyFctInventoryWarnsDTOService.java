package cn.htd.argus.service;

import cn.htd.argus.dto.HtyFctInventoryWarnsDTO;
import cn.htd.common.Pager;

import java.util.List;

/**
 * Created by wangtp on 2017/12/19.
 */
public interface HtyFctInventoryWarnsDTOService {
    List<HtyFctInventoryWarnsDTO> queryInventoryWarns(String userId, String endTime,Pager pager,String range);

    Integer queryInventoryWarnsCount(String userId, String endTime,String range);
}
