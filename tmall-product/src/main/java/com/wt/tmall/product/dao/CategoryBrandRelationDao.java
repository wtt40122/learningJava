package com.wt.tmall.product.dao;

import com.wt.tmall.product.entity.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 品牌分类关联
 * 
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-08 19:18:10
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity> {

    void updateCategoryName(@Param("categoryId") Long categoryId, @Param("name") String name);
}
