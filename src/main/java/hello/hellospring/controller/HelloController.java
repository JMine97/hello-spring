package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러 어노테이션
public class HelloController {
    //웹어플리케이션에서 주소창에 /hello 들어오면 해당 메소드 호출
    @GetMapping("hello")
    public String hello(Model model){
        //data라는 이름에 'hello!'라는 값을 보낸다
        model.addAttribute("data", "hello!");

        return "hello"; //hello.html 값을 반환
    }

    @GetMapping("hello-mvc")
    //외부에서 name 이라는 이름의 파라미터 받아오기
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http의 body의 문자 내용 직접 반환
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    //api 방식
    //json 방식 key-value로 이루어진 구조
    //옛날에는 xml도 썼는데 요즘은 json 쓰는 게 기본
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
