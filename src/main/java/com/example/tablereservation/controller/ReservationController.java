package com.example.tablereservation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tablereservation.model.Reservation;
import com.example.tablereservation.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	ReservationService reservationService;

	@GetMapping("/{email}")
	public ResponseEntity<?> getReservation(@PathVariable String email) {
		try {
			Reservation reservation = reservationService.getReservation(email);
			reservation.getId();
			return new ResponseEntity<>(reservation, HttpStatus.OK);
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> addReservation(@RequestBody Reservation reservation) {
		reservationService.addOrUpdateReservation(reservation);
		Map<String, Object> response = new HashMap<>();
		response.put("status", "created");
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}

	@PutMapping("/{email}")
	public ResponseEntity<?> updateReservation(@RequestBody Reservation updatedReservation,
			@PathVariable String email) {
		try {
			Reservation reservation = reservationService.getReservation(email);
			updatedReservation.setId(reservation.getId());
			reservationService.addOrUpdateReservation(updatedReservation);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{email}")
	public void deleteReservation(@PathVariable String email) {
		reservationService.deleteReservation(email);

	}

}
