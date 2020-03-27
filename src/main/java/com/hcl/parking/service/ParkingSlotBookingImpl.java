package com.hcl.parking.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.ParkingSlotBookingInput;
import com.hcl.parking.dto.ParkingSlotBookingOutput;
import com.hcl.parking.entity.ParkingAllocation;
import com.hcl.parking.exception.ParkingSlotException;
import com.hcl.parking.repository.ParkingAllocationRepository;

@Service
public class ParkingSlotBookingImpl implements ParkingSlotBooking {

	@Autowired
	ParkingAllocationRepository parkingAllocationRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ParkingSlotBookingImpl.class);


	@Override
	public ParkingSlotBookingOutput slotBooking(ParkingSlotBookingInput parkingSlotBookingInput) {

		List<ParkingAllocation> parkingAllocation = parkingAllocationRepository
				.findByParkingIdAndAvailableDate(parkingSlotBookingInput.getParkingId(), LocalDate.now());
		
		logger.info("present date localDate:{}",LocalDate.now());

		if (parkingAllocation.isEmpty())
			throw new ParkingSlotException("no availabe slots");

		parkingAllocation.get(0).setUserId(parkingSlotBookingInput.getUserId());
		parkingAllocationRepository.save(parkingAllocation.get(0));

		ParkingSlotBookingOutput parkingSlotBookingOutput = new ParkingSlotBookingOutput();

		parkingSlotBookingOutput.setMessage("allocated succsessfully");
		parkingSlotBookingOutput.setParkingAlocationId(parkingAllocation.get(0).getParkingAllocationId());
		parkingSlotBookingOutput.setStatusCode(HttpStatus.CREATED.value());

		return parkingSlotBookingOutput;
	}

	@Override
	public void slotBookingLock(ParkingSlotBookingInput parkingSlotBookingInput) {


		
		
	}
	
	

}
