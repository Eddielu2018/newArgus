package cn.htd.argus.service;

import cn.htd.argus.dto.HtyFctSaleOrgDetailDTO;

/**
 * Created by wangtp on 2017/10/10.
 */
public interface HtyFctSaleOrgDetailDTOService {
    HtyFctSaleOrgDetailDTO selectByOrgCode(String userId);
}
