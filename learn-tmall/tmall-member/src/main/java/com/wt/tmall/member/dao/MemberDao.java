package com.wt.tmall.member.dao;

import com.wt.tmall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-09 09:45:00
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
