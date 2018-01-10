package cn.htd.argus.mappers;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctInventoryWarnsDTO;
import cn.htd.common.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HtyFctInventoryWarnsDTOMapper {
    int insert(HtyFctInventoryWarnsDTO record);

    int insertSelective(HtyFctInventoryWarnsDTO record);

    List<HtyFctInventoryWarnsDTO> queryInventoryWarns(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO,@Param("pager") Pager pager);

    Integer queryInventoryWarnsCount(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);
}