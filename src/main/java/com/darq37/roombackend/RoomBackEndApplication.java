package com.darq37.roombackend;

import com.darq37.roombackend.domain.User;
import com.darq37.roombackend.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class RoomBackEndApplication{

	public static void main(String[] args) {
		SpringApplication.run(RoomBackEndApplication.class, args);
	}


}
