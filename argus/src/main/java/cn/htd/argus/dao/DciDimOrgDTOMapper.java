package cn.htd.argus.dao;

import cn.htd.argus.dto.DciDimOrgDTO;

import java.util.List;

public interface DciDimOrgDTOMapper {

    DciDimOrgDTO selectByPrimaryKey(Long id);

    List<DciDimOrgDTO> select(DciDimOrgDTO model);
    
    int selectAllNum();
}