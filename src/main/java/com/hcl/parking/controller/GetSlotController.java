package com.hcl.parking.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/***
 * 
 * @author Anuradha
 *
 */
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.ParkingDto;
import com.hcl.parking.service.GetSlotService;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class GetSlotController {	
	private static final Logger LOGGER = LoggerFactory.getLogger(GetSlotController.class);
	
	@Autowired
	GetSlotService getSlotService;
	
	@GetMapping("/slot/{userId}")
	public ResponseEntity<ParkingDto> slot(@PathVariable("userId") Integer userId) {
		LOGGER.debug("GetSlotController inside slot method !!!");
		return new ResponseEntity<>(getSlotService.slot(userId), HttpStatus.OK);
	}


}
