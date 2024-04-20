package org.test.gyan.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.test.gyan.model.Category;
import org.test.gyan.model.Quiz;
import org.test.gyan.model.SubCategory;
import org.test.gyan.repositry.CategoryRepository;
import org.test.gyan.repositry.QuizRepository;
import org.test.gyan.service.DashbordService;

import java.util.Iterator;
import java.util.List;

@Controller
public class DashbordController {

    @Autowired
    private DashbordService dashbordService;
    @GetMapping({"/",""})
    public ModelAndView dashboard(HttpServletRequest request){
        return dashbordService.dashbord(request);
    }

    @GetMapping("/userTableList")
    public ModelAndView userTableList(HttpServletRequest request){
        return dashbordService.userTableList(request);
    }

    @GetMapping("/addCategory")
    public ModelAndView addCategory(HttpServletRequest request,
                                    @RequestParam(value = "error", required = false) String error,
                                    @RequestParam(value = "success", required = false) String success,Model model,
                                    @RequestParam(value = "categoryName", required = false) String categoryName){
        String errorMsg=null;
        String successMsg=null;
        System.out.println("error>>"+error);
        System.out.println("success>>"+success);
        if(error != null && categoryName !=null){
            errorMsg=categoryName.toUpperCase()+" category already exits.";
        }
        if(success != null && categoryName !=null){
            successMsg=categoryName.toUpperCase()+" category is created";
        }
        model.addAttribute("errorMsg",errorMsg);
        model.addAttribute("successMsg",successMsg);
        return dashbordService.addCategory(request);
    }

    @GetMapping("/addQuiz")
    public ModelAndView addQuiz(HttpServletRequest request){
        return dashbordService.addQuiz(request);
    }

    @GetMapping("/addSubCategory")
    public ModelAndView addQuestion(HttpServletRequest request){
       return dashbordService.addQuestion(request);
    }

    @GetMapping("/categoryList")
    public ModelAndView categoryList(HttpServletRequest request){
        return dashbordService.categoryList(request);
    }
}
