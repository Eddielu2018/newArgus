package cn.htd.argus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dao.HtyFctSaleCityProdDTOMapper;
import cn.htd.argus.dto.HtyFctSaleCityProdDTO;
import cn.htd.argus.service.HtyFctSaleCityProdDTOService;


public class HtyFctSaleCityProdDTOServiceImpl implements HtyFctSaleCityProdDTOService {
@Autowired
private HtyFctSaleCityProdDTOMapper htyFctSaleCityProdDTODao;

@Override
public List<HtyFctSaleCityProdDTO> querySaleOutItemNum(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
	return htyFctSaleCityProdDTODao.querySaleOutItemNum(htyFctUserBeHaviorSearchDTO);
}

    @Override
    public List<HtyFctSaleCityProdDTO> queryProAndCity(HtyFctSaleCityProdDTO HtyFctSaleCityProdDTO, HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
        return htyFctSaleCityProdDTODao.queryProAndCity(HtyFctSaleCityProdDTO,htyFctUserBeHaviorSearchDTO);
    }

    @Override
    public HtyFctSaleCityProdDTO queryProName(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
        return htyFctSaleCityProdDTODao.queryProName(htyFctUserBeHaviorSearchDTO);
    }

    @Override
    public HtyFctSaleCityProdDTO queryCityName(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
        return htyFctSaleCityProdDTODao.queryCityName(htyFctUserBeHaviorSearchDTO);
    }
}
