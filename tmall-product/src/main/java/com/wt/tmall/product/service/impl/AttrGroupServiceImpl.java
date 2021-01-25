package com.wt.tmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.wt.common.utils.PageUtils;
import com.wt.common.utils.Query;
import com.wt.tmall.product.dao.AttrAttrgroupRelationDao;
import com.wt.tmall.product.dao.AttrGroupDao;
import com.wt.tmall.product.entity.AttrAttrgroupRelationEntity;
import com.wt.tmall.product.entity.AttrEntity;
import com.wt.tmall.product.entity.AttrGroupEntity;
import com.wt.tmall.product.entity.CategoryEntity;
import com.wt.tmall.product.service.AttrGroupService;
import com.wt.tmall.product.service.AttrService;
import com.wt.tmall.product.service.CategoryService;
import com.wt.tmall.product.vo.AttrGroupRelationVo;
import com.wt.tmall.product.vo.AttrGroupWithAttrsVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity>
        implements AttrGroupService {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    AttrAttrgroupRelationDao attrAttrgroupRelationDao;
    @Autowired
    AttrService attrService;

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
        queryCategoryIds(categoryPaths, catelogId);
        Collections.reverse(categoryPaths);
        return categoryPaths;
    }

    @Override
    public void deleteRelation(List<AttrGroupRelationVo> relationVos) {
        List<AttrAttrgroupRelationEntity> entities = relationVos.stream().map(relationVo -> {
            AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
            BeanUtils.copyProperties(relationVo, relationEntity);
            return relationEntity;
        }).collect(Collectors.toList());
        attrAttrgroupRelationDao.batchDeleteRelation(entities);
    }

    @Override
    public List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId) {
        //1、查询分组信息
        List<AttrGroupEntity> attrGroupEntities = this.list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));

        //2、查询所有属性
        List<AttrGroupWithAttrsVo> collect = attrGroupEntities.stream().map(group -> {
            AttrGroupWithAttrsVo attrsVo = new AttrGroupWithAttrsVo();
            BeanUtils.copyProperties(group,attrsVo);
            List<AttrEntity> attrs = attrService.getRelationAttr(attrsVo.getAttrGroupId());
            attrsVo.setAttrs(attrs);
            return attrsVo;
        }).collect(Collectors.toList());

        return collect;
    }

    private void queryCategoryIds(List<Long> categoryPaths, Long catelogId) {
        categoryPaths.add(catelogId);
        CategoryEntity categoryEntity = categoryService.getById(catelogId);
        if (categoryEntity.getParentCid() != 0) {
            queryCategoryIds(categoryPaths, categoryEntity.getParentCid());
        }
    }

}