package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*
컴포넌트 스캔과 자동 의존관계 설정
@Component : 애노테이션이 있으면 스프링 빈으로 자동 등록됨
@Controller : 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문

@Component를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록됨
- @Controller, @Service, @Repository

 */


/*
* 자바 코드로 직접 스프링 빈 등록
* @Service, @Repository, @Autowired 어노테이션 제거하고 진행
* SpringConfig 새로 작성, @Configuration , @bean 어노테이션 사용
* */

@Controller
public class MemberController {
    private final MemberService memberService; //  = new MemberService();

    @Autowired //생성자주입 >> 가장 추천하는 방식
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    /*
    필드주입
    @Autowired private MemberService memberService; 하고 생성자 필요 없음
    
     setter 주입
     private MemberService memberService;
     @Autowired
     public void setMEmberService(MemberService memberService(){this.memberService = memberService}
     하고 여기도 생성자 필요 없음
     */

    /*
    * 보통 조회때 getMapping / 값을 전달할 때 postMapping을 쓴다
    * 같은 매핑이더라도 이렇게 get/post에 따라서 다르게 매핑을 할 수 있음
    * */
    @GetMapping("/members/new")
    public String crateForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        //System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
    
}
