package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.ParkingSlotBookingInput;
import com.hcl.parking.dto.ParkingSlotBookingOutput;
import com.hcl.parking.service.ParkingSlotBooking;
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class ParkingSlotBookingController {

	@Autowired
	ParkingSlotBooking parkingSlotBooking;

	@PostMapping("/booking")
	public ResponseEntity<ParkingSlotBookingOutput> slotBooking(
			@RequestBody ParkingSlotBookingInput parkingSlotBookingInput) {
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingSlotBooking.slotBooking(parkingSlotBookingInput));
	}
}
