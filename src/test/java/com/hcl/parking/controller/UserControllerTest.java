package com.hcl.parking.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.parking.dto.LoginDetailsDto;
import com.hcl.parking.dto.LoginDto;
import com.hcl.parking.dto.SlotDetailsDto;
import com.hcl.parking.dto.SlotRequestDto;
import com.hcl.parking.dto.UserDetailsDto;
import com.hcl.parking.dto.UserDto;
import com.hcl.parking.service.UserService;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class UserControllerTest {

	@Mock
	UserService userService;
	
	@InjectMocks
	UserController userController;
	
	UserDetailsDto userDetailsDto = null;
	UserDto userDto = null;
	LoginDetailsDto loginDetails = null;
	LoginDto loginDto = null;
	SlotDetailsDto slotDetails = null;
	SlotRequestDto slotRequestDto = null;
	
	@Before
	public void setup() {
		userDetailsDto = new UserDetailsDto();
		userDetailsDto.setStatusCode(201);
		
		userDto = new UserDto();
		userDto.setUserName("LA");
		
		loginDetails = new LoginDetailsDto();
		loginDetails.setStatusCode(200);
		
		loginDto = new LoginDto();
		loginDto.setEmail("mpl@gmail.com");
		
		slotRequestDto = new SlotRequestDto();
		slotRequestDto.setUserId(1);
		
		slotDetails = new SlotDetailsDto();
		slotDetails.setStatusCode(201);
	}
	
	@Test
	public void registerTest() {
		Mockito.when(userService.register(userDto)).thenReturn(userDetailsDto);
		ResponseEntity<UserDetailsDto> responseEntity = userController.register(userDto);
		UserDetailsDto userDetailsDtos = responseEntity.getBody();
		assertEquals(userDetailsDto.toString(), userDetailsDtos.toString());
	}

	@Test
	public void loginTest() {
		Mockito.when(userService.login(loginDto)).thenReturn(loginDetails);
		ResponseEntity<LoginDetailsDto> responseEntity = userController.login(loginDto);
		LoginDetailsDto loginDetailsDto = responseEntity.getBody();
		assertEquals(loginDetails.toString(), loginDetailsDto.toString());
	}
	
	@Test
	public void slotRequestTest() {
		Mockito.when(userService.slotRequest(slotRequestDto)).thenReturn(slotDetails);
		ResponseEntity<SlotDetailsDto> responseEntity = userController.slotRequest(slotRequestDto);
		SlotDetailsDto slotDetailsDto = responseEntity.getBody();
		assertEquals(slotDetails.toString(), slotDetailsDto.toString());
	}
}
