package com.wt.tmall.product.service.impl;

import com.wt.tmall.product.service.CategoryBrandRelationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.common.utils.PageUtils;
import com.wt.common.utils.Query;

import com.wt.tmall.product.dao.BrandDao;
import com.wt.tmall.product.entity.BrandEntity;
import com.wt.tmall.product.service.BrandService;
import org.springframework.transaction.annotation.Transactional;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<BrandEntity> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(key)){
            queryWrapper.eq("brand_id",key)
                    .or().like("name",key)
                    .or().eq("descript",key);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void saveDetail(BrandEntity brand) {
        this.save(brand);
    }

    @Override
    public void updateDetail(BrandEntity brand) {
        this.updateById(brand);
        String name = brand.getName();
        if(StringUtils.isNotBlank(name)){
            categoryBrandRelationService.updateBrandName(brand.getBrandId(),brand.getName());
        }
    }

}