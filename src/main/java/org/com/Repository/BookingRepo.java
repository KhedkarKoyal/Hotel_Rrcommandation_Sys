package org.com.Repository;

import org.com.Model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<BookingModel, Long> {
}