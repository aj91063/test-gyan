package org.test.gyan.service;


import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.test.gyan.model.Category;

public interface CategoryService {

    String saveCategory(Category category);
}
