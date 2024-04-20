package org.test.gyan.service;

import org.springframework.web.servlet.ModelAndView;
import org.test.gyan.model.SubCategory;

import java.util.List;

public interface SubCategoryService {
    public List<SubCategory> getSubCategoryByCategory(Long categoryId);

    ModelAndView saveSubCategory(SubCategory subCategory, Long categoryId);
    ModelAndView quizessList(Long subCategoryId);
}
