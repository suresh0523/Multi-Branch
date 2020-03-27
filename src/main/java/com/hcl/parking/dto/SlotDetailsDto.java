package com.hcl.parking.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class SlotDetailsDto implements Serializable{
	
	private static final long serialVersionUID = 3556046750942569706L;
	
	private String message;
	private Integer statusCode;
}
