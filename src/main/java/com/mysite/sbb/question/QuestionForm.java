package com.mysite.sbb.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    // 해당 값이 Null 또는 빈 문자열("")을 허용하지 않음
    // message는 검증이 실패할 경우 화면에 표시할 오류 메시지이다.
    @NotEmpty(message="제목은 필수항목입니다.")
    // @Size(max=200)은 최대 길이가 200 바이트(byte)를 넘으면 안 된다
    @Size(max=200)
    private String subject;
    // 빈 값을 허용하지 않도록 했다.
    @NotEmpty(message="내용은 필수항목입니다.")
    private String content;
}
