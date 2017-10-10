package cn.htd.argus.service;

import cn.htd.argus.dto.HtyFctSaleOrgProdDTO;

/**
 * Created by wangtp on 2017/10/10.
 */
public interface HtyFctSaleOrgProdDTOService {
    HtyFctSaleOrgProdDTO selectByOrgCode(String userId);
}
