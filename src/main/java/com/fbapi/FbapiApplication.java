package com.fbapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages={"com.fbapi"})
public class FbapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FbapiApplication.class, args);
	}

}
