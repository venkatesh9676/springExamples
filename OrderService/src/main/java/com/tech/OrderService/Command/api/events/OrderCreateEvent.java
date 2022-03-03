package com.tech.OrderService.Command.api.events;

import lombok.Data;

@Data 
public class OrderCreateEvent {

	private String orderId;
	private String productId;
	private String userId;
	private String addressId;
	private Integer quantity;
	private String orderStatus;
}
