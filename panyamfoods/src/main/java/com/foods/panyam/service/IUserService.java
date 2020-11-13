package com.foods.panyam.service;

import com.foods.panyam.model.UserModel;
import com.foods.panyam.response.Response;

public interface IUserService {

	Response registerUser(UserModel user);

	Response getAllUsers();

	Response login(String mobileNumber, String password);

	Response logout(String mobileNumber, String password);

	Response updateUser(UserModel user);

	Response deleteUser(Long id);

}
