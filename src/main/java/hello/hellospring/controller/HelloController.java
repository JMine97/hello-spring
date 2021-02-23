package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //컨트롤러 어노테이션
public class HelloController {
    //웹어플리케이션에서 주소창에 /hello 들어오면 해당 메소드 호출
    @GetMapping("hello")
    public String hello(Model model){
        //data라는 이름에 'hello!'라는 값을 보낸다
        model.addAttribute("data", "hello!");

        return "hello"; //hello.html 값을 반환
    }
}
