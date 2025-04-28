package org.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "org.com.Repository")
@SpringBootApplication(scanBasePackages = "org.com")

public class HotelRecomApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRecomApplication.class, args);
	}

}
