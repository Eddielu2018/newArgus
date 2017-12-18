package cn.htd.argus.service;

import cn.htd.argus.dto.HtyFctProdAllOrgDTO;
import cn.htd.common.Pager;

import java.util.List;

/**
 * Created by wangtp on 2017/12/18.
 */
public interface HtyFctProdAllOrgDTOService {
    HtyFctProdAllOrgDTO queryAllHead(String userId, String endTime);

    List<HtyFctProdAllOrgDTO> queryAllBottom(String userId, String endTime,Pager pager);
}
