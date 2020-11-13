package com.foods.panyam.service;

import com.foods.panyam.model.ItemModel;
import com.foods.panyam.response.Response;

public interface IItemService {

	Response addItem(ItemModel item);

	Response updateItem(ItemModel item, Long itemId);

	Response deleteItem(Long id);

	Response getAllItems();

}
