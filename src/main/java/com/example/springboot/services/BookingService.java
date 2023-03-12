package com.example.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.classes.Booking;
import com.example.springboot.repositories.BookingRepository;

@Service
public class BookingService {
	public final BookingRepository bookingRepository;
	
	@Autowired
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	public Booking addBooking(Booking booking) {
		return this.bookingRepository.save(booking);
	}
}
