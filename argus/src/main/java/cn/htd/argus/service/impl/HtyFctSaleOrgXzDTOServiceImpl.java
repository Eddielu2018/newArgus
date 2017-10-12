package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.bean.SaleXzDTO;
import cn.htd.argus.dao.HtyFctSaleOrgXzDTOMapper;
import cn.htd.argus.dto.HtyFctSaleOrgXzDTO;
import cn.htd.argus.service.HtyFctSaleOrgXzDTOService;
import cn.htd.argus.util.ArithUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtp on 2017/10/10.
 */
public class HtyFctSaleOrgXzDTOServiceImpl implements HtyFctSaleOrgXzDTOService{

    @Autowired
    private HtyFctSaleOrgXzDTOMapper dao;

    @Override
    public HtyFctSaleOrgXzDTO selectByOrgCode(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctSaleOrgXzDTO dto = new HtyFctSaleOrgXzDTO();
        dto.setOrgCode(userId);
        return dao.selectByOrgCode(dto);
    }

    @Override
    public List<SaleXzDTO> selectBySearchDTO(HtyFctSaleSearchDTO searchDTO) {
        List<HtyFctSaleOrgXzDTO> list = dao.selectBySearchDTO(searchDTO);
        List<SaleXzDTO> dtos = new ArrayList<SaleXzDTO>();
        if(list != null){
            for(HtyFctSaleOrgXzDTO i:list){
                SaleXzDTO dto = new SaleXzDTO();
                dto.setDateKey(i.getDateKey());
                //1销售额
                dto.setXsAmt(i.getXsAmt());
                dto.setXsAmtXz(ArithUtil.div(i.getXsAmt().doubleValue(), i.getOrgNum().doubleValue(), 2));
                //2订单数
                dto.setCnt(i.getCnt());
                dto.setCntXz(ArithUtil.div(i.getCntXz().doubleValue(), i.getOrgNum().doubleValue(), 2));
                //3毛利率
                BigDecimal rate = ArithUtil.div(i.getXsZhMl().doubleValue(), i.getXsZySr().doubleValue(), 2);
                dto.setRate(ArithUtil.div(rate.doubleValue(), i.getOrgNum().doubleValue(), 2));
                BigDecimal rateXz = ArithUtil.div(i.getXsZhMlXz().doubleValue(), i.getXsZySrXz().doubleValue(), 2);
                dto.setRateXz(ArithUtil.div(rateXz.doubleValue(), i.getOrgNum().doubleValue(), 2));
                dtos.add(dto);
            }
        }else{
            return null;
        }
        return dtos;
    }
}
