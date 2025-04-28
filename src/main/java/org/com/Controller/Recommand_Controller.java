package org.com.Controller;

import org.com.Service.Recommand_Service;

import java.util.List;

import org.com.Model.HotelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommends")

public class Recommand_Controller {

	@Autowired
	Recommand_Service ser;
	
	@GetMapping("/recommend/{location}/{price}")
	public List<HotelModel> getREcommandedHotel(@PathVariable String location, @PathVariable double price)
	{
		return ser.getREcommandedHotel(location,price);
		
		
	}
}
