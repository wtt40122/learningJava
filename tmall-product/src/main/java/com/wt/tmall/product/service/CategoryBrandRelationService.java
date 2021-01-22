package com.wt.tmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.common.utils.PageUtils;
import com.wt.tmall.product.entity.CategoryBrandRelationEntity;

import java.util.List;
import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-08 19:18:10
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveDetail(CategoryBrandRelationEntity categoryBrandRelation);

    List<CategoryBrandRelationEntity> catelogList(Long brandId);

    void updateBrandName(Long brandId, String name);

    void updateCategoryName(Long categoryId, String name);
}

