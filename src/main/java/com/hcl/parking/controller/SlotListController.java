package com.hcl.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.SlotListDTO;
import com.hcl.parking.service.SlotListServiceImpl;
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class SlotListController {

	@Autowired
	SlotListServiceImpl slotListServiceImpl;

	@GetMapping("/slots")
	public ResponseEntity<List<SlotListDTO>> getsSlotList() {

		return new ResponseEntity<>(slotListServiceImpl.getSlotList(), HttpStatus.OK);
	}

}
