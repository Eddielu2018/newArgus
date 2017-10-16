package cn.htd.argus.service.impl;

import cn.htd.argus.bean.SaleCompareDTO;
import cn.htd.argus.dao.HtyFctSaleOrgAllDTOMapper;
import cn.htd.argus.dto.HtyFctSaleOrgAllDTO;
import cn.htd.argus.service.HtyFctSaleOrgAllDTOService;
import cn.htd.argus.util.ArithUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtp on 2017/10/10.
 */
public class HtyFctSaleOrgAllDTOServiceImpl implements HtyFctSaleOrgAllDTOService{

    @Autowired
    private HtyFctSaleOrgAllDTOMapper dao;

    @Override
    public HtyFctSaleOrgAllDTO selectByOrgCode(String userId) {
        HtyFctSaleOrgAllDTO dto = new HtyFctSaleOrgAllDTO();
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctSaleOrgAllDTO mole = new HtyFctSaleOrgAllDTO();
        mole.setOrgCode(userId);
        List<HtyFctSaleOrgAllDTO> list = dao.selectByOrgCode(mole);
        if(list != null){
            for(HtyFctSaleOrgAllDTO i:list){
                if(dto.equals(i)){
                    dto.setXsAmt(ArithUtil.add(dto.getXsAmt().doubleValue(),i.getXsAmt().doubleValue()));
                    dto.setXsQty(dto.getXsQty()+i.getXsQty());
                    dto.setXsMl(ArithUtil.add(dto.getXsMl().doubleValue(), i.getXsMl().doubleValue()));
                    dto.setXsLr(ArithUtil.add(dto.getXsLr().doubleValue(),i.getXsLr().doubleValue()));
                }else{
                    dto = i;
                }
            }
        }else{
            return null;
        }
        return dto;
    }

    @Override
    public SaleCompareDTO selectCompareByOrgCode(String userId) {
        SaleCompareDTO dto1 = new SaleCompareDTO();
        HtyFctSaleOrgAllDTO dto = new HtyFctSaleOrgAllDTO();
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctSaleOrgAllDTO mole = new HtyFctSaleOrgAllDTO();
        mole.setOrgCode(userId);
        List<HtyFctSaleOrgAllDTO> list = dao.selectByOrgCode(mole);
        if(list != null){
            for(HtyFctSaleOrgAllDTO i:list){
                if(dto.equals(i)){
                    dto.setXsAmt(ArithUtil.add(dto.getXsAmt().doubleValue(),i.getXsAmt().doubleValue()));
                    dto.setXsQty(dto.getXsQty()+i.getXsQty());
                    dto.setXsMl(ArithUtil.add(dto.getXsMl().doubleValue(), i.getXsMl().doubleValue()));
                    dto.setXsLr(ArithUtil.add(dto.getXsLr().doubleValue(),i.getXsLr().doubleValue()));
                }else{
                    dto = i;
                }
            }
        }else{
            return null;
        }
        dto1.setXsAmt(dto.getXsAmt());
        dto1.setXsQty(dto.getXsQty());
        dto1.setXsLr(dto.getXsLr());
        dto1.setXsMl(dto.getXsMl());
        dto1.setXsRanking("1");

        dto1.setUpperXsAmt(dto.getXsAmt());
        dto1.setUpperXsQty(dto.getXsQty());
        dto1.setUpperXsLr(dto.getXsLr());
        dto1.setUpperXsMl(dto.getXsMl());
        dto1.setUpperXsRanking("1");

        dto1.setXsAmtAn(dto.getXsAmt());
        dto1.setXsQtyAn(dto.getXsAmt());
        dto1.setXsLrAn(dto.getXsAmt());
        dto1.setXsMlAn(dto.getXsAmt());
        dto1.setXsRankingAn(dto.getXsAmt());

        dto1.setXsAmtSort("1");
        dto1.setXsQtySort("0");
        dto1.setXsLrSort("0");
        dto1.setXsMlSort("1");
        dto1.setXsRankingSort("1");
        return dto1;
    }
}
