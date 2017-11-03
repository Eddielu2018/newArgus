package cn.htd.argus.service;

import cn.htd.argus.dto.DciDimOrgDTO;

/**
 * Created by wangtp on 2017/9/26.
 */
public interface DciDimOrgDTOService {

    DciDimOrgDTO selectByPrimaryKey(Long id);

    DciDimOrgDTO select(DciDimOrgDTO dto);
    
    int selectAllNum();
    
    Integer selectRegionNum(String userId);
}
