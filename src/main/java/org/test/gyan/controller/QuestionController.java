package org.test.gyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.test.gyan.model.Question;
import org.test.gyan.model.Quiz;
import org.test.gyan.repositry.QuestionRepository;
import org.test.gyan.repositry.QuizRepository;

import java.util.Optional;

@Controller
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    /*
    *
   {
    "title":"what is java",
    "option1":"OOP1",
    "option2":"OOP2",
    "option3":"OOP3",
    "option4":"OOP4",
    "solution":"no solution",
    "answer":"OOp4",
    "image":"default.jpg",
    "quiz":{
        "quizId":2
    }
}
* */
    @PostMapping("/saveQuestion")
    public ModelAndView saveQuestion(@ModelAttribute(name = "question") Question question, @RequestParam Long quizId){
        Optional<Quiz> quiz= quizRepository.findById(quizId);
       question.setQuiz(quiz.get());
      Question question1= questionRepository.save(question);

      return new ModelAndView("redirect:/addQuestion?quizId="+quizId);
    }


}
