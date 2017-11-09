package cn.htd.argus.service;

import java.util.List;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctXwB2bItemAccessDTO;
import org.apache.ibatis.annotations.Param;

public interface HtyFctXwB2bItemAccessDTOService {
	List<HtyFctXwB2bItemAccessDTO>	queryOneItemAccessQty(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    List<HtyFctXwB2bItemAccessDTO> queryByProAndCity(HtyFctXwB2bItemAccessDTO htyFctXwB2bItemAccessDTO,HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
}
