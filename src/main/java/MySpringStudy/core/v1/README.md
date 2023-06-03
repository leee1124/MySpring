### 기대했던 의존 관계
![image](https://github.com/leee1124/MySpring/assets/80409890/a8514d39-451d-43db-9653-992add574917)

### 실제 의존 관계
![image](https://github.com/leee1124/MySpring/assets/80409890/9069b309-b7b3-4962-bc16-9515374d4dc8)


## 잘한 점
* 역할과 구현을 충실하게 분리함
* 다형성 활용, 인터페이스와 구현객체 분리

## 문제점
* DIP 위반: 인터페이스 뿐만 아니라 구현 클래스에도 의존하고있다.
* OCP 위반: 현재 코드에서 기능을 확장해서 변경하면, 클라이언트 코드에 영향을 주기 때문에 OCP 위반  => FixDiscountPolicy를 RateDiscountPolicy로 변경하면 OrderServiceImpl도 변경해야 함.

## 문제 해결 방법
* 인터페이스에만 의존하도록 설계 변경
* 인터페이스에만 의존하려면 누군가가 구현객체를 대신 생성하고 주입해주어야 한다.
