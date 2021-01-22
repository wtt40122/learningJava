package com.wt.tmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.common.utils.PageUtils;
import com.wt.tmall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-08 19:18:11
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> queryAllCategoryWithTree();

    void removeCategory(List<Long> categoryIds);

    void saveDetail(CategoryEntity category);

    void updateDetail(CategoryEntity category);
}

