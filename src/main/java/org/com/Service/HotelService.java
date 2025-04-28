package org.com.Service;

import java.util.List;

import org.com.Model.HotelModel;
import org.com.Model.HotelReview;
import org.com.Repository.HotelRepo;
import org.com.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

	@Autowired
	HotelRepo repo;
	
	@Autowired
	ReviewRepository revi;

	public HotelModel addHotel(HotelModel model) {
		return repo.save(model);
	}

	public HotelModel getHotelById(long id) {
		
		return repo.findById(id).orElse(null);
	}

	public String deleteHotel(Long id) {
		  java.util.Optional<HotelModel> categoryOptional = repo.findById(id);
		    if (categoryOptional.isPresent()) {
		        repo.deleteById(id);
		        return "Category with ID " + id + " has been deleted successfully.";
		    } else {
		        return "Category with ID " + id + " not found.";
		    }
	}
	

    public void updateHotelRating(Long hotelId) {
        HotelModel hotel = getHotelById(hotelId);
        if (hotel != null) {
            List<HotelReview> reviews = revi.findByHotel(hotel);
            if (!reviews.isEmpty()) {
                double avgRating = reviews.stream().mapToDouble(HotelReview::getRating).average().orElse(0);
                hotel.setAvgRating(avgRating);
                repo.save(hotel);
            }
        }
    }

    public List<HotelModel> getAllHotels() {
        return repo.findAll();
    }
}
