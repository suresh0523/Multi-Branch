package com.hcl.parking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.SlotListDTO;
import com.hcl.parking.entity.Parking;
import com.hcl.parking.entity.ParkingAllocation;
import com.hcl.parking.repository.ParkingAllocationRepository;
import com.hcl.parking.repository.SlotListRepository;

@Service
public class SlotListServiceImpl implements SlotListService {

	@Autowired
	ParkingAllocationRepository parkingAllocationRepository;

	@Autowired
	SlotListRepository parkingRepository;

	@Override
	public List<SlotListDTO> getSlotList() {

		List<SlotListDTO> slotListDTO = new ArrayList<>();
		SlotListDTO slotDTO = null;
		LocalDate availableDate = LocalDate.now();

		List<ParkingAllocation> parkingAllocationList = parkingAllocationRepository.findAll();
		
		parkingAllocationList.stream().filter(s->s.getUserId()==(null)).collect(Collectors.toList());


		for (ParkingAllocation parkingAllocation : parkingAllocationList) {
			slotDTO = new SlotListDTO();
			if (parkingAllocation.getAvailableDate().equals(availableDate)) {
				Integer parkingId = parkingAllocation.getParkingId();

				Optional<Parking> optParking = parkingRepository.findById(parkingId);
				if (optParking.isPresent()) {
					Parking parking = optParking.get();
					slotDTO.setParkingId(parking.getParkingId());
					slotDTO.setParkingSlot(parking.getParkingSlot());
					slotListDTO.add(slotDTO);
				}

			}

		}

		return slotListDTO;
	}

}
