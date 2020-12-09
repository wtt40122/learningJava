package com.wt.tmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.common.utils.PageUtils;
import com.wt.tmall.order.entity.OmsOrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-08 18:28:35
 */
public interface OmsOrderService extends IService<OmsOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

