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

import com.hcl.parking.dto.ReleaseSlotDto;
import com.hcl.parking.dto.ResponseDto;
import com.hcl.parking.service.ReleaseSlotService;

/***
 * 
 * @author Anuradha
 *
 */
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class ReleaseSlotController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReleaseSlotController.class);

	@Autowired
	ReleaseSlotService releaseSlotService;
	/***
	 * releaseSlot method to release slot by VIP user. 
	 * @param releaseSlotDto (userId,fromDate,toDate)
	 * @return responseDto (statusCode, message)
	 */
	@PostMapping("/releaseSlot")
	public ResponseEntity<ResponseDto> releaseSlot(@RequestBody ReleaseSlotDto releaseSlotDto) {
		LOGGER.debug("ReleaseSlotController inside releaseSlot  !!!");
		return new ResponseEntity<>(releaseSlotService.releaseSlot(releaseSlotDto), HttpStatus.OK);
	}

}
