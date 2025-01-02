package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("springmvc/v3/members")
//중복된 매핑 값을 따로 설정 가능
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();


    //@RequestMapping(value = "/new-form", method = RequestMethod.GET)
    // method 데이터 값을 어떤 방식으로 받을껀지 설정하면 설정한 값으로만 데이터를 받을 수 있다.
    @GetMapping("/new-form")
    // @GetMapping, @PostMapping 어노테이션으로도 get,post 설정 가능 함
    public String newForm(){
        return "new-form";
    }

    // @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(
            // Spring은 HTTP 요청 파라미터를 @RequestParam 으로 받을 수 있음
            // request.getParameter("username") 과 거의 같은 코드
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model
            ){

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);

        return "save-result";
    }

   // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String List(Model model){

        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);

        return "members";
    }

}
