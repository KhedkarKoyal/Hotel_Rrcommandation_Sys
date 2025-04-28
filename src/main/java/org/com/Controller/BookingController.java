package org.com.Controller;

import org.com.Model.BookingModel;
import org.com.Repository.BookingRepo;
import org.com.Service.BookingHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Booking")
public class BookingController {
	@Autowired
	BookingHotel ser;
	
	@PostMapping("/Test")
	public BookingModel bookHotel(@RequestBody BookingModel request) {
	    return ser.bookHotel(request.getHotel().getId(),  
	                         request.getCheckInDate().toString(), request.getCheckOutDate().toString(), 
	                         request.getNumberOfRooms());
	}

}
	