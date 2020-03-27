package com.hcl.parking.service;
/***
 * @author Anuradha
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.ParkingDto;
import com.hcl.parking.entity.Parking;
import com.hcl.parking.repository.ParkingRepository;

@Service
public class GetSlotServiceImpl implements GetSlotService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GetSlotServiceImpl.class);
	
	@Autowired
	ParkingRepository parkingRepository;

	@Override
	public ParkingDto slot(Integer userId) {
		LOGGER.debug("GetSlotServiceImpl inside slot method ...");
		ParkingDto parkingDto = new ParkingDto();
		Parking parking = parkingRepository.getByUserId(userId);
		parkingDto.setParkingId(parking.getParkingId());
		parkingDto.setParkingSlot(parking.getParkingSlot());				
		return parkingDto;
	}
	

}
