package com.rohith.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohith.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}
