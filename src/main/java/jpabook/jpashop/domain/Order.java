package jpabook.jpashop.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;

	@Column(name = "MEMBER_ID")
	private Long memberId;

	private LocalDateTime orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;
}