package com.foods.panyam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foods.panyam.model.ItemModel;
import com.foods.panyam.repository.IItemRepository;
import com.foods.panyam.response.Response;

@Service
public class ItemServiceImp implements IItemService {
	
	@Autowired
	private IItemRepository itemRepository;

	@Override
	public Response addItem(ItemModel item) {
		
		if(item!=null)
		{
			itemRepository.save(item);
			return new Response(200, item, "Item Added Successfully..");
			
		}
		else
		{
			return new Response(400, null, "Item is null..");
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
				return new Response(200, item, "Item Added Successfully...");
				
			}
			else
			{
				return new Response(400, item, "Item with given id does not exist...");
			}
			
			
		}
		else
		{
			return new Response(400, item, "Item Updation UnSuccessfully...");
		}
		
	}

	@Override
	public Response deleteItem(Long id) {
		
		Optional<ItemModel> item = itemRepository.findById(id);
		if(item!=null)
		{
			itemRepository.deleteById(id);
			return new Response(200, item, "Item Deleted Successfully...");
			
		}
		else
		{
			return new Response(400, item, "Item with given id does not exist...");
		}
	}

	@Override
	public Response getAllItems() {
		
		return new Response(200, itemRepository.findAll(), "existed items here...");
	}

}
