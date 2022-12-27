package com.nhan.comic.service;
import com.nhan.comic.entity.Category;

import java.util.List;
public interface CategoryService {
    List<Category> getAllCategories();

    void saveCategoryData(Category categoryData);

    Category getCategoryById(int categoryId);

    void removeCategoryById(int categoryId);

    boolean checkCategoryIsExist(String categoryName, int categoryId);
}
