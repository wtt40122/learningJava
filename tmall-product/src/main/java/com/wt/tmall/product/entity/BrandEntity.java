package com.wt.tmall.product.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.wt.common.valid.AddGroup;
import com.wt.common.valid.ListValue;
import com.wt.common.valid.UpdateGroup;
import com.wt.common.valid.UpdateStatusGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 品牌
 * 
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-08 19:18:11
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@NotNull(message = "修改时候品牌Id不能为空",groups = {UpdateGroup.class, UpdateStatusGroup.class})
	@Null(message = "添加时候品牌Id只能为空",groups = {AddGroup.class})
	@TableId(value="brand_id",type = IdType.AUTO)
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空",groups = {AddGroup.class,UpdateGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(message = "品牌logo地址不能为空",groups = {AddGroup.class})
	@URL(message = "品牌logo地址必须为一个URL地址",groups = {AddGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotNull(message = "显示状态不能为空",groups = {AddGroup.class})
	@ListValue(values={0,1},message="显示状态输入错误",groups = {AddGroup.class,UpdateStatusGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotBlank(message = "检索首字母不能为空")
	@Pattern(regexp = "^[a-zA-z]$",message = "检索首字母必须为一个a-z或者A-Z之间的字符")
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(message = "排序字段不能为空",groups = {AddGroup.class})
	@Min(value = 0,message = "排序字段是一个不小于0的整数",groups = {AddGroup.class})
	private Integer sort;

}
