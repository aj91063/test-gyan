package org.test.gyan.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.test.gyan.model.Category;
import org.test.gyan.model.SubCategory;
import org.test.gyan.repositry.CategoryRepository;
import org.test.gyan.repositry.SubCategoryRepositry;
import org.test.gyan.service.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class CategoryController {
    private static Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;
//    @Autowired
//    private SubCategoryRepositry subCategoryRepositry;
    @RequestMapping(value = "/saveCategory", method = {RequestMethod.POST, RequestMethod.GET})
    public String saveCategory(@ModelAttribute(name = "category") Category category){

       return categoryService.saveCategory(category);
    }




    @RequestMapping(value = "/getCategory", method = RequestMethod.GET)
    @ResponseBody
     public Category getCategory(@RequestParam(value = "categoryId") Long categoryId){
        Category category=  categoryRepository.findById(categoryId).get();
        log.info("Category = "+category);
        return category;
    }

    @GetMapping("/subCategoryList")
    public ModelAndView viewSubCategoryByCategoryId(@RequestParam Long cId){
        ModelAndView modelAndView = new ModelAndView();
        Optional<Category> categoryOptional = categoryRepository.findById(cId);
        if (categoryOptional.isPresent()){
            modelAndView.addObject("CategoryName", categoryOptional.get().getCategoryName());
            List<SubCategory> subCategory = categoryOptional.get().getSubCategory();
            modelAndView.addObject("subCategories", subCategory);
            modelAndView.setViewName("subCategoryList.html");
        }
        return modelAndView;
    }
}
