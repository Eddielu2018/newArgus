package cn.htd.argus.dao;

import cn.htd.argus.dto.DciDimOrgDTO;

public interface DciDimOrgDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DciDimOrgDTO record);

    int insertSelective(DciDimOrgDTO record);

    DciDimOrgDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DciDimOrgDTO record);

    int updateByPrimaryKey(DciDimOrgDTO record);
}