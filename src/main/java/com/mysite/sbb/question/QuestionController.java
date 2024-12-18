package com.mysite.sbb.question;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

// @RequiredArgsConstructor 애너테이션의 생성자 방식으로 questionRepository 객체를 주입
import lombok.RequiredArgsConstructor;

@RequestMapping("/question")

// 롬복(Lombok)이 제공하는 애너테이션으로, final이 붙은 속성을 포함하는 생성자를 자동으로 만들어 주는 역할
// 스프링 부트(Spring Boot)가 내부적으로 QuestionController를 생성할 때
// 롬복으로 만들어진 생성자에 의해 questionRepository 객체가 자동으로 주입
@RequiredArgsConstructor

@Controller
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;
    // 템플릿을 사용하면 필요가 없습니다.
    // @ResponseBody
    // @GetMapping("/question/list")
    @GetMapping("/list")
   //그리고 QuestionRepository의 findAll 메서드를 사용하여 질문 목록 데이터인 questionList를 생성하고
    // Model 객체에 ‘questionList’라는 이름으로 저장했다.
    // 여기서 Model 객체는 자바 클래스(Java class)와 템플릿(template) 간의 연결 고리 역할을 한다.
    // Model 객체에 값을 담아 두면 템플릿에서 그 값을 사용할 수 있다. Model 객체는 따로 생성할 필요 없이
    // 컨트롤러의 메서드에 매개변수로 지정하기만 하면 스프링 부트가 자동으로 Model 객체를 생성
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        // findAll 메서드를 사용하여 질문 목록 데이터인 questionList를 생성하고 Model 객체에 ‘questionList’라는 이름으로 저장
//        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
//    @GetMapping(value = "/question/detail/{id}")
//    public String detail(Model model, @PathVariable("id") Integer id) {
//        return "question_detail";
//    }

//    @GetMapping(value = "/question/detail/{id}")




    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

// GET 요청에 해당하므로 @GetMapping 애너테이션을 사용했다. questionCreate 메서드는 question_form 템플릿을 출력한다.
    @GetMapping("/create")
    public String questionCreate() {
        return "question_form";
    }

}
