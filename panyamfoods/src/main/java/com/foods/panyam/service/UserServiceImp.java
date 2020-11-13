package com.foods.panyam.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foods.panyam.model.UserModel;
import com.foods.panyam.repository.IUserRepository;
import com.foods.panyam.response.Response;
import com.foods.panyam.util.ResponseStatus;

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

				return new Response(ResponseStatus.SUCCESSCODE, user, "Registration Successfull..");
			} else {
				return new Response(ResponseStatus.FAILURECODE, user, "MobileNumber already exist..");
			}
		} else {
			return new Response(ResponseStatus.FAILURECODE, null, "Registration Failure..");
		}

	}

	@Override
	public Response getAllUsers() {

		return new Response(ResponseStatus.SUCCESSCODE, userRepository.findAll(), "Exited users showed here...");

	}

	@Override
	public Response login(String mobileNumber, String password) {
		UserModel user = userRepository.findByMobileNumber(mobileNumber);
		if (user != null) 
		{
			if(user.getPassword().contentEquals(password))
			{
				
				if(user.isLogin())
				{
					return new Response(ResponseStatus.FAILURECODE, user, "User Already Logged in...");	
				}
				else
				{
					return new Response(ResponseStatus.SUCCESSCODE, user, "Login Successfull...");	
				}
			}
			else
			{
				return new Response(ResponseStatus.FAILURECODE, user, "Invalid Password...");	
			}
		}
		else
		{
			return new Response(ResponseStatus.FAILURECODE, user, "User does not exist...");
		}
	}

	@Override
	public Response logout(String mobileNumber, String password) {

		UserModel user = userRepository.findByMobileNumber(mobileNumber);
		if (user != null) {
			if (user.isLogin()) {
				user.setLogin(false);
				userRepository.save(user);
				return new Response(ResponseStatus.SUCCESSCODE, user, "Logout Successfull...");
			} else {
				return new Response(ResponseStatus.FAILURECODE, user, "Unauthorised user...");
			}

		} else {
			return new Response(ResponseStatus.FAILURECODE, user, "User does not exist...");
		}

	}

	@Override
	public Response updateUser(UserModel user) {
		if (user != null) {
			UserModel user1 = userRepository.findByMobileNumber(user.getMobileNumber());
			if (user1 != null) {
				user.setUpdationDate(new Date());
				userRepository.save(user);
				return new Response(ResponseStatus.SUCCESSCODE, user1, "User Updated successfully...");
			} else {
				return new Response(ResponseStatus.FAILURECODE, user1, "User does not exist...");
			}

		} else {
			return new Response(ResponseStatus.FAILURECODE, user, "Requestbody is empty...");
		}

	}

	@Override
	public Response deleteUser(Long id) {
		userRepository.deleteById(id);

		return new Response(ResponseStatus.SUCCESSCODE, null, "User Deleted Successfully...");
	}

	@Override
	public Response getUser(String mobileNumber) {
		if(mobileNumber!=null)
		{
			UserModel user = userRepository.findByMobileNumber(mobileNumber);
			if(user!=null)
			{
				return new Response(ResponseStatus.SUCCESSCODE, user, "User Fetched Successfully...");
			}
			else
			{
				return new Response(ResponseStatus.FAILURECODE, null, "User does not exist with given Mobile Number...");
			}
		}
		else
		{
			return new Response(ResponseStatus.FAILURECODE, null, "Mobile Number is empty...");
		}
		
	}

}
