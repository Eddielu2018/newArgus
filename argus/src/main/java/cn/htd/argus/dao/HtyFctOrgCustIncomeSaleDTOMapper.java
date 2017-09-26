package dao;

import dto.HtyFctOrgCustIncomeSaleDTO;

public interface HtyFctOrgCustIncomeSaleDTOMapper {
    int insert(HtyFctOrgCustIncomeSaleDTO record);

    int insertSelective(HtyFctOrgCustIncomeSaleDTO record);
}