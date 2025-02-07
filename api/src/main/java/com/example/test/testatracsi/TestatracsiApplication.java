package com.example.test.testatracsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class TestatracsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestatracsiApplication.class, args);
	}

	@GetMapping("/")
	public String home(){
		return "api version 0.0.1";
	}
	
	@GetMapping("/test")
	public String home1(){
		return "este es el endpoint nuevo";
	}
	
	@GetMapping("/test2")
	public String home2(){
		return "otro endpoint";
	}


}
