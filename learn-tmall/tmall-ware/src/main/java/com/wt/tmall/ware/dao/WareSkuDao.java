package com.wt.tmall.ware.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wt.tmall.ware.entity.WareSkuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商品库存
 * 
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-09 09:49:34
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {

    void addStock(@Param("skuId") Long skuId,
                  @Param("wareId") Long wareId,
                  @Param("skuNum") Integer skuNum);
}
