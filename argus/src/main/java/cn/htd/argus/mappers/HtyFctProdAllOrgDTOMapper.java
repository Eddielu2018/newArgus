package cn.htd.argus.mappers;

import cn.htd.argus.dto.HtyFctProdAllOrgDTO;

public interface HtyFctProdAllOrgDTOMapper {
    int insert(HtyFctProdAllOrgDTO record);

    int insertSelective(HtyFctProdAllOrgDTO record);
}