package com.hcl.parking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parking.entity.ParkingAllocation;

@Repository
public interface ParkingAllocationRepository extends JpaRepository<ParkingAllocation, Integer> {

	public List<ParkingAllocation> findByUserIdAndAvailableDate(Integer userId, LocalDate dates);

	List<ParkingAllocation> findByParkingIdAndAvailableDate(Integer parkingid, LocalDate availableDate);

}
