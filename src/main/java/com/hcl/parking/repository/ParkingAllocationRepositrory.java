package com.hcl.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parking.entity.ParkingAllocation;

@Repository
public interface ParkingAllocationRepositrory extends JpaRepository<ParkingAllocation, Integer>{

}
