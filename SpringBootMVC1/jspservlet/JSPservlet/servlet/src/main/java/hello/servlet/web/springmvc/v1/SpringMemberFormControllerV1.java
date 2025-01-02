package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
// 자동으로 스프링 빈으로 등록한다 내부에 @Component 에노테이션이 있어 스캔 대상이 됨
// 스프링 MVC에서 에노테이션 기반 컨트롤러로 인식
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    //해당 URL 이 호출되면 해당 메소드가 호출 에노테이션 기반으로 동작함, 메서드 이름은 임의로 생성
    public ModelAndView process(){
        return new ModelAndView("new-form");

    }
}
