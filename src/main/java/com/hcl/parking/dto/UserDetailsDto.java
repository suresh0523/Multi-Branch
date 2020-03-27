package com.hcl.parking.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDetailsDto implements Serializable{
	
	private static final long serialVersionUID = -186872080224824580L;
	
	private Integer statusCode;
	private String message;

}
