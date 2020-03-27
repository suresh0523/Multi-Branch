package com.hcl.parking.service;

import com.hcl.parking.dto.ParkingDto;

public interface GetSlotService {
	
	ParkingDto slot(Integer userId);

}
