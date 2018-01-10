package cn.htd.argus.service;

import cn.htd.argus.dto.HtyFctProdDetailOrgDTO;
import cn.htd.common.Pager;

import java.util.List;

/**
 * Created by wangtp on 2017/12/19.
 */
public interface HtyFctProdDetailOrgDTOService {

    List<HtyFctProdDetailOrgDTO> queryAllBottom(String userId, String endTime,Pager pager);

    Integer queryAllBottomCount(String userId, String endTime);
}
