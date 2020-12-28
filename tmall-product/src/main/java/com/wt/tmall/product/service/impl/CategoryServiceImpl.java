package com.wt.tmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.common.utils.PageUtils;
import com.wt.common.utils.Query;
import com.wt.tmall.product.dao.CategoryDao;
import com.wt.tmall.product.entity.CategoryEntity;
import com.wt.tmall.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> queryAllCategoryWithTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        //查询一级分类
        List<CategoryEntity> menu = categoryEntities.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map(categoryEntity -> {
                    //设置子菜单
                    categoryEntity.setChildren(queryChildrenMenu(categoryEntity, categoryEntities));
                    return categoryEntity;
                })
                .sorted(Comparator.comparingInt(o -> (o.getSort() == null ? 0 : o.getSort())))
                .collect(Collectors.toList());
        return menu;
    }

    @Override
    public void removeCategory(List<Long> categoryIds) {
        this.removeByIds(categoryIds);
    }

    //查询子菜单
    public static List<CategoryEntity> queryChildrenMenu(CategoryEntity root, List<CategoryEntity> allMenu) {
        List<CategoryEntity> childMenu = allMenu.stream()
                .filter(entity -> entity.getParentCid().longValue() == root.getCatId().longValue())
                .map(categoryEntity -> {
                    categoryEntity.setChildren(queryChildrenMenu(categoryEntity, allMenu));
                    return categoryEntity;
                })
                .sorted(Comparator.comparingInt(o -> (o.getSort() == null ? 0 : o.getSort())))
                .collect(Collectors.toList());
        return childMenu;
    }
}