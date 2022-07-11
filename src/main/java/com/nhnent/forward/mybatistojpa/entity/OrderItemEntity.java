package com.nhnent.forward.mybatistojpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OrderItems")
public class OrderItemEntity {

	// 복합키 필드
	@EmbeddedId
	private Pk pk = new Pk();
	
	@Column
	private Integer quantity;
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Embeddable
	public static class Pk implements Serializable {
		@Column(name = "order_id")
		private Long orderId;
		
		@Column(name = "line_number")
		private Integer lineNumber;
	}
	
	// OrderItemEntity-ItemEntity 연관관계 추가
	@JoinColumn(name = "item_id")
	@ManyToOne
	private ItemEntity item;
	
	// OrderItemEntity-OrderEntity 연관관계 추가
	@JoinColumn(name = "order_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("orderId")
	private OrderEntity order;
}
