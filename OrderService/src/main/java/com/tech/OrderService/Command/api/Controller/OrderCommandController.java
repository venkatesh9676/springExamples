package com.tech.OrderService.Command.api.Controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.OrderService.Command.api.Command.CreateOrderCommand;
import com.tech.OrderService.Command.api.model.OrderRestModel;

@RestController
@RequestMapping("/orders")
public class OrderCommandController {

	private CommandGateway commandGateway;
	
	@PostMapping 
	public String createOrder(@RequestBody OrderRestModel orderRestModel) {
		String orderId = UUID.randomUUID().toString();
		
		CreateOrderCommand createOrderCommand = CreateOrderCommand.builder()
				             .orderId(orderId)
				             .addressId(orderRestModel.getAddressId())
				             .productId(orderRestModel.getProductId())
				             .quantity(orderRestModel.getQuantity())
				             .orderStatus("CREATED")
				             .build();
		
		commandGateway.sendAndWait(createOrderCommand);
		return "Order Created";
	}
}
