package org.test.gyan.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.test.gyan.model.Category;
import org.test.gyan.model.Quiz;
import org.test.gyan.model.SubCategory;
import org.test.gyan.repositry.CategoryRepository;
import org.test.gyan.repositry.QuizRepository;

import java.util.Iterator;
import java.util.List;

@Controller
public class DashbordController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private QuizRepository quizRepository;
    @GetMapping({"/",""})
    public ModelAndView dashboard(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Integer size=null;
        List<Category> categories = categoryRepository.findAll();
        List<Quiz> quizzes=quizRepository.findAll();

        modelAndView.setViewName("Dashbord.html");
        modelAndView.addObject("servletPath",request.getServletPath());
        modelAndView.addObject("categories",categories);
        modelAndView.addObject("quizSize",quizzes.size());

        return modelAndView;
    }

    @GetMapping("/userTableList")
    public ModelAndView userTableList(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("servletPath",request.getServletPath());
        modelAndView.setViewName("User.html");
        return modelAndView;
    }

    @GetMapping("/addCategory")
    public ModelAndView addCategory(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("servletPath",request.getServletPath());
        modelAndView.setViewName("add_category.html");
        return modelAndView;
    }

    @GetMapping("/addQuiz")
    public ModelAndView addQuiz(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categories= categoryRepository.findAll();
        modelAndView.addObject("categories",categories);
        modelAndView.addObject("servletPath",request.getServletPath());
        modelAndView.setViewName("add_quiz.html");
        return modelAndView;
    }

    @GetMapping("/addSubCategory")
    public ModelAndView addQuestion(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
       List<Category> categories= categoryRepository.findAll();
        modelAndView.addObject("servletPath",request.getServletPath());
        modelAndView.addObject("categories",categories);
        modelAndView.setViewName("add_sub-category.html");
        return modelAndView;
    }

    @GetMapping("/categoryList")
    public ModelAndView categoryList(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categories = categoryRepository.findAll();
        List<Quiz> quizzes=quizRepository.findAll();
        modelAndView.addObject("categories",categories);
        modelAndView.addObject("servletPath",request.getServletPath());
        modelAndView.setViewName("categoryList.html");
        return modelAndView;
    }
}
