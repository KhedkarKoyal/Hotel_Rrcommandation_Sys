package org.com.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false) // Creates a foreign key column
    private HotelModel hotel;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfRooms;
    private double totalPrice;

    public BookingModel() {}

    public BookingModel(HotelModel hotel, String customerName, LocalDate checkInDate, LocalDate checkOutDate, int numberOfRooms, double totalPrice) {
        this.hotel = hotel;
     //   this.customerName = customerName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfRooms = numberOfRooms;
        this.totalPrice = totalPrice;
    }
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Foreign key
    private UserModel user;


    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public HotelModel getHotel() { return hotel; }
    public void setHotel(HotelModel hotel) { this.hotel = hotel; }

//    public String getCustomerName() { return customerName; }
//    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public LocalDate getCheckInDate() { return checkInDate; }
    public void setCheckInDate(LocalDate checkInDate) { this.checkInDate = checkInDate; }

    public LocalDate getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(LocalDate checkOutDate) { this.checkOutDate = checkOutDate; }

    public int getNumberOfRooms() { return numberOfRooms; }
    public void setNumberOfRooms(int numberOfRooms) { this.numberOfRooms = numberOfRooms; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
