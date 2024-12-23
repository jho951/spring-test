package com.mysite.sbb;

import java.util.List;
import java.util.Optional;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.transaction.annotation.Transactional;


import com.mysite.sbb.question.QuestionService;


// SbbApplicationTests 클래스가 스프링 부트의 테스트 클래스임을 의미
@SpringBootTest
class SbbApplicationTests {
	//  테스트 코드 작성 시에만 권장
	//  스프링의 ‘의존성 주입(DI)’이라는 기능을 사용해 스프링 부트가 questionRepository 객체를 자동으로 만들어 주입
//	@Autowired
//	private QuestionRepository questionRepository;
//
//	@Autowired
//	private AnswerRepository answerRepository;

	// testJpa 메서드가 테스트 메서드임을 나타낸다
//	@Test


//	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?");
//		q1.setContent("sbb에 대해서 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);  // 첫번째 질문 저장
//
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);  // 두번째 질문 저장
//	}
	// findAll 메서드 : 테이블에서 저장된 모든 데이터를 조회하기 위해서
	// SELECT * FROM QUESTION과 같은 결과
//	void testJpa() {
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
//	}

	// findById 메서드 : id값으로 데이터를 조회하기 위해서는 리포지터리의
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}
//	}

	// findBySubject 메서드를 사용하려면 다음과 같이 QuestionRepository 인터페이스를 변경해야 한다
	// 엔티티의 subject값으로 데이터를 조회
	// JPA에 리포지터리의 메서드명을 분석하여 쿼리를 만들고 실행하는 기능이 있기 때문에 가능
//	void testJpa() {
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1, q.getId());
//	}
	// findBySubjectAndContent : subject와 content를 함께 조회
//	void testJpa() {
//		Question q = this.questionRepository.findBySubjectAndContent(
//				"sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//		assertEquals(1, q.getId());
//	}
	//findBySubjectLike  : 질문 엔티티의 subject 열 값들 중에 특정 문자열을 포함하는 데이터를 조회
	// 데이터 조회를 위한 조건이 되는 문자열로 sbb%와 같이 %를 적어 주어야 한다.
//	void testJpa() {
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
//	}
	// 데이터 삭제
//	void testJpa() {
//		assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());
//	}

	// answer 생성
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
//	}
	// answer id로 찾기
//	void testJpa() {
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());
//	}

	// 질문을 조회한 후 이 질문에 달린 답변 전체를 구함
	// a는 답변 객체이고, a.getQuestion()은 답변에 연결된 질문 객체를 뜻한다.
	// QuestionRepository가 findById 메서드를 통해 Question 객체를 조회하고 나면 DB 세션이 끊어져 오류 발생
	// DB 세션이란 스프링 부트 애플리케이션과 데이터베이스 간의 연결을 뜻한다.
	// 데이터를 필요한 시점에 가져오는 방식을 지연(Lazy) 방식
	//. @OneToMany, @ManyToOne 애너테이션의 옵션으로 fetch=FetchType.LAZY 또는 fetch=FetchType.EAGER처럼 가져오는 방식을 설정할 수 있는데
	// @Transactional 애너테이션을 사용하면 메서드가 종료될 때까지 DB 세션이 유지된다.
//	@Transactional
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		List<Answer> answerList = q.getAnswerList();
//
//		assertEquals(1, answerList.size());
//		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
//	}
	@Autowired
	private QuestionService questionService;

	@Test
	void testJpa() {
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
			this.questionService.create(subject, content);
		}
	}
}
