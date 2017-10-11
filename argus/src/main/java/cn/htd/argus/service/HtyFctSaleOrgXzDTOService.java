package cn.htd.argus.service;

import cn.htd.argus.dto.HtyFctSaleOrgXzDTO;

/**
 * Created by wangtp on 2017/10/10.
 */
public interface HtyFctSaleOrgXzDTOService {
    HtyFctSaleOrgXzDTO selectByOrgCode(String userId);
}
