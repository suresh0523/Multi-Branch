package com.hcl.parking.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ParkingRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer parkingRequestId;
	private Integer userId;
	private LocalDate requestedDate;
	private String status;
}
