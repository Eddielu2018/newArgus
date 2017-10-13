package cn.htd.argus.dao;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctSaleXzHotDTO;
import cn.htd.common.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HtyFctSaleXzHotDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctSaleXzHotDTO record);

    int insertSelective(HtyFctSaleXzHotDTO record);

    HtyFctSaleXzHotDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctSaleXzHotDTO record);

    int updateByPrimaryKey(HtyFctSaleXzHotDTO record);

    HtyFctSaleXzHotDTO selectByOrgCode(HtyFctSaleXzHotDTO model);

    Long queryPageCount(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);

    List<HtyFctSaleXzHotDTO> queryPage(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO, @Param("pager") Pager pager);

    List<HtyFctSaleXzHotDTO> queryBrand();

    List<HtyFctSaleXzHotDTO> queryCategory();
}