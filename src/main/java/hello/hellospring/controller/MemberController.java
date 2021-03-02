package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //생성자에 Autowired가 있으면 컨트롤러에 있는 memberService 인스턴스랑 연결해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
