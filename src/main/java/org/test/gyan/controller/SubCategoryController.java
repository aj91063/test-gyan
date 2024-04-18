package org.test.gyan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.test.gyan.model.Category;
import org.test.gyan.model.Quiz;
import org.test.gyan.model.SubCategory;
import org.test.gyan.repositry.CategoryRepository;
import org.test.gyan.repositry.SubCategoryRepositry;
import org.test.gyan.service.SubCategoryService;
import org.test.gyan.service.serviceImpl.SubCategoryServiceImpl;

import java.util.List;
import java.util.Optional;

@Controller
public class SubCategoryController {

    private static Logger log = LoggerFactory.getLogger(SubCategoryController.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepositry subCategoryRepositry;

    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping(value = "/saveSubCategory")
    public ModelAndView saveSubCategory(@ModelAttribute(name = "subCategory") SubCategory subCategory,
                                        @RequestParam("categoryId") Long categoryId) {

        if (categoryId != null) {
            Optional<Category> category = categoryRepository.findById(categoryId);
            if (category.isPresent()) {
                subCategory.setCategory(category.get());
                subCategoryRepositry.save(subCategory);
                log.info("CategoryName : " + subCategory.getCategory().getCategoryName());
            }
        } else {
            log.info("Category Id : " + categoryId + " not ava");
        }
        log.info("subCategoryName : " + subCategory.getSubCategoryName());


        return new ModelAndView("redirect:/addSubCategory");
    }

    @PostMapping(value = "/getSubCategory")
    @ResponseBody
    public List<SubCategory> getSubCategory(@RequestParam(value = "categoryId") Long categoryId) {
        List<SubCategory> subCategory = subCategoryService.getSubCategoryByCategory(categoryId);
        System.out.println("categoryId :=== " + subCategory);
        return subCategory;
    }

    @GetMapping("/quizesList")
    public ModelAndView quizessList(@RequestParam Long subCategoryId) {
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
