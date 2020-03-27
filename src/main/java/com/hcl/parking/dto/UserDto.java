package com.hcl.parking.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDto implements Serializable{
	 
	private static final long serialVersionUID = 323036514977175050L;
	
	private String userName;
	private Long mobileNo;
	private String email;
	private String password;
	private LocalDate careerStartDate;
	private LocalDate joiningDate;

}
