package MySpringStudy.core.v5;

import MySpringStudy.core.v5.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AutoAppConfigTest {

    /**
     * AnnotationConfigApplicationContext를 사용하는 것은 기존과 동일하다.
     * 설정 정보로 AutoAppConfig를 넘겨준다.
     * 실행해보면 기존과 같이 잘 동작한다.
     */
    @Test
    void basicScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}