package cn.htd.argus.service;

import cn.htd.argus.dto.HtyFctOrgSaleDTO;

/**
 * Created by wangtp on 2017/9/26.
 */
public interface HtyFctOrgSaleDTOService {

    HtyFctOrgSaleDTO selectByPrimaryKey(Long id);

    HtyFctOrgSaleDTO select(HtyFctOrgSaleDTO dto);
    
    HtyFctOrgSaleDTO selectByOrgCode(Long userId);
}
