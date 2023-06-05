## 스프링 컨테이너
* ApplicationContext를 스프링 컨테이너라고 한다.
* v2에서는 AppConfig를 사용해서 직접 객체를 생성하고 DI를 했지만, v3부터는 스프링 컨테이너를 통해서 사용한다.
* 스프링 컨테이너 @Configuration이 붙은 클래스를 설정 정보로 활용한다.
* 여기에 @Bean이 붙은 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 스프링 빈으로 등록한다.
* 스프링 빈은 @Bean이 붙은 메서드의 명을 이름으로 사용한다.
* v2에서는 필요한 객체를 직접 AppConfig를 사용해서 직접 조회했지만, v3부터는 스프링 컨테이너를 통해서 필요한 스프링 빈을 찾아야 한다.
* 스프링 빈은 applicationContext.getBean()을 사용해서 찾을 수 있다.

## 스프링 컨테이너가 생성되는 과정
* ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
* 스프링 컨테이너는 XML을 기반으로 만들 수 있고, 애너테이션 기반의 자바 설정 클래스로도 만들 수 있다.
* AppConfig 클래스를 이용하는 방법이 자바 설정 클래스로 만든 것이다.

1. 스프링 컨테이너 생성
* new AnnotationConfigApplicationContext(AppConfig.class)
* 스프링 컨테이너를 생성할 떄는 AppConfig.class처럼 구성 정보를 지정해주어야 한다.

2. 스프링 빈 등록
* 스프링 컨테이너는 파라미터로 넘어온 설정 클래스 정보를 사용해서 스프링 빈을 등록한다.
* 빈 이름 - 일반적ㄱ으로 메서드 이름을 사용하지만, 직접 부여하는 것도 가능하다.
* * @Bean(name = "memberService2")
* 동일한 빈 이름을 부여하면, 다른 빈이 무시되거나, 기존 빈을 덮어버리거나, 오류가 발생할 수 있다.

3. 스프링 빈 의존관계 설정 준비
4. 스프링 빈 의존관계 설정 완료
* 스프링 컨테이너는 설정 정보(AppConfig)를 참고해서 의존관계를 주입한다.

## BeanFactory와 ApplicationContext
* BeanFactory
* * 스프링 컨테이너의 최상위 인터페이스이다.
* * 스프링 빈을 관리하고 조회하는 역할을 담당한다.
* * getBean()을 제공한다.

* ApplicationContext
* * BeanFactory 기능을 모두 상속받아서 제공한다.
* * BeanFactory에서 제공하는 기능들 이외에도 메시지 소스를 활용한 국제화기능, 환경변수, 애플리케이션 이벤트, 편리한 리소스 조회 등 다양한 부가기능을 제공한다.

## 요약
* ApplicationContext는 BeanFactory의 기능을 상속받는다.
* ApplicationContext는 빈 관리기능 + 부가기능을 제공한다.
* 일반적으로 BeanFactory에서 제공하는 기능과 더불어 부가기능을 제공하는 ApplicationContext를 사용한다.
* BeanFactory나 ApplicationContext를 스프링 컨테이너라고 한다.