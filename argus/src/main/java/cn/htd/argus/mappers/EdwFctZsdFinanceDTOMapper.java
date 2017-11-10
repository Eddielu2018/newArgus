package cn.htd.argus.mappers;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.EdwFctZsdFinanceDTO;
import org.apache.ibatis.annotations.Param;

public interface EdwFctZsdFinanceDTOMapper {
    int insert(EdwFctZsdFinanceDTO record);

    int insertSelective(EdwFctZsdFinanceDTO record);

    EdwFctZsdFinanceDTO select(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);

    EdwFctZsdFinanceDTO selectSupport(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);
}