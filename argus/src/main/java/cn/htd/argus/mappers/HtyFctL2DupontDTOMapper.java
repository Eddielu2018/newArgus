package cn.htd.argus.mappers;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctL2DupontDTO;
import org.apache.ibatis.annotations.Param;

public interface HtyFctL2DupontDTOMapper {

    HtyFctL2DupontDTO select(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);
}