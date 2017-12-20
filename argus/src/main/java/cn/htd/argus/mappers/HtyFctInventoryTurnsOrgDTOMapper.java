package cn.htd.argus.mappers;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctInventoryTurnsOrgDTO;
import cn.htd.common.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HtyFctInventoryTurnsOrgDTOMapper {
    int insert(HtyFctInventoryTurnsOrgDTO record);

    int insertSelective(HtyFctInventoryTurnsOrgDTO record);

    List<HtyFctInventoryTurnsOrgDTO> queryInventoryTurns(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO,@Param("pager") Pager pager);

    Integer queryInventoryTurnsCount(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);
}