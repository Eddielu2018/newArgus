package cn.htd.argus.mappers;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctSaleXzHotDTO;
import cn.htd.common.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HtyFctSaleXzHotDTOMapper {

    Long queryPageSumCount(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);

    List<HtyFctSaleXzHotDTO> querySumPage(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO, @Param("pager") Pager pager);

    List<HtyFctSaleXzHotDTO> queryBrand(String plCode);

    List<HtyFctSaleXzHotDTO> queryCategory();
}