package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // 문자를 리턴하면 String이 그대로 반환 (REST API를 만들 때 핵심적인 컨트롤러)
public class LogTestController {

    // getLogger() : getClass(), LogTestController.class 둘 다 사용 가능
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test") // @GetMapping으로 해도 무방
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);
        // 로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X
        log.trace(" trace my log="+ name);

        // {} : 뒤에 있는 변수의 순서대로 치환된다.
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}