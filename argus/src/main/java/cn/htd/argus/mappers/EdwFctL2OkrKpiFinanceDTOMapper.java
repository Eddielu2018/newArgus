package cn.htd.argus.mappers;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.EdwFctL2OkrKpiFinanceDTO;
import org.apache.ibatis.annotations.Param;

public interface EdwFctL2OkrKpiFinanceDTOMapper {
    int insert(EdwFctL2OkrKpiFinanceDTO record);

    int insertSelective(EdwFctL2OkrKpiFinanceDTO record);

    EdwFctL2OkrKpiFinanceDTO select(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);

    EdwFctL2OkrKpiFinanceDTO selectFinance(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);
}