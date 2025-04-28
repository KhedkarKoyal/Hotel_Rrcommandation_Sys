package org.com.Repository;

import java.util.List;

import org.com.Model.HotelModel;
import org.com.Model.HotelReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends  JpaRepository<HotelReview, Long> {
    List<HotelReview> findByHotel(HotelModel hotel);
    
    
}
