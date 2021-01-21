package com.wt.tmall.product.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wt.tmall.product.entity.AttrGroupEntity;
import com.wt.tmall.product.service.AttrGroupService;
import com.wt.common.utils.PageUtils;
import com.wt.common.utils.R;



/**
 * 属性分组
 *
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-08 19:18:11
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrGroupService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/list/{catId}")
    public R listCategory(@RequestParam Map<String, Object> params,
                          @PathVariable Long catId){
//        PageUtils page = attrGroupService.queryPage(params);
        params.put("catId",catId);
        PageUtils page = attrGroupService.listCategory(params);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        List<Long> categoryPaths = attrGroupService.queryCategoryPath(attrGroup.getCatelogId());
        if(!CollectionUtils.isEmpty(categoryPaths)){
            Collections.reverse(categoryPaths);
            attrGroup.setCategoryPaths(categoryPaths);
        }
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
