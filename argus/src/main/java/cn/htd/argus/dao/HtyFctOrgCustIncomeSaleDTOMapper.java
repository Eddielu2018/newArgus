package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctOrgCustIncomeSaleDTO;

import java.util.List;

public interface HtyFctOrgCustIncomeSaleDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctOrgCustIncomeSaleDTO record);

    int insertSelective(HtyFctOrgCustIncomeSaleDTO record);

    HtyFctOrgCustIncomeSaleDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctOrgCustIncomeSaleDTO record);

    int updateByPrimaryKey(HtyFctOrgCustIncomeSaleDTO record);

    List<HtyFctOrgCustIncomeSaleDTO> select(HtyFctOrgCustIncomeSaleDTO model);
}