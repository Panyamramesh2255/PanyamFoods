package com.foods.panyam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foods.panyam.model.UserModel;


@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
	
	public UserModel findByMobileNumber(String mobileNumber);

}
