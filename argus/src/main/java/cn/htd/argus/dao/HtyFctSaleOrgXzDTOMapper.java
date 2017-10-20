package cn.htd.argus.dao;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctSaleOrgXzDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HtyFctSaleOrgXzDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctSaleOrgXzDTO record);

    int insertSelective(HtyFctSaleOrgXzDTO record);

    HtyFctSaleOrgXzDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctSaleOrgXzDTO record);

    int updateByPrimaryKey(HtyFctSaleOrgXzDTO record);

    HtyFctSaleOrgXzDTO selectByOrgCode(HtyFctSaleOrgXzDTO model);

    List<HtyFctSaleOrgXzDTO> selectByMonthSearchDTO(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);

    HtyFctSaleOrgXzDTO selectByYearSearchDTO(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);
}