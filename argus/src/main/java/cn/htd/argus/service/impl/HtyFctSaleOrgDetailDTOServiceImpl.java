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
    public List<SaleDetailDTO> queryPage(HtyFctSaleSearchDTO searchDTO, Pager pager) {
        List<HtyFctSaleOrgDetailDTO> list = new ArrayList<HtyFctSaleOrgDetailDTO>();
        List<HtyFctSaleOrgDetailDTO> list1 = new ArrayList<HtyFctSaleOrgDetailDTO>();
        List<SaleDetailDTO> dtos = new ArrayList<SaleDetailDTO>();
        if("0".equals(searchDTO.getXsAmt())){
            list = dao.queryBurstPage(searchDTO, pager);
        }else if("1".equals(searchDTO.getXsAmt())){
            list = dao.queryStopPage(searchDTO, pager);
        }
        List<String> strings = new ArrayList<String>();
        if(list != null){
            list1.add(list.get(0));
            for(HtyFctSaleOrgDetailDTO i:list){

                for(HtyFctSaleOrgDetailDTO j:list1){
                    if(i.equals(j)){
                        j.setXsAmt(ArithUtil.add(i.getXsAmt().doubleValue(),j.getXsAmt().doubleValue()));
                        j.setXsQty(ArithUtil.add(j.getXsQty().doubleValue(), i.getXsQty().doubleValue()));
                        j.setMinXsAmt(i.getMinXsAmt().compareTo(j.getMinXsAmt())>0 ? i.getMinXsAmt() : j.getMinXsAmt());
                        j.setMaxXsAmt(i.getMaxXsAmt().compareTo(j.getMaxXsAmt())>0 ? j.getMaxXsAmt(): i.getMaxXsAmt());
                    }else{
                        list1.add(i);
                    }
                }
            }

            for(HtyFctSaleOrgDetailDTO i:list){
                SaleDetailDTO dto = new SaleDetailDTO();
                dto.setProdName(i.getProdName());
                dto.setPpName(i.getPpName());
                dto.setPlName(i.getPlName());
                dto.setSort("");
                dto.setXsPrice(ArithUtil.div(i.getXsAmt().doubleValue(), i.getXsQty().doubleValue(), 2));
                dto.setMaxXsAmt(i.getMaxXsAmt());
                dto.setMinXsAmt(i.getMinXsAmt());
                dto.setXsQty(i.getXsQty());
                dto.setmJcQty(i.getmJcQty());
                dto.setXsAmt(i.getXsAmt());
                dto.setXsDd(i.getXsDd());
                dtos.add(dto);
            }

        }else{
            return null;
        }
        return dtos;
    }

    @Override
    public List<BrandSortDTO> queryBrand() {
        List<BrandSortDTO> list = new ArrayList<BrandSortDTO>();
        List<HtyFctSaleOrgDetailDTO> list1 = dao.queryBrand();
        if(list1 != null){
            for(HtyFctSaleOrgDetailDTO i:list1){
                BrandSortDTO dto = new BrandSortDTO();
                dto.setBrandName(i.getPpName());
                dto.setSortNum(i.getPpCode());
                list.add(dto);
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
