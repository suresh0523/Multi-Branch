package com.hcl.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.parking.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByRoleId(Integer roleId);

}
