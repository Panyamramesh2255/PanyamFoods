package com.foods.panyam.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foods.panyam.model.UserModel;
import com.foods.panyam.repository.IUserRepository;
import com.foods.panyam.response.Response;

@Service
public class UserServiceImp implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public Response registerUser(UserModel user) {
		if (user != null) {

			UserModel user1 = userRepository.findByMobileNumber(user.getMobileNumber());
			if (user1 == null) {
				if (user.getMobileNumber().contentEquals("8106526525")
						|| user.getMobileNumber().contentEquals("7702382489")) {
					user.setAdmin(true);
				} else {
					user.setAdmin(false);
				}
				user.setCreationDate(new Date());
				user.setUpdationDate(new Date());
				userRepository.save(user);

				return new Response(200, user, "Registration Successfull..");
			} else {
				return new Response(202, user, "MobileNumber already exist..");
			}
		} else {
			return new Response(400, null, "Registration Failure..");
		}

	}

	@Override
	public Response getAllUsers() {

		return new Response(200, userRepository.findAll(), "Exited users showed here...");

	}

	@Override
	public Response login(String mobileNumber, String password) {
		UserModel user = userRepository.findByMobileNumber(mobileNumber);
		if (user != null) {
			user.setLogin(true);
			userRepository.save(user);
			return new Response(200, user, "Login Successfull...");
		} else {
			return new Response(200, user, "User does not exist...");
		}

	}

	@Override
	public Response logout(String mobileNumber, String password) {

		UserModel user = userRepository.findByMobileNumber(mobileNumber);
		if (user != null) {
			if (user.isLogin()) {
				user.setLogin(false);
				userRepository.save(user);
				return new Response(200, user, "Looout Successfull...");
			} else {
				return new Response(200, user, "Unauthorised user...");
			}

		} else {
			return new Response(200, user, "User does not exist...");
		}

	}

	@Override
	public Response updateUser(UserModel user) {
		if (user != null) {
			UserModel user1 = userRepository.findByMobileNumber(user.getMobileNumber());
			if (user1 != null) {
				user.setUpdationDate(new Date());
				userRepository.save(user);
				return new Response(200, user1, "User Updated successfully...");
			} else {
				return new Response(400, user1, "User does not exist...");
			}

		} else {
			return new Response(400, user, "Requestbody is empty...");
		}

	}

	@Override
	public Response deleteUser(Long id) {
		userRepository.deleteById(id);

		return new Response(200, null, "User Deleted Successfully...");
	}

}
