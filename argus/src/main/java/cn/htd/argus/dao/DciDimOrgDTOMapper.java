package dao;

import dto.DciDimOrgDTO;

public interface DciDimOrgDTOMapper {
    int insert(DciDimOrgDTO record);

    int insertSelective(DciDimOrgDTO record);
}