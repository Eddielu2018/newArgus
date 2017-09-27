package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctOrgCustDTO;

import java.util.List;

public interface HtyFctOrgCustDTOMapper {

    HtyFctOrgCustDTO selectByPrimaryKey(Long id);

    List<HtyFctOrgCustDTO> select(HtyFctOrgCustDTO model);
    
    HtyFctOrgCustDTO selectByOrgCode(Long orgCode);
}