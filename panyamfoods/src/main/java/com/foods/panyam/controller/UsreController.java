package com.foods.panyam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foods.panyam.model.UserModel;
import com.foods.panyam.response.Response;
import com.foods.panyam.service.IUserService;

@RestController
@RequestMapping("/user")
public class UsreController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody UserModel user)
	{
		Response response = userService.registerUser(user);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getallusers")
	public ResponseEntity<Response> getAllUsers()
	{
		Response respose = userService.getAllUsers();
	  return new ResponseEntity<Response>(respose, HttpStatus.OK);
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<Response> getAllUsers(@RequestParam String mobileNumber)
	{
		Response respose = userService.getUser(mobileNumber);
	  return new ResponseEntity<Response>(respose, HttpStatus.OK);
	}
	
	@PutMapping("/updateuser")
	public ResponseEntity<Response> updateUser(@RequestBody UserModel user)
	{
		Response response = userService.updateUser(user);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteuser")
	public ResponseEntity<Response> deleteUser(@RequestParam Long id)
	{
		Response response = userService.deleteUser(id);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/login")
	public  ResponseEntity<Response>  login(@RequestHeader String mobileNumber, @RequestHeader String password)
	{
		Response response = userService.login(mobileNumber, password);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public  ResponseEntity<Response>  logout(@RequestHeader String mobileNumber, @RequestHeader String password)
	{
		Response response = userService.logout(mobileNumber, password);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	

}
