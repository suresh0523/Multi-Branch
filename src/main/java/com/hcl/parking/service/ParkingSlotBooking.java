package com.hcl.parking.service;

import com.hcl.parking.dto.ParkingSlotBookingInput;
import com.hcl.parking.dto.ParkingSlotBookingOutput;



public interface ParkingSlotBooking {
	

	ParkingSlotBookingOutput slotBooking(ParkingSlotBookingInput parkingSlotBookingInput);
	
	void slotBookingLock(ParkingSlotBookingInput parkingSlotBookingInput);

	

}
