package com.mysite.sbb;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class HelloLombok {
    private final String hello;
    private final int lombok;
// 애너테이션을 적용하면 해당 속성(hello와 lombok)을 필요로 하는 생성자가 롬복에 의해 자동으로 생성
    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("헬로", 5);
        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}

//package com.mysite.sbb;
//
//public class HelloLombok {
//    private String hello;
//    private int lombok;
//
//    public void setHello(String hello) {
//        this.hello = hello;
//    }
//
//    public void setLombok(int lombok) {
//        this.lombok = lombok;
//    }
//
//    public String getHello() {
//        return this.hello;
//    }
//
//    public int getLombok() {
//        return this.lombok;
//    }
//
//    public static void main(String[] args) {
//        HelloLombok helloLombok = new HelloLombok();
//        helloLombok.setHello("헬로");
//        helloLombok.setLombok(5);
//
//        System.out.println(helloLombok.getHello());
//        System.out.println(helloLombok.getLombok());
//    }
//}