package com.wt.tmall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wt.tmall.product.entity.CategoryEntity;
import com.wt.tmall.product.service.CategoryService;
import com.wt.common.utils.PageUtils;
import com.wt.common.utils.R;



/**
 * 商品三级分类
 *
 * @author wtt
 * @email 1136220284@qq.com
 * @date 2020-12-08 19:18:11
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     *
     * @Description //查询分类树形列表展示
     * @Author wtt
     * @Date 2020/12/18 11:31
     * @param: []
     * @return com.wt.common.utils.R
     */
    @RequestMapping("/list/tree")
    public R queryAllCategoryWithTree(){
        List<CategoryEntity> entityList = categoryService.queryAllCategoryWithTree();
        return R.ok().put("data",entityList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
		categoryService.removeByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
