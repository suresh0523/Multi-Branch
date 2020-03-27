package com.hcl.parking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;
	private String roleType;

}
