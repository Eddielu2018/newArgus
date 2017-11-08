package cn.htd.argus.service;

import java.util.List;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctSaleCityProdDTO;
import org.apache.ibatis.annotations.Param;

public interface HtyFctSaleCityProdDTOService {
	List<HtyFctSaleCityProdDTO> querySaleOutItemNum(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    List<HtyFctSaleCityProdDTO> queryProAndCity(HtyFctSaleCityProdDTO HtyFctSaleCityProdDTO,HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
}
