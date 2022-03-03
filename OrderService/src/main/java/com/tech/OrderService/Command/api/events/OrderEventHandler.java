package com.tech.OrderService.Command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.tech.OrderService.Command.api.data.Order;
import com.tech.OrderService.Command.api.data.OrderRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Component
public class OrderEventHandler {
	
@EventHandler
public void on(OrderCreateEvent event) {
	
	private OrderRepository orderRepository;
	
	public OrderEventHandler(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@EventHandler
	public void on(OrderCreateEvent event) {
		Order order = new Order();
		BeanUtil.copyProperties(event,order);
	}
}
}
