package cn.htd.argus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctSaleCityProdDTO;

/**
 * @author suntao
 * @since 2017/10/16
 * */
public interface HtyFctSaleCityProdDTOMapper {
	List<HtyFctSaleCityProdDTO> querySaleOutItemNum(@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    List<HtyFctSaleCityProdDTO> queryProAndCity(@Param("htyFctSaleCityProdDTO")HtyFctSaleCityProdDTO HtyFctSaleCityProdDTO,@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
}
