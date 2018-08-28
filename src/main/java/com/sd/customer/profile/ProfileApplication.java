package com.sd.customer.profile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sd.customer.profile.dao.ProfileRepository;
import com.sd.customer.profile.model.CustomerProfile;

@SpringBootApplication
public class ProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(ProfileRepository domainRepository) {
		CustomerProfile obj = domainRepository.findByMobileNo(918472711617L);
		System.out.println(obj);
		return null;
	}
}
