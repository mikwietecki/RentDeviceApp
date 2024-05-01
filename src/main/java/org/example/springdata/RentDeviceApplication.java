package org.example.springdata;

import org.example.springdata.components.app.ApplicationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class RentDeviceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RentDeviceApplication.class, args);
		ApplicationController controller = context.getBean(ApplicationController.class);
		controller.mainLoop();
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
}
