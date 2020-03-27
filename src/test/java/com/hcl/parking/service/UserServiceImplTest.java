package com.hcl.parking.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.parking.dto.LoginDetailsDto;
import com.hcl.parking.dto.LoginDto;
import com.hcl.parking.dto.UserDetailsDto;
import com.hcl.parking.dto.UserDto;
import com.hcl.parking.entity.Parking;
import com.hcl.parking.entity.Role;
import com.hcl.parking.entity.User;
import com.hcl.parking.exception.ParkingSlotException;
import com.hcl.parking.repository.ParkingRepository;
import com.hcl.parking.repository.ParkingRequestRepository;
import com.hcl.parking.repository.RoleRepository;
import com.hcl.parking.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@Mock
	UserRepository userRepository;

	@Mock
	ParkingRepository parkingRepository;

	@Mock
	ParkingRequestRepository parkingRequestRepository;

	@Mock
	RoleRepository roleRepository;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Test
	public void testRegister() {

		List<Parking> paList = new ArrayList<>();

		Parking parking = new Parking();
		parking.setParkingId(1);
		parking.setParkingSlot("P1");
		parking.setUserId(1);

		paList.add(parking);

		UserDto userDto = new UserDto();
		userDto.setUserName("raja");
		userDto.setPassword("raja@123");
		userDto.setMobileNo(9030853295L);
		userDto.setJoiningDate(LocalDate.now());
		// userDto.setEmail("");
		userDto.setCareerStartDate(LocalDate.now());

		User user = new User();
		user.setUserId(1);
		user.setUserName("raja");
		user.setRoleId(1);
		user.setPassword("raja@123");
		user.setMobileNo(9030853295L);
		user.setJoiningDate(LocalDate.now());
		user.setEmail("raja@gmail.com");
		user.setCareerStartDate(LocalDate.now());

		UserDetailsDto userDetailsDto = new UserDetailsDto();
		userDetailsDto.setMessage("Reggistered successfully and allocated parking slot.");
		userDetailsDto.setStatusCode(201);


		Mockito.when(parkingRepository.findByUserId(null)).thenReturn(paList);
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);

		UserDetailsDto actualValue = userServiceImpl.register(userDto);
		assertEquals(userDetailsDto.getStatusCode(), actualValue.getStatusCode());

	}

	@Test
	public void testRegisterParkingAllocate() {

		List<Parking> paList = new ArrayList<>();

		Parking parking = new Parking();
		parking.setParkingId(1);
		parking.setParkingSlot("P1");
		parking.setUserId(1);

		paList.add(parking);

		UserDto userDto = new UserDto();
		userDto.setUserName("raja");
		userDto.setPassword("raja@123");
		userDto.setMobileNo(9030853295L);
		userDto.setJoiningDate(LocalDate.of(2014, 01, 01));
		userDto.setCareerStartDate(LocalDate.of(2000, 01, 01));
		// userDto.setEmail("");

		User user = new User();
		user.setUserId(1);
		user.setUserName("raja");
		user.setRoleId(1);
		user.setPassword("raja@123");
		user.setMobileNo(9030853295L);
		user.setJoiningDate(LocalDate.now());
		user.setEmail("raja@gmail.com");
		user.setCareerStartDate(LocalDate.now());

		UserDetailsDto userDetailsDto = new UserDetailsDto();
		userDetailsDto.setMessage("Reggistered successfully and allocated parking slot.");
		userDetailsDto.setStatusCode(201);


		Mockito.when(parkingRepository.findByUserId(null)).thenReturn(paList);
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);

		UserDetailsDto actualValue = userServiceImpl.register(userDto);
		assertEquals(userDetailsDto.getStatusCode(), actualValue.getStatusCode());

	}

	@Test
	public void testLogin() {
		LoginDto loginDto = new LoginDto();
		loginDto.setEmail("raja@gmail.com");
		loginDto.setPassword("raja@123");

		LoginDetailsDto loginResponseDto = new LoginDetailsDto();
		loginResponseDto.setMessage("");
		loginResponseDto.setStatusCode(200);

		Role role = new Role();
		role.setRoleId(1);
		role.setRoleType("VIP");

		List<User> users = new ArrayList<>();

		User user = new User();
		user.setUserId(1);
		user.setUserName("raja");
		user.setRoleId(1);
		user.setPassword("raja@123");
		user.setMobileNo(9030853295L);
		user.setJoiningDate(LocalDate.now());
		user.setEmail("raja@gmail.com");
		user.setCareerStartDate(LocalDate.now());
		users.add(user);
		Mockito.when(userRepository.findByemailAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(users);
		Mockito.when(roleRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(role));
		LoginDetailsDto actualValue = userServiceImpl.login(loginDto);
		assertEquals(loginResponseDto.getStatusCode(), actualValue.getStatusCode());

	}

	@Test(expected=ParkingSlotException.class)
	public void testLoginFailure() {
		LoginDto loginDto = new LoginDto();
		loginDto.setEmail("raja@gmail.com");
		loginDto.setPassword("raja@123");

		LoginDetailsDto loginResponseDto = new LoginDetailsDto();
		loginResponseDto.setMessage("");
		loginResponseDto.setStatusCode(401);


		List<User> users = new ArrayList<>();

		User user = new User();
		user.setUserId(1);
		user.setUserName("raja");
		user.setRoleId(1);
		user.setPassword("raja@123");
		user.setMobileNo(9030853295L);
		user.setJoiningDate(LocalDate.now());
		user.setEmail("raja@gmail.com");
		user.setCareerStartDate(LocalDate.now());
		users.add(user);
		Mockito.when(userRepository.findByemailAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(users);

		userServiceImpl.login(loginDto);

	}

	@Test(expected=ParkingSlotException.class)
	public void testLoginFailures() {
		LoginDto loginDto = new LoginDto();
		loginDto.setEmail("raja@gmail.com");
		loginDto.setPassword("raja@123");

		LoginDetailsDto loginResponseDto = new LoginDetailsDto();
		loginResponseDto.setMessage("");
		loginResponseDto.setStatusCode(401);


		List<User> users = new ArrayList<>();

		User user = new User();
		user.setUserId(1);
		user.setUserName("raja");
		user.setRoleId(1);
		user.setPassword("raj@123");
		user.setMobileNo(9030853295L);
		user.setJoiningDate(LocalDate.now());
		user.setEmail("raj@gmail.com");
		user.setCareerStartDate(LocalDate.now());
		users.add(user);
		Mockito.when(userRepository.findByemailAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(users);

		userServiceImpl.login(loginDto);

	}
}
