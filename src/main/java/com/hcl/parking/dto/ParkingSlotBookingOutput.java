package com.hcl.parking.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ParkingSlotBookingOutput {

	private String message;
	private Integer statusCode;
	private Integer parkingAlocationId;
	
}
