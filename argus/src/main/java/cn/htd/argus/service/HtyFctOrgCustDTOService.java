package cn.htd.argus.service;

import cn.htd.argus.dto.HtyFctOrgCustDTO;

/**
 * Created by wangtp on 2017/9/26.
 */
public interface HtyFctOrgCustDTOService {

    HtyFctOrgCustDTO selectByPrimaryKey(Long id);

    HtyFctOrgCustDTO select(HtyFctOrgCustDTO dto);
    
    HtyFctOrgCustDTO selectByOrgCode(Long userId);
}
