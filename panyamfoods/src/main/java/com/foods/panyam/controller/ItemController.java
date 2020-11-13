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

import com.foods.panyam.model.ItemModel;
import com.foods.panyam.response.Response;
import com.foods.panyam.service.IItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private IItemService itemService;
	
	@PostMapping("/additem")
	public ResponseEntity<Response> addItem(@RequestBody ItemModel item)
	{
		Response response=itemService.addItem(item);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@PutMapping("/updateitem")
	public ResponseEntity<Response> updateItem(@RequestBody ItemModel item, @RequestParam Long id)
	{
		Response response = itemService.updateItem(item, id);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteitem")
	public ResponseEntity<Response> deleteItem( @RequestParam Long id)
	{
		Response response = itemService.deleteItem(id);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}
	@GetMapping("/getallitems")
	public ResponseEntity<Response> getAllItems()
	{
		Response response =itemService.getAllItems();
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	

}
