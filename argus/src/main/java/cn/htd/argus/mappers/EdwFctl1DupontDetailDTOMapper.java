package cn.htd.argus.mappers;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.EdwFctl1DupontDetailDTO;
import org.apache.ibatis.annotations.Param;

public interface EdwFctl1DupontDetailDTOMapper {
    int insert(EdwFctl1DupontDetailDTO record);

    int insertSelective(EdwFctl1DupontDetailDTO record);

    EdwFctl1DupontDetailDTO selectTb(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);
}