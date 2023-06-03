# 스프링 핵심 원리 이해
* MySpringFramework를 개발해보는 것을 목적으로 한다.
* 인프런 - 스프링 핵심 원리 이해(강사. 김영한)

## 개발 환경
* Windows 11
* Java 17
* IDE: IntelliJ Ultimate

## 비즈니스 요구사항과 설계
### 회원
* 회원을 가입하고 조회할 수 있다.
* 회원은 일반과 VIP 두 가지 등급이 있다.
* 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다.(미확정)

### 주문과 할인 정책
* 회원은 상품을 주문할 수 있다.
* 회원 등급에 따라 할인 정책을 적용할 수 있다.
* 모든 VIP 고객은 1000원을 할인해주는 할인 정책을 적용한다(추후 변경 가능)
* 할인 정책은 변경 가능성이 높다.

## 회원 도메인 설계
### 회원 도메인 협력 관계
![image](https://github.com/leee1124/MySpring/assets/80409890/17c0ae8e-f88a-4fbb-b9db-0f83a4059d0a)

### 회원 클래스 다이어그램
![image](https://github.com/leee1124/MySpring/assets/80409890/ca012b29-5846-4625-8ca2-e07f3238ad45)

### 회원 객체 다이어그램
![image](https://github.com/leee1124/MySpring/assets/80409890/2adce0d1-32d3-491f-a044-44fbc6231763)


## 주문 할인과 도메인 설계
### 주문 도메인 협력, 역할, 책임
![image](https://github.com/leee1124/MySpring/assets/80409890/a7d28535-ab81-4452-94c2-221f673aa3a0)

### 주문 도메인 전체
![image](https://github.com/leee1124/MySpring/assets/80409890/ec9cff71-a212-4dd1-bd0b-3f1aedede924)

### 주문 도메인 클래스 다이어그램
![image](https://github.com/leee1124/MySpring/assets/80409890/d6f78109-0493-4671-b824-257aab02ed47)

### 주문 도메인 객체 다이어그램1
![image](https://github.com/leee1124/MySpring/assets/80409890/6a2ad463-b418-4ede-a932-d713b048848f)

### 주문 도메인 객체 다이어그램2
![image](https://github.com/leee1124/MySpring/assets/80409890/fc2a313a-aeee-43ff-a4fc-056e426354a1)
