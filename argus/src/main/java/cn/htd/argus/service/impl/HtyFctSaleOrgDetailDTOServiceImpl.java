package cn.htd.argus.service.impl;

import cn.htd.argus.bean.BrandSortDTO;
import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.bean.SaleDetailDTO;
import cn.htd.argus.dao.HtyFctSaleOrgDetailDTOMapper;
import cn.htd.argus.dto.HtyFctSaleOrgDetailDTO;
import cn.htd.argus.service.HtyFctSaleOrgDetailDTOService;
import cn.htd.argus.util.ArithUtil;
import cn.htd.common.Pager;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtp on 2017/10/10.
 */
public class HtyFctSaleOrgDetailDTOServiceImpl implements HtyFctSaleOrgDetailDTOService{

    @Autowired
    private HtyFctSaleOrgDetailDTOMapper dao;

    @Override
    public HtyFctSaleOrgDetailDTO selectByOrgCode(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctSaleOrgDetailDTO dto = new HtyFctSaleOrgDetailDTO();
        dto.setOrgCode(userId);
        return dao.selectByOrgCode(dto);
    }

    @Override
    public Long queryPageCount(HtyFctSaleSearchDTO searchDTO) {
        return dao.queryPageCount(searchDTO);
    }

    @Override
    public Long queryPageSumCount(HtyFctSaleSearchDTO searchDTO) {
        return dao.queryPageSumCount(searchDTO);
    }

    @Override
    public List<SaleDetailDTO> queryPage(HtyFctSaleSearchDTO searchDTO, Pager pager) {
        List<HtyFctSaleOrgDetailDTO> list = new ArrayList<HtyFctSaleOrgDetailDTO>();
        List<SaleDetailDTO> dtos = new ArrayList<SaleDetailDTO>();
        Pager pager1 = new Pager();
        if("0".equals(searchDTO.getXsAmt())){
            list = dao.queryBurstSumPage(searchDTO, pager);
        }else if("1".equals(searchDTO.getXsAmt())){
            list = dao.queryStopSumPage(searchDTO, pager);
        }
        HtyFctSaleSearchDTO dto1 = new HtyFctSaleSearchDTO();
        dto1.setStartTime(searchDTO.getStartTime());
        dto1.setEndTime(searchDTO.getEndTime());
        dto1.setUserId(searchDTO.getUserId());
        //前十的爆款
        List<HtyFctSaleOrgDetailDTO> burstList = dao.queryBurstSumPage(dto1, pager1);
        //后十的滞销款
        List<HtyFctSaleOrgDetailDTO> stopList = dao.queryStopSumPage(dto1, pager1);
        if(list != null){

            for(HtyFctSaleOrgDetailDTO i:list){
                SaleDetailDTO dto = new SaleDetailDTO();
                dto.setProdName(i.getProdName());
                dto.setPpName(i.getPpName());
                dto.setPlName(i.getPlName());
                if(i.getXsQty().intValue() != 0){
                    dto.setXsPrice(ArithUtil.div(i.getXsAmt().doubleValue(), i.getXsQty().doubleValue(), 2));
                }else{
                    dto.setXsPrice(null);
                }
                dto.setMaxXsAmt(i.getMaxXsAmt());
                dto.setMinXsAmt(i.getMinXsAmt());
                dto.setXsQty(i.getXsQty());
                dto.setmJcQty(i.getmJcQty());
                dto.setXsAmt(i.getXsAmt());
                dto.setXsDd(i.getXsDd());

                //轮比
                searchDTO.setProdCode(i.getProdCode());
                HtyFctSaleOrgDetailDTO htyFctSaleOrgDetailDTO = dao.selectByProdCode(searchDTO);
                if(htyFctSaleOrgDetailDTO != null){
                    if(htyFctSaleOrgDetailDTO.getXsAmt().intValue() != 0){
                        BigDecimal salesRing = ArithUtil.sub(i.getXsAmt().doubleValue(),htyFctSaleOrgDetailDTO.getXsAmt().doubleValue());
                        dto.setSalesRing(ArithUtil.div(salesRing.doubleValue(),htyFctSaleOrgDetailDTO.getXsAmt().doubleValue(),4));
                    }else{
                        dto.setSalesRing(null);
                    }
                }
                //滞销
                for(HtyFctSaleOrgDetailDTO z:stopList){
                    if(z.getProdCode().equals(i.getProdCode())){
                        dto.setSort("滞销");
                    }
                }
                //爆款
                for(HtyFctSaleOrgDetailDTO x:burstList){
                    if(x.getProdCode().equals(i.getProdCode())){
                        dto.setSort("爆款");
                    }
                }
                dtos.add(dto);
            }

        }else{
            return null;
        }
        return dtos;
    }

    @Override
    public List<BrandSortDTO> queryBrand(String plCode) {
        List<BrandSortDTO> list = new ArrayList<BrandSortDTO>();
        List<HtyFctSaleOrgDetailDTO> list1 = dao.queryBrand(plCode);
        if(list1 != null){
            for(HtyFctSaleOrgDetailDTO i:list1){
                if(i.getPpName() != null){
                    BrandSortDTO dto = new BrandSortDTO();
                    dto.setBrandName(i.getPpName());
                    dto.setSortNum(i.getPpCode());
                    list.add(dto);
                }
            }
        }else{
            return null;
        }
        return list;
    }

    @Override
    public List<BrandSortDTO> queryCategory() {
        List<BrandSortDTO> list = new ArrayList<BrandSortDTO>();
        List<HtyFctSaleOrgDetailDTO> list1 = dao.queryCategory();
        if(list1 != null){
            for(HtyFctSaleOrgDetailDTO i:list1){
                BrandSortDTO dto = new BrandSortDTO();
                dto.setBrandName(i.getPlName());
                dto.setSortNum(i.getPlCode());
                list.add(dto);
            }
        }else{
            return null;
        }
        return list;
    }
}
