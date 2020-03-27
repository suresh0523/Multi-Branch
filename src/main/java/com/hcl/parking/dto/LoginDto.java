package com.hcl.parking.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class LoginDto implements Serializable{
	
	private static final long serialVersionUID = -1090630144958436490L;

	private String email;
	private String password;
}
