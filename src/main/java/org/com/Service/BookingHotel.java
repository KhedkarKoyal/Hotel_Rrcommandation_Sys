package org.com.Service;

import org.com.Model.BookingModel;
import org.com.Model.HotelModel;
import org.com.Repository.BookingRepo;
import org.com.Repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.time.LocalDate;
@Service
public class BookingHotel {

	@Autowired 
	BookingRepo repo;
	
	@Autowired 
	HotelService repoo;
	
	
	public BookingModel bookHotel(long hotelId, String checkInDate, String checkOutDate,
			int numberOfRooms) {
		LocalDate checkInDate1 = LocalDate.parse(checkInDate);
		LocalDate checkOutDate1 = LocalDate.parse(checkOutDate);

		long numberOfDays = ChronoUnit.DAYS.between(checkInDate1, checkOutDate1);
        System.out.println("Number of days: " + numberOfDays);

        Optional<HotelModel> hotelOptional = Optional.ofNullable(repoo.getHotelById(hotelId));
        if (hotelOptional.isEmpty()) {
            throw new IllegalArgumentException("Hotel not found with ID: " + hotelId);
        }

        HotelModel hotel = hotelOptional.get();

        BookingModel booking = new BookingModel();
        booking.setHotel(hotel);
     
        booking.setCheckInDate(checkInDate1);
        booking.setCheckOutDate(checkOutDate1);
        booking.setNumberOfRooms(numberOfRooms);
        // booking.setTotalPrice(totalPrice);

        // Save booking to the database
        return repo.save(booking);
	
	}

}
