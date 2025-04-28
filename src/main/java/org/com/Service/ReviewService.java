package org.com.Service;

import org.com.Model.HotelModel;
import org.com.Model.HotelReview;
import org.com.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class ReviewService {
	
	@Autowired
	ReviewRepository repo;
	
	@Autowired
	HotelService  ser;

	HotelReview rev;
	public HotelReview addReview(Long hotelID, HotelReview review) {
		HotelModel hotel=ser.getHotelById(hotelID);
		System.out.println("-------->"+review.getComment());
		System.out.println("-------->"+hotel);
		if(hotel !=null)
		{
			System.out.println("yes------>");
			review.setHotel(hotel);
			 rev =repo.save(review);
			ser.updateHotelRating(hotelID);
			return rev;
		}
		return rev;
	}
	

}
