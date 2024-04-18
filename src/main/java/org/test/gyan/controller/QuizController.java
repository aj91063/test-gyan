package org.test.gyan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.test.gyan.model.Quiz;
import org.test.gyan.model.SubCategory;
import org.test.gyan.repositry.QuizRepository;
import org.test.gyan.repositry.SubCategoryRepositry;

import java.util.Optional;

@Controller
public class QuizController {

    private static Logger log = LoggerFactory.getLogger(QuizController.class);

    @Autowired
    private SubCategoryRepositry subCategoryRepositry;
    @Autowired
    private QuizRepository quizRepository;
    @RequestMapping(value = "/saveQuiz", method = RequestMethod.POST)
    public ModelAndView saveQuiz(@ModelAttribute("quiz") Quiz quiz, @RequestParam Long subCategoryId){

        if(subCategoryId != null){
            Optional<SubCategory> subCategory = subCategoryRepositry.findById(subCategoryId);
            if(subCategory.isPresent()){
                quiz.setSubCategory(subCategory.get());
                quizRepository.save(quiz);
                log.info(String.format("quizName : %s",quiz.getQuizName()));
            }
        }else{
            log.info("SubCategory Id : "+subCategoryId+" not available");
        }
        return new ModelAndView("redirect:/addQuiz");
    }

    @GetMapping("/showQuestion")
    public ModelAndView showQuestion(@RequestParam Long quizId){
        ModelAndView modelAndView = new ModelAndView();

        if(quizId != null || quizId >0){
            Optional<Quiz> quiz = quizRepository.findById(quizId);
            if(quiz.isPresent()){
                modelAndView.addObject("quiz", quiz.get().getQuizName());
            }

        }
        modelAndView.setViewName("showQuestion.html");
        return modelAndView;
    }

    @GetMapping("/addQuestion")
    public ModelAndView addQuestion(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-questions.html");
        return modelAndView;
    }
}
