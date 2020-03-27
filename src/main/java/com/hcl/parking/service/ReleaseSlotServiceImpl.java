package com.hcl.parking.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.ReleaseSlotDto;
import com.hcl.parking.dto.ResponseDto;
import com.hcl.parking.entity.Parking;
import com.hcl.parking.entity.ParkingAllocation;
import com.hcl.parking.exception.ParkingSlotException;
import com.hcl.parking.repository.ParkingAllocationRepositrory;
import com.hcl.parking.repository.ParkingRepository;

/***
 * 
 * @author Anuradha
 *
 */
@Service
public class ReleaseSlotServiceImpl implements ReleaseSlotService {

	public static final Logger LOGGER = LoggerFactory.getLogger(ReleaseSlotServiceImpl.class);

	@Autowired
	ParkingRepository parkingRepository;

	@Autowired
	ParkingAllocationRepositrory parkingAllocationRepositrory;

	/***
	 * releaseSlot method to release slot by VIP user.
	 * 
	 * @param releaseSlotDto (userId,fromDate,toDate)
	 * @return responseDto (statusCode, message)
	 */
	@Override
	public ResponseDto releaseSlot(ReleaseSlotDto releaseSlotDto) {
		LOGGER.debug("ReleaseSlotServiceImpl inside releaseSlot method...");

		// iterate the freedates fromDate to toDate
		long numOfDaysBetween = ChronoUnit.DAYS.between(releaseSlotDto.getFromDate(), releaseSlotDto.getToDate());
		List<LocalDate> freeDates = IntStream.iterate(0, i -> i + 1).limit(numOfDaysBetween)
				.mapToObj(i -> releaseSlotDto.getFromDate().plusDays(i)).collect(Collectors.toList());

		List<Parking> parkings = parkingRepository.findByUserId(releaseSlotDto.getUserId());

		if (parkings.isEmpty())
			throw new ParkingSlotException("parking does not exist");
		List<ParkingAllocation> parkingAllocationList = new ArrayList<>();

		for (LocalDate freeDate : freeDates) {
			
			ParkingAllocation parkingAllocation = new ParkingAllocation();
			parkingAllocation.setAvailableDate(freeDate);
			parkingAllocation.setParkingId(parkings.get(0).getParkingId());
			parkingAllocationList.add(parkingAllocation);
		}
		parkingAllocationRepositrory.saveAll(parkingAllocationList);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("Released Slot");
		responseDto.setStatusCode(HttpStatus.OK.value());

		return responseDto;
	}

}
