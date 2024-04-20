package org.test.gyan.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface DashbordService {
    ModelAndView dashbord(HttpServletRequest request);

    ModelAndView userTableList(HttpServletRequest request);

    ModelAndView addCategory(HttpServletRequest request);

    ModelAndView addQuiz(HttpServletRequest request);

    ModelAndView addQuestion(HttpServletRequest request);

    ModelAndView categoryList(HttpServletRequest request);
}
