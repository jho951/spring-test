package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 클래스가 컨트롤러의 기능을 수행 있어야 스프링부트는 인지
public class MainController {
    //'매핑(mapping)하다'라는 말은 특정 URL 경로를 서버의 특정 메서드와 연결하는 것을 의미
    // Get 방식의 URL 요청을 위해 @GetMapping을 사용하고, Post 방식의 URL 요청을 위해서는 @PostMapping을 사용
    @GetMapping("/hello")// localhost/8080/hello에 접속 시 실행 URL명과 메서드명이 동일할 필요는 없다.
    @ResponseBody // hello 메서드의 출력 결과가 문자열 그 자체
    public String hello() {
        return "Hello world!";
    }
}