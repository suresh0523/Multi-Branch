package com.hcl.parking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parking.entity.Parking;
@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {
	
	List<Parking> findByUserId(Integer userid);
	Parking getByUserId(Integer userId);

}
