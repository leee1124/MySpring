package MySpringStudy.core.v5.scan.filter;

import java.lang.annotation.*;

// 컴폰넌트 스캔 대상에 추가할 애노테이션
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
