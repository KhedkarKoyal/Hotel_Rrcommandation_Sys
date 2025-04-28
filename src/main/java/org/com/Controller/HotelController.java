package org.com.Controller;

import java.util.List;

import org.com.Model.HotelModel;
import org.com.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	HotelService ser;
	
	@Autowired
	HotelModel model;
	
	 @GetMapping("/getHotels")
	    public List<HotelModel> getAllHotels() {
	        return ser.getAllHotels();
	    }
	 
	@PostMapping("/addHotel")
	public HotelModel addHotel(@RequestBody HotelModel model)
	{
		System.out.println("=======>"+model.getName());
		return ser.addHotel(model);
	}
	
	@GetMapping("/gethotel/{id}")
	public HotelModel getHotelById(@PathVariable long id)
	{
		return ser.getHotelById(id);
		
	}
	
	@DeleteMapping
	public String  deleteHotel(@PathVariable long id) {
		 return ser.deleteHotel(id); 
	}
	
	
	
}
