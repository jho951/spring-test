package com.mysite.sbb.question;

import java.util.List;
import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
//  @RequiredArgsConstructor에 의해 생성자 방식으로 주입된다.
@RequiredArgsConstructor
// 생성한 클래스를 서비스로 만들기
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    // 질문 목록 데이터를 조회하여 리턴하는 getList 메서드를 추가
    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
}