package org.com.Controller;

import java.util.Map;

import org.com.Model.UserModel;
import org.com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	UserService ser;
	
	@PostMapping("addUser")
	public  String userRegister(@RequestBody Map<String,String> request)
	{
	      String username = request.get("username");
	        String email = request.get("email");
	        String password = request.get("password");
	        String contact=request.get("contact");
			return ser.userRegister(username,email,password,contact);
	}

    @PostMapping("/login")
    public String loginUser(@RequestBody UserModel request) {
        return ser.loginUser(request.getEmail(), request.getPassword());
    }
    
    @PostMapping("/forgot")
    public String  forgotPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String newPassword = request.get("password");
    	System.out.println("email======>"+email);
    //	System.out.println("password======>"+password);
       return ser.forgotPassword(email, newPassword);    
    }
}
