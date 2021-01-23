package com.wt.tmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.wt.common.constant.ProductConstant;
import com.wt.common.utils.PageUtils;
import com.wt.common.utils.Query;
import com.wt.tmall.product.dao.AttrAttrgroupRelationDao;
import com.wt.tmall.product.dao.AttrDao;
import com.wt.tmall.product.dao.AttrGroupDao;
import com.wt.tmall.product.dao.CategoryDao;
import com.wt.tmall.product.entity.AttrAttrgroupRelationEntity;
import com.wt.tmall.product.entity.AttrEntity;
import com.wt.tmall.product.entity.AttrGroupEntity;
import com.wt.tmall.product.entity.CategoryEntity;
import com.wt.tmall.product.service.AttrGroupService;
import com.wt.tmall.product.service.AttrService;
import com.wt.tmall.product.vo.AttrRespVo;
import com.wt.tmall.product.vo.AttrVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    AttrAttrgroupRelationDao attrAttrgroupRelationDao;
    @Autowired
    AttrGroupDao attrGroupDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    AttrGroupService attrGroupService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void saveAttrInfo(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr, attrEntity);
        this.save(attrEntity);
        // 基本属性
        if (Objects.equals(ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode(),
                attr.getAttrType()) && null != attr.getAttrGroupId()) {
            AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
            relationEntity.setAttrGroupId(attr.getAttrGroupId());
            relationEntity.setAttrId(attrEntity.getAttrId());
            attrAttrgroupRelationDao.insert(relationEntity);
        }
    }

    @Override
    public PageUtils baseList(Map<String, Object> params, Long catelogId, String attrType) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<AttrEntity>();
        queryWrapper.eq("attr_type",
                Objects.equals("base", attrType.toLowerCase()) ? ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode() : ProductConstant.AttrEnum.ATTR_TYPE_SALE.getCode());
        if (0 != catelogId) {
            queryWrapper.eq("catelog_id", catelogId);
        }
        String key = (String) params.get("key");
        if (StringUtils.isNotBlank(key)) {
            queryWrapper.and(wrapper -> {
                wrapper.eq("attr_id", key).or().like("attr_name", key);
            });
        }
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                queryWrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        List<AttrEntity> records = page.getRecords();
        List<AttrRespVo> respVos = records.stream().map(attrEntity -> {
            AttrRespVo attrRespVo = new AttrRespVo();
            BeanUtils.copyProperties(attrEntity, attrRespVo);
            Long attrId = attrEntity.getAttrId();
            AttrAttrgroupRelationEntity relationEntity = attrAttrgroupRelationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attrId));
            if (null != relationEntity && null != relationEntity.getAttrGroupId()) {
                AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(relationEntity.getAttrGroupId());
                attrRespVo.setGroupName(attrGroupEntity.getAttrGroupName());
            }
            if (null != attrEntity.getCatelogId()) {
                CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCatelogId());
                attrRespVo.setCatelogName(categoryEntity.getName());
            }
            return attrRespVo;
        }).collect(Collectors.toList());
        pageUtils.setList(respVos);
        return pageUtils;
    }

    @Override
    public AttrRespVo attrInfo(Long attrId) {
        AttrRespVo attrRespVo = new AttrRespVo();
        AttrEntity attrEntity = this.getById(attrId);
        if (null != attrEntity) {
            BeanUtils.copyProperties(attrEntity, attrRespVo);
            QueryWrapper<AttrAttrgroupRelationEntity> queryWrapper = new QueryWrapper<>();
            // 基本属性
            if (Objects.equals(ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode(),
                    attrEntity.getAttrType())) {
                AttrAttrgroupRelationEntity relationEntity = attrAttrgroupRelationDao.selectOne(queryWrapper.eq("attr_id", attrId));
                if (null != relationEntity && null != relationEntity.getAttrGroupId()) {
                    attrRespVo.setAttrGroupId(relationEntity.getAttrGroupId());
                    AttrGroupEntity attrGroup = attrGroupDao.selectById(relationEntity.getAttrGroupId());
                    if (null != attrGroup) {
                        attrRespVo.setGroupName(attrGroup.getAttrGroupName());
                    }
                }
            }
            CategoryEntity category = categoryDao.selectById(attrEntity.getCatelogId());
            if (null != category) {
                attrRespVo.setCatelogName(category.getName());
            }
            List<Long> catelogPath = attrGroupService.queryCategoryPath(attrEntity.getCatelogId());
            attrRespVo.setCatelogPath(catelogPath);
            String valueSelect = attrEntity.getValueSelect();
            if (StringUtils.isNotBlank(valueSelect)) {
                String[] valueSelectArray = valueSelect.split(";");
                if (valueSelectArray.length > 1) {
                    attrRespVo.setValueType(1);
                } else {
                    attrRespVo.setValueType(0);
                }
            }
        }
        return attrRespVo;
    }

    @Transactional
    @Override
    public void updateAttrInfo(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr, attrEntity);
        this.updateById(attrEntity);
        // 基本属性
        if (Objects.equals(ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode(),
                attr.getAttrType()) && null != attr.getAttrGroupId()) {
            QueryWrapper<AttrAttrgroupRelationEntity> queryWrapper = new QueryWrapper<>();
            Integer count = attrAttrgroupRelationDao.selectCount(queryWrapper.eq("attr_id", attr.getAttrId()));
            AttrAttrgroupRelationEntity entity = new AttrAttrgroupRelationEntity();
            entity.setAttrGroupId(attr.getAttrGroupId());
            entity.setAttrId(attr.getAttrId());
            if (null != count && count > 0) {
                attrAttrgroupRelationDao.update(entity, new UpdateWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attr.getAttrId()));
            } else {
                attrAttrgroupRelationDao.insert(entity);
            }
        }
    }

    @Override
    public List<AttrEntity> getRelationAttr(Long attrGroupId) {
        List<AttrAttrgroupRelationEntity> relationEntities = attrAttrgroupRelationDao.selectList(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_group_id", attrGroupId));
        List<Long> attrIds = relationEntities.stream().map(relation -> relation.getAttrId()).collect(Collectors.toList());
        List<AttrEntity> attrEntities = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(attrIds)) {
            attrEntities = this.listByIds(attrIds);
        }
        return attrEntities;
    }

    @Override
    public PageUtils attrNoRelation(Map<String, Object> params, Long attrGroupId) {
        //1、当前分组只能关联自己所属的分类里面的所有属性
        AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrGroupId);
        Long catelogId = attrGroupEntity.getCatelogId();
        //2、当前分组只能关联别的分组没有引用的属性
        //2.1)、当前分类下的其他分组
        List<AttrGroupEntity> group = attrGroupDao.selectList(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));
        List<Long> collect = group.stream().map(item -> item.getAttrGroupId()).collect(Collectors.toList());

        //2.2)、这些分组关联的属性
        List<AttrAttrgroupRelationEntity> groupId = attrAttrgroupRelationDao.selectList(new QueryWrapper<AttrAttrgroupRelationEntity>().in("attr_group_id", collect));
        List<Long> attrIds = groupId.stream().map(item -> {
            return item.getAttrId();
        }).collect(Collectors.toList());

        //2.3)、从当前分类的所有属性中移除这些属性；
        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<AttrEntity>()
                .eq("catelog_id", catelogId)
                .eq("attr_type", ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode());
        if (attrIds != null && attrIds.size() > 0) {
            wrapper.notIn("attr_id", attrIds);
        }
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            wrapper.and((w) -> {
                w.eq("attr_id", key).or().like("attr_name", key);
            });
        }
        IPage<AttrEntity> page = this.page(new Query<AttrEntity>().getPage(params), wrapper);

        PageUtils pageUtils = new PageUtils(page);

        return pageUtils;
    }

}