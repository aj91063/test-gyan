package org.test.gyan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.test.gyan.model.SubCategory;
import org.test.gyan.service.SubCategoryService;
import java.util.List;


@Controller
public class SubCategoryController {

    private static Logger log = LoggerFactory.getLogger(SubCategoryController.class);


    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping(value = "/saveSubCategory")
    public ModelAndView saveSubCategory(@ModelAttribute(name = "subCategory") SubCategory subCategory,
                                        @RequestParam("categoryId") Long categoryId) {
        return subCategoryService.saveSubCategory(subCategory, categoryId);
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
       return subCategoryService.quizessList(subCategoryId);
    }
}
