package cn.htd.argus.dao;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctSaleOrgAllDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HtyFctSaleOrgAllDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctSaleOrgAllDTO record);

    int insertSelective(HtyFctSaleOrgAllDTO record);

    HtyFctSaleOrgAllDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctSaleOrgAllDTO record);

    int updateByPrimaryKey(HtyFctSaleOrgAllDTO record);

    List<HtyFctSaleOrgAllDTO> selectByOrgCode(@Param("searchDTO")HtyFctSaleOrgAllDTO model);

    HtyFctSaleOrgAllDTO selectByOrgSearchDTO(@Param("searchDTO")HtyFctSaleSearchDTO htyFctSaleSearchDTO);
}