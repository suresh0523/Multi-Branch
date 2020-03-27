package com.hcl.parking.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/***
 * 
 * @author Anuradha
 *
 */
@Setter
@Getter
public class ReleaseSlotDto {
	private Integer userId;
	private LocalDate fromDate;
	private LocalDate toDate;


}
