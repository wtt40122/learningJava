package com.wt.tmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.common.utils.PageUtils;
import com.wt.tmall.ware.entity.PurchaseEntity;
import com.wt.tmall.ware.vo.MergeVo;
import com.wt.tmall.ware.vo.PurchaseDoneVo;

import java.util.List;
import java.util.Map;

/**
 * 采购信息
 *
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-09 09:49:35
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void received(List<Long> ids);

    PageUtils queryPageUnreceivePurchase(Map<String, Object> params);

    void mergePurchase(MergeVo mergeVo);

    void done(PurchaseDoneVo doneVo);
}

