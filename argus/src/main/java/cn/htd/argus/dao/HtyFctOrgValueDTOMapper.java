package dao;

import dto.HtyFctOrgValueDTO;

public interface HtyFctOrgValueDTOMapper {
    int insert(HtyFctOrgValueDTO record);

    int insertSelective(HtyFctOrgValueDTO record);
}