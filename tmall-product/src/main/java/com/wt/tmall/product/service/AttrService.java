package com.wt.tmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.common.utils.PageUtils;
import com.wt.tmall.product.entity.AttrEntity;
import com.wt.tmall.product.vo.AttrRespVo;
import com.wt.tmall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-08 19:18:11
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttrInfo(AttrVo attr);

    PageUtils baseList(Map<String, Object> params, Long catelogId, String attrType);

    AttrRespVo attrInfo(Long attrId);

    void updateAttrInfo(AttrVo attr);

    List<AttrEntity> getRelationAttr(Long attrGroupId);

    PageUtils attrNoRelation(Map<String, Object> params, Long attrGroupId);
}

