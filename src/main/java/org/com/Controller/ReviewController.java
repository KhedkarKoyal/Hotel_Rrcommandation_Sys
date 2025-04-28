package org.com.Controller;

import org.com.Model.HotelReview;
import org.com.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired 
	ReviewService ser;
	
	@PostMapping("/add/{hotelID}")
	public HotelReview addReview(@PathVariable Long hotelID, @RequestBody HotelReview review)
	{
		System.out.println("-------->"+review.getHotel());
		System.out.println("-------->"+review.getComment());
		return ser.addReview(hotelID,review);
		
	}
	
}
