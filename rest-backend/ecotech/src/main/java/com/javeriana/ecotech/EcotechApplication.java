package com.javeriana.ecotech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javeriana.ecotech.integration.MongoConnection;

@SpringBootApplication
public class EcotechApplication {

	public static void main(String[] args) {
		new MongoConnection();
		SpringApplication.run(EcotechApplication.class, args);
	}

}
