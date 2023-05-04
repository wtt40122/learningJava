package com.wt.tmall.product.vo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: wtt
 * @Date: 2021/1/23 12:00
 * @Description:
 */
@Data
public class AttrRespVo extends AttrVo {
    // 所属分类名称
    private String catelogName;
    // 所属分组名称
    private String groupName;

    private List<Long> catelogPath;

    private Integer valueType = 1;
}
