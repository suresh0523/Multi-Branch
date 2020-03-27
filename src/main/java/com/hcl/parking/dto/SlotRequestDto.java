package com.hcl.parking.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SlotRequestDto implements Serializable{

	private static final long serialVersionUID = 8577503193568661417L;
	
	private Integer userId;		
	private LocalDate requestedDate;	
}
