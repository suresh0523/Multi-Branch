package com.hcl.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parking.entity.ParkingRequest;

@Repository
public interface ParkingRequestRepository extends JpaRepository<ParkingRequest, Integer>{

	List<ParkingRequest> findByUserId(Integer userId);

}
