package com.perscholas.twistntreats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class TwistntreatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwistntreatsApplication.class, args);
	}

@GetMapping("/welcome")  //url mapping
    public String sayHi()
	{
		return "hello world";
	}
}