package cn.htd.argus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dao.HtyFctXwB2bSearchKeyDTOMapper;
import cn.htd.argus.dto.HtyFctXwB2bSearchKeyDTO;
import cn.htd.argus.service.HtyFctXwB2bSearchKeyDTOService;

public class HtyFctXwB2bSearchKeyDTOServiceImpl implements HtyFctXwB2bSearchKeyDTOService {
	@Autowired
	private HtyFctXwB2bSearchKeyDTOMapper htyFctXwB2bSearchKeyDTODao;

	@Override
	public List<HtyFctXwB2bSearchKeyDTO> queryAllSearchKeyWord(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {

        return htyFctXwB2bSearchKeyDTODao.queryAllSearchKeyWord(htyFctUserBeHaviorSearchDTO);
	}
}
