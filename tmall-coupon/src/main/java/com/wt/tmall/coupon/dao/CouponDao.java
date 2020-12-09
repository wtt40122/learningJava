package com.wt.tmall.coupon.dao;

import com.wt.tmall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-09 09:38:32
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
