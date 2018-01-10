package cn.htd.argus.mappers;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctProdDetailOrgDTO;
import cn.htd.common.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HtyFctProdDetailOrgDTOMapper {
    int insert(HtyFctProdDetailOrgDTO record);

    int insertSelective(HtyFctProdDetailOrgDTO record);

    List<HtyFctProdDetailOrgDTO> queryAllBottom(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO,@Param("pager") Pager pager);

    Integer queryAllBottomCount(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);

}