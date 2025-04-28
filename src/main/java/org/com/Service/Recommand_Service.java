package org.com.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.com.Model.HotelModel;
import org.com.Repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class Recommand_Service {

	@Autowired
	HotelRepo repo;
	

	public List<HotelModel> getREcommandedHotel(String location, double price) {
		System.out.println("price======>"+price);
		
		double priceRange = price * 0.2;  // ±20% flexibility
        double minPrice = price - priceRange;
        double maxPrice = price + priceRange;
    	System.out.println("priceRange======>"+priceRange);
    	System.out.println("minPrice======>"+minPrice);
    	System.out.println("maxPrice======>"+maxPrice);
		return repo.findRecommendedHotels(location, minPrice, maxPrice);
		
		
		
	}
}
