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
![image](https://github.com/leee1124/MySpring/assets/80409890/70cafc59-854e-4839-869d-7688f22049e6)

* BeanFactory
* * 스프링 컨테이너의 최상위 인터페이스이다.
* * 스프링 빈을 관리하고 조회하는 역할을 담당한다.
* * getBean()을 제공한다.

* ApplicationContext
* * BeanFactory 기능을 모두 상속받아서 제공한다.
* * BeanFactory에서 제공하는 기능들 이외에도 메시지 소스를 활용한 국제화기능, 환경변수, 애플리케이션 이벤트, 편리한 리소스 조회 등 다양한 부가기능을 제공한다.

### ApplicationContext가 제공하는 부가기능
![image](https://github.com/leee1124/MySpring/assets/80409890/4abaa516-6f86-4b43-ac90-d229484f744e)
* 메시지 소스를 활용한 국제화기능: ex) 한국에서 들어오면 한국어로 출력, 영어권에서 들어오면 영어로 출력
* 환경변수: 로컬, 개발, 운영 등을 구분해서 처리
* 애플리케이션 이벤트: 이벤트를 발행하고 구독하는 모델을 편리하게 지원
* 편리한 리소스 조회: 파일, 클래스패스, 외부 등에서 리소스를 편리하게 조회

## XML을 활용한 설정
* 최근에는 많이 사용하지 않지만 XML 기반의 설정도 사용할 수 있다.(우리회사처럼)

## 스프링 빈 설정 메타 정보 - BeanDefinition
![image](https://github.com/leee1124/MySpring/assets/80409890/0fcc5694-d9a2-401d-be4f-e2852d01a5ce)

* XML, 자바 코드 등을 읽어서 BeanDefinition을 만든다.
* 스프링 컨테이너는 xml인지 자바 코드인지 몰라도 되고, BeanDefinition만 알면 된다.
* =>역할과 구현을 개념적으로 나눈 것
* BeanDefinition을 빈 설정 메타정보라고 하는데, <bean> @Bean당 각각 하나의 메타 정보가 생성된다.
* 스프링 컨테이너는 메타정보를 기반으로 스프링 빈을 생성한다.

![image](https://github.com/leee1124/MySpring/assets/80409890/3283239a-d960-4035-8d51-7c6ad1628e24)
  
* AnnotationConfigApplicationContext는 AnnotatedBeanDefinitionReader를 사용해서 AppConfig.class를 읽고 BeanDefinition을 생성한다.
* GenericXmlConfigApplicationContext는 XmlBeanDefinitionReader를 사용해서 appConfig.xml를 읽고 BeanDefinition을 생성한다.
* 즉, 새로운 형식의 설정정보가 추가되면 xxxConfigApplicationContext는 xxxBeanDefinitionReader를 만들어서 BeanDefinition을 생성하면 된다.

## BeanDefinition 정보
* BeanClassName: 생성할 빈의 클래스 명(자바 설정 처럼 팩토리 역할의 빈을 사용하면 없음)
* factoryBeanName: 팩토리 역할의 빈을 사용할 경우 이름, 예) appConfig
* factoryMethodName: 빈을 생성할 팩토리 메서드 지정, 예) memberService
* Scope: 싱글톤(기본값)
* lazyInit: 스프링 컨테이너를 생성할 때 빈을 생성하는 것이 아니라, 실제 빈을 사용할 때 까지 최대한 생성을 지연처리 하는지 여부
* InitMethodName: 빈을 생성하고, 의존관계를 적용한 뒤에 호출되는 초기화 메서드 명
* DestroyMethodName: 빈의 생명주기가 끝나서 제거하기 직전에 호출되는 메서드 명
* Constructor arguments, Properties: 의존관계 주입에서 사용한다. (자바 설정 처럼 팩토리 역할의 빈을 사용하면 없음)

## 요약
* ApplicationContext는 BeanFactory의 기능을 상속받는다.
* ApplicationContext는 빈 관리기능 + 부가기능을 제공한다.
* 일반적으로 BeanFactory에서 제공하는 기능과 더불어 부가기능을 제공하는 ApplicationContext를 사용한다.
* BeanFactory나 ApplicationContext를 스프링 컨테이너라고 한다.
* BeanDefinition을 직접 생성해서 스프링 컨테이너에 등록할 수 도 있다. 
