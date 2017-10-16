package cn.htd.argus.service;

import cn.htd.argus.bean.SaleCompareDTO;
import cn.htd.argus.dto.HtyFctSaleOrgAllDTO;

/**
 * Created by wangtp on 2017/10/10.
 */
public interface HtyFctSaleOrgAllDTOService {
    HtyFctSaleOrgAllDTO selectByOrgCode(String userId);

    SaleCompareDTO selectCompareByOrgCode(String userId);
}
