package com.foods.panyam.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foods.panyam.model.ItemModel;
import com.foods.panyam.model.OrderModel;
import com.foods.panyam.model.UserModel;
import com.foods.panyam.repository.IItemRepository;
import com.foods.panyam.repository.IOrderRepository;
import com.foods.panyam.repository.IUserRepository;
import com.foods.panyam.response.Response;
import com.foods.panyam.util.ResponseStatus;

@Service
public class OrderServiceImp implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IItemRepository itemRepository;

	@Override
	public Response placeOrder(OrderModel order) {

		if (order != null)

		{
			
			UserModel user = userRepository.findByMobileNumber(order.getMobileNumber());
			if (user != null) {
				
                order.setCreationDate(new Date());
				orderRepository.save(order);
				return new Response(ResponseStatus.SUCCESSCODE, order, "OrderPlaces successfully");
			} else {
				return new Response(ResponseStatus.FAILURECODE, order, "Unauthorized user...");
			}
		} else {
			return new Response(ResponseStatus.FAILURECODE, order, "Empty items cannot place order");
		}
	}

	@Override
	public Response deleteOrder(Long id) {
		Optional<ItemModel> item= itemRepository.findById(id);
		itemRepository.deleteById(id);
		return new Response(ResponseStatus.SUCCESSCODE, item, "Order Deleted successfully");
	}

	@Override
	public Response getAllOrders() {
		
		return new Response(ResponseStatus.SUCCESSCODE, orderRepository.findAll(), "Existed Orders showed here...");
	}

	@Override
	public Response updateOrder(OrderModel order) {
		
	     if(order!=null)
	     {
	    	 Long id = order.getId();
	    	 if(id!=null)
	    	 {
	    		 orderRepository.save(order);
	    		 return new Response(ResponseStatus.SUCCESSCODE, order, "Order updated Successfully...");
	    	 }
	    	 else
	    	 {
	    		 return new Response(ResponseStatus.FAILURECODE, order, "Order id not exist in the posted body...");	 
	    	 }
	     }
	     else
	     {
	    	 return new Response(ResponseStatus.FAILURECODE, order, "Posted order body is empty...");
	     }
	}
	

}
