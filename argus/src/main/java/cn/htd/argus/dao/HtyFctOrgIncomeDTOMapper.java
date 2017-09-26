package dao;

import dto.HtyFctOrgIncomeDTO;

public interface HtyFctOrgIncomeDTOMapper {
    int insert(HtyFctOrgIncomeDTO record);

    int insertSelective(HtyFctOrgIncomeDTO record);
}