package cn.htd.argus.service;

import cn.htd.argus.dto.HtyFctInventoryTurnsOrgDTO;
import cn.htd.common.Pager;

import java.util.List;

/**
 * Created by wangtp on 2017/12/18.
 */
public interface HtyFctInventoryTurnsOrgDTOService {
    List<HtyFctInventoryTurnsOrgDTO> queryInventoryTurns(String userId, String endTime,Pager pager,String range);

    Integer queryInventoryTurnsCount(String userId, String endTime,String range);
}
