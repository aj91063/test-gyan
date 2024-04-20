package org.test.gyan.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.test.gyan.controller.CategoryController;
import org.test.gyan.model.Category;
import org.test.gyan.repositry.CategoryRepository;
import org.test.gyan.service.CategoryService;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public String saveCategory(Category category) {

        log.info(String.format("Category Description : %s",category.getDescription()));
        Optional<Category> categoryOptional = categoryRepository.findByCategoryName(category.getCategoryName());
        ModelAndView modelAndView=new ModelAndView();
        if (category != null && !categoryOptional.isPresent()){
            categoryRepository.save(category);
          return "redirect:/addCategory?success=true&categoryName="+category.getCategoryName();

        }else {
            log.info(String.format("Category Name : %s is already exits.",category.getCategoryName()));
            return "redirect:/addCategory?error=true&categoryName="+category.getCategoryName();
        }

    }
}
