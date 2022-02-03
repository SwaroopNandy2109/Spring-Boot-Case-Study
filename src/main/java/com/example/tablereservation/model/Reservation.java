package com.example.tablereservation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private int peopleCount;
	private String date;
	private String time;
	
	public Reservation() {}

	public Reservation(int id, String name, String email, int peopleCount, String date, String time) {
		this.id = id;
		this.setName(name);
		this.setEmail(email);
		this.setPeopleCount(peopleCount);
		this.setDate(date);
		this.setTime(time);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", name=" + name + ", email=" + email + ", peopleCount=" + peopleCount
				+ ", date=" + date + ", time=" + time + "]";
	}


}
