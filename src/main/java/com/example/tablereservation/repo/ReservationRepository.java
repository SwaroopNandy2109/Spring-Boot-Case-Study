package com.example.tablereservation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tablereservation.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	Reservation findByEmail(String email);

	void deleteByEmail(String email);
}
