package com.sr.redbluepersonalitytest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class RbPersonalityTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbPersonalityTestApplication.class, args);
	}
	@GetMapping	
	public String hello(){
		return "index";
	}
}
