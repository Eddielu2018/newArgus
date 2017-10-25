package cn.htd.argus.service;

import java.util.List;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctSaleCityProdDTO;

public interface HtyFctSaleCityProdDTOService {
	List<HtyFctSaleCityProdDTO> querySaleOutItemNum(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
}
