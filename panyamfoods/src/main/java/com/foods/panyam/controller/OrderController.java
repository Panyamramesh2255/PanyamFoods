package com.foods.panyam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foods.panyam.model.OrderModel;
import com.foods.panyam.response.Response;
import com.foods.panyam.service.IOrderService;

@RestController
@RequestMapping("/oder")
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	@PostMapping("/placeorder")
	public ResponseEntity<Response> placeOrder(@RequestBody OrderModel order)
	{
		Response response = orderService.placeOrder(order);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getallorders")
	public ResponseEntity<Response> getAllOrders()
	{
		Response response = orderService.getAllOrders();
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@PutMapping("/updateorder")
	public ResponseEntity<Response> updateOrder(@RequestBody OrderModel order)
	{
		Response response = orderService.updateOrder(order);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteorder")
	public ResponseEntity<Response> deleteItem(@RequestParam Long id)
	{
		Response response = orderService.deleteOrder(id);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}
	
	

}
