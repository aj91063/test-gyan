package org.test.gyan.service.serviceImpl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.gyan.model.Category;
import org.test.gyan.model.SubCategory;
import org.test.gyan.repositry.CategoryRepository;
import org.test.gyan.repositry.SubCategoryRepositry;
import org.test.gyan.service.SubCategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import org.slf4j.Logger;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private SubCategoryRepositry subCategoryRepositry;

  private static Logger log=LoggerFactory.getLogger(SubCategoryServiceImpl.class);
    @Override
    public List<SubCategory> getSubCategoryByCategory(Long categoryId) {
        List<SubCategory> subCategories=null;
      Optional<Category> category = categoryRepository.findById(categoryId);
      if(category.isPresent()){
          subCategories =   category.get().getSubCategory();
          return subCategories;
      }else {
          log.error("<<<< This id not found : "+categoryId);
      }
    return   subCategories;
    }
}
