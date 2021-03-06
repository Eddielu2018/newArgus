package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.bean.SaleCompareDTO;
import cn.htd.argus.dao.HtyFctSaleOrgAllDTOMapper;
import cn.htd.argus.dto.HtyFctSaleOrgAllDTO;
import cn.htd.argus.service.HtyFctSaleOrgAllDTOService;
import cn.htd.argus.util.ArithUtil;
import cn.htd.argus.util.DateUtil;
import com.alibaba.dubbo.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
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
    public SaleCompareDTO selectCompareByOrgCode(String userId, String startTime, String endTime) {
        SaleCompareDTO dto = new SaleCompareDTO();
        HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        if(StringUtils.isNotEmpty(userId)){
            searchDTO.setUserId(userId);
        }
        if(StringUtils.isNotEmpty(startTime)){
            searchDTO.setStartTime(startTime);
        }
        if(StringUtils.isNotEmpty(endTime)){
            searchDTO.setEndTime(endTime);
        }
        //当前时间段
        HtyFctSaleOrgAllDTO htyFctSaleOrgAllDTO1 = dao.selectByOrgSearchDTO(searchDTO);
        if(htyFctSaleOrgAllDTO1 != null){
            dto.setXsRanking(htyFctSaleOrgAllDTO1.getRanking());
            if(htyFctSaleOrgAllDTO1.getXsLr() != null){
                dto.setXsLr(ArithUtil.div(htyFctSaleOrgAllDTO1.getXsLr().doubleValue(),10000,2));
            }
            if(htyFctSaleOrgAllDTO1.getXsMl() != null){
                dto.setXsMl(ArithUtil.mul(htyFctSaleOrgAllDTO1.getXsMl().doubleValue(),100));
            }
            if(htyFctSaleOrgAllDTO1.getXsAmt() != null){
                dto.setXsAmt(ArithUtil.div(htyFctSaleOrgAllDTO1.getXsAmt().doubleValue(),10000,2));
            }
            if(htyFctSaleOrgAllDTO1.getXsQty() != null){
                dto.setXsQty(htyFctSaleOrgAllDTO1.getXsQty());
            }
        }

        if(StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(endTime)){
            startTime = DateUtil.dateFormat(startTime,12);
            endTime = DateUtil.dateFormat(endTime,12);
            searchDTO.setEndTime(endTime);
            searchDTO.setStartTime(startTime);

            //上期时间段
            HtyFctSaleOrgAllDTO htyFctSaleOrgAllDTO2 = dao.selectByOrgSearchDTO(searchDTO);
            if(htyFctSaleOrgAllDTO2 != null){
                dto.setUpperXsMl(htyFctSaleOrgAllDTO2.getXsMl());
                dto.setUpperXsRanking(htyFctSaleOrgAllDTO2.getRanking());
                dto.setUpperXsQty(htyFctSaleOrgAllDTO2.getXsQty());
                dto.setUpperXsAmt(ArithUtil.div(htyFctSaleOrgAllDTO2.getXsAmt().doubleValue(),10000,2));
                if(htyFctSaleOrgAllDTO2.getXsLr() != null){
                    dto.setUpperXsLr(ArithUtil.div(htyFctSaleOrgAllDTO2.getXsLr().doubleValue(), 10000, 2));
                }

            }

            //销售金额同比，排序
            if(dto.getUpperXsAmt() != null && dto.getXsAmt() != null){
                BigDecimal xsAmt =ArithUtil.sub(dto.getXsAmt().doubleValue(),dto.getUpperXsAmt().doubleValue());
                if(dto.getUpperXsAmt().intValue() != 0){
                    xsAmt = ArithUtil.div(xsAmt.doubleValue(),dto.getUpperXsAmt().abs().doubleValue(),4);
                    dto.setXsAmtAn(ArithUtil.mul(xsAmt.doubleValue(),100));
                }else{
                    dto.setXsAmtAn(null);
                }
                dto.setXsAmtSort(dto.getXsAmt().compareTo(dto.getUpperXsAmt())>0 ? "1":"0");
            }

            //销售净利润同比，排序
            if(dto.getXsLr() != null && dto.getUpperXsLr() != null){
                BigDecimal xsLr = ArithUtil.sub(dto.getXsLr().doubleValue(),dto.getUpperXsLr().doubleValue());
                if(dto.getUpperXsLr().intValue() != 0){
                    xsLr = ArithUtil.div(xsLr.doubleValue(),dto.getUpperXsLr().abs().doubleValue(),4);
                    dto.setXsLrAn(ArithUtil.mul(xsLr.doubleValue(),100));
                }else{
                    dto.setXsLrAn(null);
                }
                dto.setXsLrSort(dto.getXsLr().compareTo(dto.getUpperXsLr())>0 ? "1":"0");
            }

            //销售数量同比，排序
            if(dto.getXsQty() != null && dto.getUpperXsQty() != null){
                BigDecimal xsQty = ArithUtil.sub(dto.getXsQty().doubleValue(), dto.getUpperXsQty());

                if(dto.getUpperXsQty().intValue() != 0){
                    xsQty = ArithUtil.div(xsQty.doubleValue(),dto.getUpperXsQty() , 4);
                    dto.setXsQtyAn(ArithUtil.mul(xsQty.doubleValue(),100));
                }
                dto.setXsQtySort(dto.getXsQty().intValue() > dto.getUpperXsQty().intValue() ? "1":"0");
            }

            //毛利率同比，排序
            if(dto.getXsMl() != null && dto.getUpperXsMl() != null){
                BigDecimal xsMl = ArithUtil.sub(dto.getXsMl().doubleValue(),dto.getUpperXsMl().doubleValue());
                if(dto.getUpperXsMl().intValue() != 0){
                    xsMl = ArithUtil.div(xsMl.doubleValue(),dto.getUpperXsMl().abs().doubleValue(),4);
                    dto.setXsMlAn(ArithUtil.mul(xsMl.doubleValue(),100));
                }else{
                    dto.setXsMlAn(xsMl);
                }
                dto.setXsMlSort(dto.getXsMl().compareTo(dto.getUpperXsMl()) >0 ? "1":"0");
            }

            //排名排序
            if(dto.getXsRanking() != null && dto.getUpperXsRanking() != null){
                dto.setXsRankingSort(dto.getXsRanking()>(dto.getUpperXsRanking()) ? "1":"0");
            }
        }

        return dto;
    }
}
