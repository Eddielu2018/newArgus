package dao;

import dto.HtyFctOrgSaleDTO;

public interface HtyFctOrgSaleDTOMapper {
    int insert(HtyFctOrgSaleDTO record);

    int insertSelective(HtyFctOrgSaleDTO record);
}