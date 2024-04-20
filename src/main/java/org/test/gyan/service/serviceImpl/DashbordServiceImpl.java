package org.test.gyan.service.serviceImpl;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.test.gyan.model.Category;
import org.test.gyan.model.Quiz;
import org.test.gyan.repositry.CategoryRepository;
import org.test.gyan.repositry.QuizRepository;
import org.test.gyan.service.DashbordService;

import java.util.List;

@Service
public class DashbordServiceImpl implements DashbordService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private QuizRepository quizRepository;
    @Override
    public ModelAndView dashbord(HttpServletRequest request) {

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

    @Override
    public ModelAndView userTableList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("servletPath",request.getServletPath());
        modelAndView.setViewName("User.html");
        return modelAndView;
    }

    @Override
    public ModelAndView addCategory(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("servletPath",request.getServletPath());
        modelAndView.setViewName("add_category.html");
        return modelAndView;
    }

    @Override
    public ModelAndView addQuiz(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categories= categoryRepository.findAll();
        modelAndView.addObject("categories",categories);
        modelAndView.addObject("servletPath",request.getServletPath());
        modelAndView.setViewName("add_quiz.html");
        return modelAndView;
    }

    @Override
    public ModelAndView addQuestion(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categories= categoryRepository.findAll();
        modelAndView.addObject("servletPath",request.getServletPath());
        modelAndView.addObject("categories",categories);
        modelAndView.setViewName("add_sub-category.html");
        return modelAndView;
    }

    @Override
    public ModelAndView categoryList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categories = categoryRepository.findAll();
        List<Quiz> quizzes=quizRepository.findAll();
        modelAndView.addObject("categories",categories);
        modelAndView.addObject("servletPath",request.getServletPath());
        modelAndView.setViewName("categoryList.html");
        return modelAndView;
    }


}
