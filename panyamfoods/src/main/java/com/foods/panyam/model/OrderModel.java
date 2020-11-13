package com.foods.panyam.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "orders", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class OrderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private String mobileNumber;
	private Long[] itemIds;
	private Date creationDate;

	@ManyToOne(targetEntity = ItemModel.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private List<ItemModel> items;
	private String orderStatus;

	public OrderModel() {
		super();
	}

	public OrderModel(String description, String mobileNumber, Long[] itemIds, Date creationDate, List<ItemModel> items,
			String orderStatus) {
		super();
		this.description = description;
		this.mobileNumber = mobileNumber;
		this.itemIds = itemIds;
		this.creationDate = creationDate;
		this.items = items;
		this.orderStatus = orderStatus;
	}

	
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long[] getItemIds() {
		return itemIds;
	}

	public void setItemIds(Long[] itemIds) {
		this.itemIds = itemIds;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<ItemModel> getItems() {
		return items;
	}

	public void setItems(List<ItemModel> items) {
		this.items = items;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
