package cn.htd.argus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dao.HtyFctXwB2bItemAccessDTOMapper;
import cn.htd.argus.dto.HtyFctXwB2bItemAccessDTO;
import cn.htd.argus.service.HtyFctXwB2bItemAccessDTOService;

public class HtyFctXwB2bItemAccessDTOServiceImpl implements HtyFctXwB2bItemAccessDTOService {
	@Autowired
	private HtyFctXwB2bItemAccessDTOMapper htyFctXwB2bItemAccessDTODao;

	@Override
	public List<HtyFctXwB2bItemAccessDTO> queryOneItemAccessQty(
			HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
		return htyFctXwB2bItemAccessDTODao.queryOneItemAccessQty(htyFctUserBeHaviorSearchDTO);
	}

    @Override
    public List<HtyFctXwB2bItemAccessDTO> queryByProAndCity(HtyFctXwB2bItemAccessDTO htyFctXwB2bItemAccessDTO, HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
        return htyFctXwB2bItemAccessDTODao.queryByProAndCity(htyFctXwB2bItemAccessDTO,htyFctUserBeHaviorSearchDTO);
    }

    @Override
    public HtyFctXwB2bItemAccessDTO queryCityName(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
        return htyFctXwB2bItemAccessDTODao.queryCityName(htyFctUserBeHaviorSearchDTO);
    }

    @Override
    public HtyFctXwB2bItemAccessDTO queryProName(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
        return htyFctXwB2bItemAccessDTODao.queryProName(htyFctUserBeHaviorSearchDTO);
    }
}
