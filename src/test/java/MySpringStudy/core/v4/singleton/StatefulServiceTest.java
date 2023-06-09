package MySpringStudy.core.v4.singleton;

import MySpringStudy.core.v4.AppConfig;
import jdk.dynalink.beans.StaticClass;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA: 사용자 A 10000원 주문
        statefulService1.order("userA", 10000);
        //ThreadB: 사용자 B 20000원 주문
        statefulService2.order("userB", 20000);

        //ThreadA: 사용자A 주문금액 조회
        int price = statefulService1.getPrice();
        //사용자 A는 10000원을 출력할 것을 기대했지만, 기대와는 다르게 20000원 출력
        System.out.println("price = " + price);

        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }


    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}