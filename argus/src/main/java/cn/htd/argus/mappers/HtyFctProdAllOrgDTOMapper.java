package cn.htd.argus.mappers;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctProdAllOrgDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HtyFctProdAllOrgDTOMapper {
    int insert(HtyFctProdAllOrgDTO record);

    int insertSelective(HtyFctProdAllOrgDTO record);

    List<HtyFctProdAllOrgDTO> selectAllHead(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);
}