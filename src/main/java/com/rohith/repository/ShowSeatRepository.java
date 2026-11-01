package com.rohith.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohith.entity.ShowSeat;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
	List<ShowSeat> findByShowId(Long showId);

}
