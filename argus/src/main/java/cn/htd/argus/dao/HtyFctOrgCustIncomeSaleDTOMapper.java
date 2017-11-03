package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctOrgCustIncomeSaleDTO;

import java.util.List;

public interface HtyFctOrgCustIncomeSaleDTOMapper {

    HtyFctOrgCustIncomeSaleDTO selectByPrimaryKey(Long id);

    List<HtyFctOrgCustIncomeSaleDTO> select(HtyFctOrgCustIncomeSaleDTO model);
    
    List<HtyFctOrgCustIncomeSaleDTO> selectMonth(HtyFctOrgCustIncomeSaleDTO model);
}