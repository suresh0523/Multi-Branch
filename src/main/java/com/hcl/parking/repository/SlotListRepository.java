package com.hcl.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parking.entity.Parking;

@Repository
public interface SlotListRepository extends JpaRepository<Parking, Integer> {

}
