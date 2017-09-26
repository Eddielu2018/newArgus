package dao;

import dto.HtyFctOrgCustDTO;

public interface HtyFctOrgCustDTOMapper {
    int insert(HtyFctOrgCustDTO record);

    int insertSelective(HtyFctOrgCustDTO record);
}