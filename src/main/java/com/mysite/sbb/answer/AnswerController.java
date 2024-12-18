package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;


@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;

    ///answer/create/{id}와 같은 URL 요청 시 createAnswer 메서드가 호출되도록 @PostMapping으로 매핑
//    @PostMapping("/create/{id}")
//    //  @RequestParam : question_detail.html)에서 답변으로 입력한 내용(content)을 얻으려고 추가한 것이다.
//    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content) {
//        Question question = this.questionService.getQuestion(id);
//        // 답변 저장
//        this.answerService.create(question, content);
//        return String.format("redirect:/question/detail/%s", id);
//    }


    //@Valid와 BindingResult를 사용하여 검증을 진행한다.
    // 검증에 실패할 경우에는 다시 답변을 등록할 수 있는 question_detail 템플릿을 출력하게 했다.
    // 이때 question_detail 템플릿은 Question 객체가 필요하므로 model 객체에 Question 객체를 저장한 후에 question_detail 템플릿을 출력해야 한다.
    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult) {
        Question question = this.questionService.getQuestion(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }
        this.answerService.create(question, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }
}
