package com.wt.tmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.common.utils.PageUtils;
import com.wt.tmall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-09 09:45:00
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

