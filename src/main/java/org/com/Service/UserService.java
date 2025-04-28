package org.com.Service;

import org.com.Model.UserModel;
import org.com.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
	
	@Autowired 
	UserRepo repo;

	public String userRegister(String username, String email, String password, String contact) {
		if (repo.findByEmail(email).isPresent()) {
            return "Email is already registered!";
        }
		UserModel newUser = new UserModel(username, email, password, contact); // Storing password as plain text (Not recommended for production)
	        repo.save(newUser);
	        return "User registered successfully!";
	}

	 public String loginUser(String email, String password) {
	        Optional<UserModel> userOptional = repo.findByEmail(email);
	        if (userOptional.isEmpty()) {
	            return "User not found!";
	        }

	        UserModel user = userOptional.get();
	        if (!user.getPassword().equals(password)) {
	            return "Invalid credentials!";
	        }

	        return "Login successful! User ID: " + user.getId();
	    }

	public String forgotPassword(String email, String password) {
		
		 Optional<UserModel> userOptional = repo.findByEmail(email);
	        
	        if (userOptional.isPresent()) {
	            UserModel user = userOptional.get();
	            user.setPassword(password); // Hash password
	            repo.save(user);
	            return "Password updated successfully!";
	        }
	        
	        return "Email not found!";
	}

}
