package com.tech.OrderService.Command.api.data;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

	private String orderId;
	private String productId;
	private String userId;
	private String addressId;
	private Integer quantity;
	private String orderStatus;
}
