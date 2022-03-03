package com.tech.OrderService.Command.api.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.tech.OrderService.Command.api.Command.CreateOrderCommand;
import com.tech.OrderService.Command.api.events.OrderCreateEvent;

@Aggregate
public class OrderAggregate {

	@AggregateIdentifier
	private String orderId;
	private String productId;
	private String userId;
	private String addressId;
	private Integer quantity;
	private String orderStatus;

	public OrderAggregate() {

	}

	@CommandHandler
	public OrderAggregate(CreateOrderCommand createOrderCommand) {
		//Validate The Command
        OrderCreateEvent orderCreateEvent = new OrderCreateEvent();
        BeanUtils.copyProperties(createOrderCommand,orderCreateEvent);
        AggregateLifecycle.apply(orderCreateEvent);
	}

	@EventSourcingHandler
	public void on(OrderCreateEvent event) {
		this.orderStatus = event.getOrderStatus();
		this.userId = event.getUserId();
		this.orderId = event.getOrderId();
		this.quantity = event.getQuantity();
		this.productId = event.getProductId();
		this.addressId = event.getAddressId();
	}
}
