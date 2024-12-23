package com.mysite.sbb.question;

import java.util.List;
import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;
//  @RequiredArgsConstructor에 의해 생성자 방식으로 주입된다.
@RequiredArgsConstructor
// 생성한 클래스를 서비스로 만들기
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    // 질문 목록 데이터를 조회하여 리턴하는 getList 메서드를 추가
//    public List<Question> getList() {
//        return this.questionRepository.findAll();
//    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
    // 제목(subject)과 내용(content)을 입력받아 이를 질문으로 저장
    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }

    public Page<Question> getList(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return this.questionRepository.findAll(pageable);
    }
}