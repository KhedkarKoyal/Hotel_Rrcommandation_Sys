package org.com.Model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Component
@Entity
@Table(name = "hotels") // Optional: Specifies the table name
public class HotelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private double price;
    private double avgRating;  

    private int acRoom;
    private int nonAcRoom;

    // ✅ Correct placement of @OneToMany annotation
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<HotelReview> reviews;

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public List<HotelReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<HotelReview> reviews) {
        this.reviews = reviews;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAcRoom() {
        return acRoom;
    }

    public void setAcRoom(int acRoom) {
        this.acRoom = acRoom;
    }

    public int getNonAcRoom() {
        return nonAcRoom;
    }

    public void setNonAcRoom(int nonAcRoom) {
        this.nonAcRoom = nonAcRoom;
    }
}
