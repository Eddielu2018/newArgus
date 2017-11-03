package cn.htd.argus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctXwB2bSearchKeyDTO;

/**
 * @author suntao
 * @since 2017/10/16
 * */
public interface HtyFctXwB2bSearchKeyDTOMapper {
    List<HtyFctXwB2bSearchKeyDTO> queryAllSearchKeyWord(@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    List<HtyFctXwB2bSearchKeyDTO> queryByNameSearchKey(@Param("htyFctXwB2bSearchKeyDTO")HtyFctXwB2bSearchKeyDTO htyFctXwB2bSearchKeyDTO,@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    HtyFctXwB2bSearchKeyDTO   queryCityNameSearchKey(@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    HtyFctXwB2bSearchKeyDTO   queryProNameSearchKey(@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
}
