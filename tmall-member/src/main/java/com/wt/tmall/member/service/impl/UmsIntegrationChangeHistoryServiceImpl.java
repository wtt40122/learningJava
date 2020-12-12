package com.wt.tmall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.common.utils.PageUtils;
import com.wt.common.utils.Query;

import com.wt.tmall.member.dao.IntegrationChangeHistoryDao;
import com.wt.tmall.member.entity.IntegrationChangeHistoryEntity;
import com.wt.tmall.member.service.IntegrationChangeHistoryService;


@Service("umsIntegrationChangeHistoryService")
public class UmsIntegrationChangeHistoryServiceImpl extends ServiceImpl<IntegrationChangeHistoryDao, IntegrationChangeHistoryEntity> implements IntegrationChangeHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IntegrationChangeHistoryEntity> page = this.page(
                new Query<IntegrationChangeHistoryEntity>().getPage(params),
                new QueryWrapper<IntegrationChangeHistoryEntity>()
        );

        return new PageUtils(page);
    }

}