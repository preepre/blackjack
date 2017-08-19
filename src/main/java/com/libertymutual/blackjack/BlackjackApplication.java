package com.libertymutual.blackjack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.libertymutual.blackjack.controllers.BlackjackController;

@SpringBootApplication
public class BlackjackApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BlackjackApplication.class, args);
		
		//BlackjackController game = new BlackjackController();
				
	}
}
