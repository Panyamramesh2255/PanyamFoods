package com.foods.panyam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foods.panyam.model.OrderModel;


@Repository
public interface IOrderRepository extends JpaRepository<OrderModel, Long> {

}
