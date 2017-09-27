package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctOrgSaleDTO;

import java.util.List;

public interface HtyFctOrgSaleDTOMapper {

    HtyFctOrgSaleDTO selectByPrimaryKey(Long id);

    List<HtyFctOrgSaleDTO> select(HtyFctOrgSaleDTO model);
    
    HtyFctOrgSaleDTO selectByOrgCode(Long orgCode);
}