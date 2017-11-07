package cn.htd.argus.service;

import java.util.List;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctXwB2bLndPageDTO;
import org.apache.ibatis.annotations.Param;

public interface HtyFctXwB2bLndPageDTOService {
	List<HtyFctXwB2bLndPageDTO> queryAllAccessQty(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    List<HtyFctXwB2bLndPageDTO> queryByProNameAndCityName(HtyFctXwB2bLndPageDTO htyFctXwB2bLndPageDTO,HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    HtyFctXwB2bLndPageDTO queryCityName(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    HtyFctXwB2bLndPageDTO  queryProName(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
}
