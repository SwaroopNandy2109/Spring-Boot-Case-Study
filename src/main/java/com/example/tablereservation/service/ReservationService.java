package com.example.tablereservation.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tablereservation.model.Reservation;
import com.example.tablereservation.repo.ReservationRepository;

@Service
@Transactional
public class ReservationService {

	@Autowired
	private ReservationRepository repository;

	public Reservation getReservation(String email) {
		return repository.findByEmail(email);
	}

	public void addOrUpdateReservation(Reservation reservation) {
		repository.save(reservation);
	}

	public void deleteReservation(String email) {
		repository.deleteByEmail(email);
	}
}
