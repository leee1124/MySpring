package MySpringStudy.core.v5;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


/**
 * 컴포넌트 스캔을 사용하려면 @ComponentScan을 사용하면 된다.
 * 컴포넌트 스캔을 사용하면 @Configuration이 붙은 설정 정보도 자동으로 등록된다.
 * 따라서, AppConfig, TestConfig 등 앞서 만들어 두었던 설정 정보도 등록된다.
 * 그런 상황을 피하기 위해서 excludeFilters를 이용해서 설정정보를 제외했다.
 * 보통 설정 정보를 컴포넌트 스캔 대상에서 제외하지는 않지만, 기존 예제 코드를 남기고 유지하기 위해서 선택한 방법입다.
 */
@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}
