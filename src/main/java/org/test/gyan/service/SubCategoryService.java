package org.test.gyan.service;

import org.test.gyan.model.SubCategory;

import java.util.List;

public interface SubCategoryService {
    public List<SubCategory> getSubCategoryByCategory(Long categoryId);
}
