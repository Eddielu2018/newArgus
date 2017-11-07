package cn.htd.argus.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dao.HtyFctXwB2bLndPageDTOMapper;
import cn.htd.argus.dto.HtyFctXwB2bLndPageDTO;
import cn.htd.argus.service.HtyFctXwB2bLndPageDTOService;

public class HtyFctXwB2bLndPageDTOServiceImpl implements HtyFctXwB2bLndPageDTOService{
	@Autowired
	private HtyFctXwB2bLndPageDTOMapper htyFctXwB2bLndPageDTOMDao;

	@Override
	public List<HtyFctXwB2bLndPageDTO> queryAllAccessQty(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
		return htyFctXwB2bLndPageDTOMDao.queryAllAccessQty(htyFctUserBeHaviorSearchDTO);
	}

    @Override
    public List<HtyFctXwB2bLndPageDTO> queryByProNameAndCityName( HtyFctXwB2bLndPageDTO htyFctXwB2bLndPageDTO, HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
        return htyFctXwB2bLndPageDTOMDao.queryByProNameAndCityName(htyFctXwB2bLndPageDTO,htyFctUserBeHaviorSearchDTO);
    }

    @Override
    public HtyFctXwB2bLndPageDTO queryCityName(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
        return htyFctXwB2bLndPageDTOMDao.queryCityName(htyFctUserBeHaviorSearchDTO);
    }

    @Override
    public HtyFctXwB2bLndPageDTO queryProName(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
        return htyFctXwB2bLndPageDTOMDao.queryProName(htyFctUserBeHaviorSearchDTO);
    }
}
