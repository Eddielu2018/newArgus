package cn.htd.argus.service;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.bean.SaleXzsDTO;
import cn.htd.argus.dto.HtyFctSaleOrgXzDTO;

import java.util.List;

/**
 * Created by wangtp on 2017/10/10.
 */
public interface HtyFctSaleOrgXzDTOService {
    HtyFctSaleOrgXzDTO selectByOrgCode(String userId);

    List<SaleXzsDTO> selectBySearchDTO(HtyFctSaleSearchDTO searchDTO);
}
