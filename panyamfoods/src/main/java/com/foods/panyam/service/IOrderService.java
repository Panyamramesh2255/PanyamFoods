package com.foods.panyam.service;

import com.foods.panyam.model.OrderModel;
import com.foods.panyam.response.Response;

public interface IOrderService {

	Response placeOrder(OrderModel order);

	Response deleteOrder(Long id);

	Response getAllOrders();

	Response updateOrder(OrderModel order);

}
