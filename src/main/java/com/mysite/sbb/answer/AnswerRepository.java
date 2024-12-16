package com.mysite.sbb.answer;
// JPA가 제공하는 인터페이스 중 하나로 CRUD 작업을 처리하는 메서드들을 이미 내장하고 있어 데이터 관리 작업을 좀 더 편리하게 처리
import org.springframework.data.jpa.repository.JpaRepository;


// Question 엔티티로 리포지터리를 생성 ,Answer의 엔티티의 기본키가 Integer
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
