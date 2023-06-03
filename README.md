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
![image](https://github.com/leee1124/MySpring/assets/80409890/489c1420-d4f2-4f19-8829-c76ff547e798)

### 회원 클래스 다이어그램
![image](https://github.com/leee1124/MySpring/assets/80409890/c5c10ba9-26b9-4fd2-a2a1-d2c7bec4f9c4)


### 회원 객체 다이어그램
![image](https://github.com/leee1124/MySpring/assets/80409890/5434da05-3698-4196-8803-936b078d672e)


## 주문 할인과 도메인 설계
### 주문 도메인 협력, 역할, 책임
![image](https://github.com/leee1124/MySpring/assets/80409890/c6849d58-78d8-4531-880b-91a093b0ae03)

### 주문 도메인 전체
![image](https://github.com/leee1124/MySpring/assets/80409890/51960e32-29e2-46d3-bebb-500678081808)

### 주문 도메인 클래스 다이어그램
![image](https://github.com/leee1124/MySpring/assets/80409890/cb35f44a-3ba1-4f17-a096-2e4d59e1ef14)

### 주문 도메인 객체 다이어그램1
![image](https://github.com/leee1124/MySpring/assets/80409890/062bc93b-98d6-4c10-8c9e-acb6ffd1be5e)

### 주문 도메인 객체 다이어그램2
![image](https://github.com/leee1124/MySpring/assets/80409890/817ea47f-bfbb-47f2-bdf1-895d74e6602d)#   M y S p r i n g  
 