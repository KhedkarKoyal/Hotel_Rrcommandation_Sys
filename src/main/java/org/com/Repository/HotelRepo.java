package org.com.Repository;

import java.util.List;

import org.com.Model.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<HotelModel,Long> {

	@Query("SELECT h FROM HotelModel h WHERE h.location LIKE CONCAT('%', :location, '%') " +
		       "AND CAST(h.price AS double) BETWEEN :minPrice AND :maxPrice  ORDER BY h.avgRating DESC")
	     List<HotelModel> findRecommendedHotels(@Param("location") String location,   @Param("minPrice") double minPrice, 
                @Param("maxPrice") double maxPrice);

	 
	 
}
