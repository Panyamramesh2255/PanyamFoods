package com.foods.panyam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity

public class ItemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private float prize;
	private int itemCount;
	private float singlePieceCost;
	private float profit;
	private String image;

	
	public ItemModel(String description, float prize, int itemCount, float singlePieceCost, float profit,
			String image) {
		super();
		this.description = description;
		this.prize = prize;
		this.itemCount = itemCount;
		this.singlePieceCost = singlePieceCost;
		this.profit = profit;
		this.image = image;
	}

	
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ItemModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrize() {
		return prize;
	}

	public void setPrize(float prize) {
		this.prize = prize;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public float getSinglePieceCost() {
		return singlePieceCost;
	}

	public void setSinglePieceCost(float singlePieceCost) {
		this.singlePieceCost = singlePieceCost;
	}

	public float getProfit() {
		return profit;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}

}
