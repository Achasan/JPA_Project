package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Table(name = "orders")
@Entity
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order_id")
    private List<OrderItem> orderItems = new ArrayList<>();

    private Delivery delivery;

    // LocalDateTime : Java8에서 지원하는 객체 year-month-day-hour-minute-second로 시간 표현
    // Hibernate가 자동으로 날짜인식해서 테이블에 넣어준다. Date date도 사용가능하지만 애노테이션으로 설정해주어야함
    private LocalDateTime orderDate;

    private OrderStatus status; // 주문상태 [order, cancel] enum
}
