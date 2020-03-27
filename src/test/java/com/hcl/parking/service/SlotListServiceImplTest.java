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

import com.hcl.parking.dto.SlotListDTO;
import com.hcl.parking.entity.Parking;
import com.hcl.parking.entity.ParkingAllocation;
import com.hcl.parking.repository.ParkingAllocationRepository;
import com.hcl.parking.repository.SlotListRepository;

@RunWith(MockitoJUnitRunner.class)
public class SlotListServiceImplTest {

	@Mock
	ParkingAllocationRepository parkingAllocationRepository;

	@Mock
	SlotListRepository parkingRepository;

	@InjectMocks
	SlotListServiceImpl slotListServiceImpl;

	@Test
	public void testGetSlotList() {

		List<ParkingAllocation> parkingAllocationList = new ArrayList<>();
		List<SlotListDTO> slotListDTO = new ArrayList<>();

		SlotListDTO slotDTO = new SlotListDTO();
		slotDTO.setParkingId(1);
		slotDTO.setParkingSlot("P1");
		slotListDTO.add(slotDTO);

		SlotListDTO slotDTO1 = new SlotListDTO();
		slotDTO1.setParkingId(2);
		slotDTO1.setParkingSlot("P2");
		slotListDTO.add(slotDTO1);

		Parking parking = new Parking();
		parking.setParkingId(1);
		parking.setParkingSlot("P1");
		parking.setUserId(1);

		ParkingAllocation parkingAllocation = new ParkingAllocation();
		parkingAllocation.setParkingId(1);
		parkingAllocation.setAvailableDate(LocalDate.now());
		parkingAllocation.setParkingAllocationId(1);
		parkingAllocationList.add(parkingAllocation);

		ParkingAllocation parkingAllocation1 = new ParkingAllocation();
		parkingAllocation1.setParkingId(2);
		parkingAllocation1.setAvailableDate(LocalDate.now());
		parkingAllocation1.setParkingAllocationId(2);
		parkingAllocationList.add(parkingAllocation1);

		Mockito.when(parkingAllocationRepository.findAll()).thenReturn(parkingAllocationList);
		Mockito.when(parkingRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(parking));

		List<SlotListDTO> actualValue = slotListServiceImpl.getSlotList();
		assertEquals(slotListDTO.size(), actualValue.size());

	}

}
