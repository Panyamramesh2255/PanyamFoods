package com.foods.panyam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foods.panyam.model.ItemModel;
import com.foods.panyam.repository.IItemRepository;
import com.foods.panyam.response.Response;
import com.foods.panyam.util.ResponseStatus;

@Service
public class ItemServiceImp implements IItemService {
	
	@Autowired
	private IItemRepository itemRepository;

	@Override
	public Response addItem(ItemModel item) {
		
		if(item!=null)
		{
			itemRepository.save(item);
			return new Response(ResponseStatus.SUCCESSCODE, item, "Item Added Successfully..");
			
		}
		else
		{
			return new Response(ResponseStatus.FAILURECODE, null, "Item is null..");
		}
	}

	@Override
	public Response updateItem(ItemModel item, Long id) {
		if(item!=null)
		{
			Optional<ItemModel> item1 = itemRepository.findById(id);
			if(item1!=null)
			{
				itemRepository.save(item);
				return new Response(ResponseStatus.SUCCESSCODE, item, "Item Added Successfully...");
				
			}
			else
			{
				return new Response(ResponseStatus.FAILURECODE, item, "Item with given id does not exist...");
			}
			
			
		}
		else
		{
			return new Response(ResponseStatus.FAILURECODE, item, "Item Updation UnSuccessfully...");
		}
		
	}

	@Override
	public Response deleteItem(Long id) {
		
		Optional<ItemModel> item = itemRepository.findById(id);
		if(item!=null)
		{
			itemRepository.deleteById(id);
			return new Response(ResponseStatus.SUCCESSCODE, item, "Item Deleted Successfully...");
			
		}
		else
		{
			return new Response(ResponseStatus.FAILURECODE, item, "Item with given id does not exist...");
		}
	}

	@Override
	public Response getAllItems() {
		
		return new Response(ResponseStatus.SUCCESSCODE, itemRepository.findAll(), "existed items here...");
	}

}
