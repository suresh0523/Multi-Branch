package com.hcl.parking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.LoginDetailsDto;
import com.hcl.parking.dto.LoginDto;
import com.hcl.parking.dto.SlotDetailsDto;
import com.hcl.parking.dto.SlotRequestDto;
import com.hcl.parking.dto.UserDetailsDto;
import com.hcl.parking.dto.UserDto;
import com.hcl.parking.service.UserService;

/**
 * @author Lakshmi
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	/**
	 * This method is intended for registration of the user
	 * 
	 * @param UserDto
	 * @return UserDetailsDto
	 */
	@PostMapping("/registration")
	public ResponseEntity<UserDetailsDto> register(@RequestBody UserDto userDto) {
		LOGGER.debug("PurchasePolicyController optPolicy()");
		UserDetailsDto userDetailsDto = userService.register(userDto);
		return new ResponseEntity<>(userDetailsDto, HttpStatus.CREATED);
	}

	/**
	 * This method is intended for login of the user
	 * 
	 * @param LoginDto
	 * @return LoginDetailsDto
	 */
	@PostMapping("/login")
	public ResponseEntity<LoginDetailsDto> login(@RequestBody LoginDto loginDto) {
		LOGGER.debug("PurchasePolicyController login()");
		LoginDetailsDto loginDetailsDto = userService.login(loginDto);
		return new ResponseEntity<>(loginDetailsDto, HttpStatus.OK);
	}

	/**
	 * This method is intended for request slot of the user
	 * 
	 * @param SlotRequestDto
	 * @return SlotDetailsDto
	 */
	@PostMapping("/request")
	public ResponseEntity<SlotDetailsDto> slotRequest(@RequestBody SlotRequestDto slotRequestDto) {
		LOGGER.debug("PurchasePolicyController slotRequest()");
		SlotDetailsDto slotDetailsDto = userService.slotRequest(slotRequestDto);
		return new ResponseEntity<>(slotDetailsDto, HttpStatus.CREATED);
	}
}
