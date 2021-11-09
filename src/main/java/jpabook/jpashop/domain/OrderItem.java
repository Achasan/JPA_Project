package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    private Item item;

    // Order는 여러 개의 아이템을 가질 수 있다. OrderItem은 하나의 주문에 종속된다. 1:N 관계
    @ManyToOne // 현재 클래스 기준으로 관계를 작성한다. (N:1)이다.
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; // 주문 가격
    private int count; // 주문 수량
}
