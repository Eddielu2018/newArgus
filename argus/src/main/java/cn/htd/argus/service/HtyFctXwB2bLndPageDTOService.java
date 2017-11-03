package cn.htd.argus.service;

import java.util.List;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctXwB2bLndPageDTO;
import org.apache.ibatis.annotations.Param;

public interface HtyFctXwB2bLndPageDTOService {
	List<HtyFctXwB2bLndPageDTO> queryAllAccessQty(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    List<HtyFctXwB2bLndPageDTO> queryByProNameAndCityName(@Param("htyFctXwB2bLndPageDTO")HtyFctXwB2bLndPageDTO htyFctXwB2bLndPageDTO,@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    HtyFctXwB2bLndPageDTO queryCityName(@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    HtyFctXwB2bLndPageDTO  queryProName(@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
}
