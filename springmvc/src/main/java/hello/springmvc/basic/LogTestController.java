package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
// private final Logger log = LoggerFactory.getLogger(getClass()); 애노테이션이 자동으로 등록
@RestController
// 데이터를 그대로 반환하여 view에 ok 값 반환
public class LogTestController {
   // private final Logger log = LoggerFactory.getLogger(getClass());
    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";
        String name2 = "Spring2";

        System.out.println("name = " + name);

        log.trace(" trace log={}", name);
        log.debug(" debug log={}", name);
        log.info(" info log={},{}", name,name2);
        log.warn(" warn log={}", name);
        log.error(" error log={}", name);

        return "ok";
    }
}
