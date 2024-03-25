package org.test.gyan.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.test.gyan.model.Category;
import org.test.gyan.model.SubCategory;
import org.test.gyan.repositry.CategoryRepository;
import org.test.gyan.repositry.SubCategoryRepositry;

import java.util.Optional;
import java.util.Set;

@Controller
public class CategoryController {
    private static Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryRepository categoryRepository;
//    @Autowired
//    private SubCategoryRepositry subCategoryRepositry;
    @PostMapping(value = "/saveCategory")
    public ModelAndView saveCategory(@ModelAttribute(name = "category") Category category){

        log.info(String.format("Category Description : %s",category.getDescription()));
        Optional<Category> categoryOptional = categoryRepository.findByCategoryName(category.getCategoryName());

        if (category != null && !categoryOptional.isPresent()){
            categoryRepository.save(category);
        }else {
            log.info(String.format("Category Name : %s",category.getCategoryName()));
        }
        return new ModelAndView("redirect:/addCategory");
    }




    @RequestMapping(value = "/getCategory", method = RequestMethod.GET)
    @ResponseBody
     public Category getCategory(@RequestParam(value = "categoryId") Long categoryId){
        Category category=  categoryRepository.findById(categoryId).get();
        log.info("Category = "+category);
        return category;
    }
}
