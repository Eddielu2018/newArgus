package cn.htd.argus.mappers;

import cn.htd.argus.dto.HtyFctInventoryTurnsOrgDTO;

public interface HtyFctInventoryTurnsOrgDTOMapper {
    int insert(HtyFctInventoryTurnsOrgDTO record);

    int insertSelective(HtyFctInventoryTurnsOrgDTO record);
}