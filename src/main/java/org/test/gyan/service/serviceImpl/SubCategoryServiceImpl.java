package org.test.gyan.service.serviceImpl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.test.gyan.model.Category;
import org.test.gyan.model.Quiz;
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

    @Override
    public ModelAndView saveSubCategory(SubCategory subCategory, Long categoryId) {


        if (categoryId != null) {
            Optional<Category> category = categoryRepository.findById(categoryId);
            if (category.isPresent()) {
                subCategory.setCategory(category.get());
                subCategoryRepositry.save(subCategory);
                log.info("CategoryName : " + subCategory.getCategory().getCategoryName());
            }
        } else {
            log.info("Category Id : " + categoryId + " not available");
        }
        log.info("subCategoryName : " + subCategory.getSubCategoryName());


        return new ModelAndView("redirect:/addSubCategory");
    }

    @Override
    public ModelAndView quizessList(Long subCategoryId) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<SubCategory> subCategory = subCategoryRepositry.findById(subCategoryId);
        if (subCategory.isPresent()) {
            modelAndView.addObject("subCategory", subCategory.get().getSubCategoryName());
            List<Quiz> quizzes = subCategory.get().getQuizzes();
            modelAndView.addObject("quizzes",quizzes);
            modelAndView.addObject("subCategoryId",subCategoryId);
            modelAndView.setViewName("quizess.html");
        }

        return modelAndView;
    }
}
