package com.wt.tmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.wt.common.utils.PageUtils;
import com.wt.common.utils.Query;
import com.wt.tmall.product.dao.AttrGroupDao;
import com.wt.tmall.product.entity.AttrGroupEntity;
import com.wt.tmall.product.entity.CategoryEntity;
import com.wt.tmall.product.service.AttrGroupService;
import com.wt.tmall.product.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity>
        implements AttrGroupService {

    @Autowired
    private CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils listCategory(Map<String, Object> params) {
        Long catId = (Long) params.get("catId");
        String key = (String) params.get("key");
        QueryWrapper<AttrGroupEntity> queryWrapper = new QueryWrapper<AttrGroupEntity>();
        if(catId != 0){
            queryWrapper.eq("catelog_id", catId);
        }
        if(StringUtils.isNotBlank(key)){
            queryWrapper.and(wrapper -> {
                wrapper.eq("attr_group_id",key)
                        .or().eq("catelog_id",key)
                        .or().like("attr_group_name",key);
            });
        }
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                queryWrapper
        );
        return new PageUtils(page);
    }

    @Override
    public List<Long> queryCategoryPath(Long catelogId) {
        List<Long> categoryPaths = Lists.newArrayList();
        queryCategoryIds(categoryPaths,catelogId);
        return categoryPaths;
    }

    private void queryCategoryIds(List<Long> categoryPaths,Long catelogId){
        categoryPaths.add(catelogId);
        CategoryEntity categoryEntity = categoryService.getById(catelogId);
        if(categoryEntity.getParentCid() != 0){
            queryCategoryIds(categoryPaths,categoryEntity.getParentCid());
        }
    }

}