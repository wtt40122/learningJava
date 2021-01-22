package com.wt.tmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.common.utils.PageUtils;
import com.wt.common.utils.Query;
import com.wt.tmall.product.dao.CategoryBrandRelationDao;
import com.wt.tmall.product.entity.BrandEntity;
import com.wt.tmall.product.entity.CategoryBrandRelationEntity;
import com.wt.tmall.product.entity.CategoryEntity;
import com.wt.tmall.product.service.BrandService;
import com.wt.tmall.product.service.CategoryBrandRelationService;
import com.wt.tmall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BrandService brandService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<CategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void saveDetail(CategoryBrandRelationEntity categoryBrandRelation) {
        Long brandId = categoryBrandRelation.getBrandId();
        Long catelogId = categoryBrandRelation.getCatelogId();
        if(null != brandId){
            BrandEntity brandEntity = brandService.getById(brandId);
            categoryBrandRelation.setBrandName(brandEntity.getName());
        }
        if(null != catelogId){
            CategoryEntity categoryEntity = categoryService.getById(catelogId);
            categoryBrandRelation.setCatelogName(categoryEntity.getName());
        }
        this.save(categoryBrandRelation);
    }

    @Override
    public List<CategoryBrandRelationEntity> catelogList(Long brandId) {
        return this.list(
                new QueryWrapper<CategoryBrandRelationEntity>()
                        .eq("brand_id",brandId));
    }

    @Override
    public void updateBrandName(Long brandId, String name) {
        CategoryBrandRelationEntity relationEntity = new CategoryBrandRelationEntity();
        relationEntity.setBrandName(name);
        this.update(relationEntity, new UpdateWrapper<CategoryBrandRelationEntity>().eq("brand_id",brandId));
    }

    @Override
    public void updateCategoryName(Long categoryId, String name) {
        this.baseMapper.updateCategoryName(categoryId,name);
    }


}