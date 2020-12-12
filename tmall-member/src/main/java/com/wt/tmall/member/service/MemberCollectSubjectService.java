package com.wt.tmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.common.utils.PageUtils;
import com.wt.tmall.member.entity.MemberCollectSubjectEntity;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-09 09:45:00
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

