package com.libertymutual.blackjack.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.blackjack.models.AceCard;
import com.libertymutual.blackjack.models.Card;
import com.libertymutual.blackjack.models.Deck;
import com.libertymutual.blackjack.models.FaceCard;
import com.libertymutual.blackjack.models.Hand;
import com.libertymutual.blackjack.models.NumberCard;
import com.libertymutual.blackjack.models.Participant;
import com.libertymutual.blackjack.models.Wallet;



@Controller
@RequestMapping("/")
public class BlackjackController { // game
	
	private Stack<Deck> deckOfCards;
	private Stack<Card> cardHistory;
	
	private Participant player;
	private Participant dealer;
	public Model model;
	
	private static Wallet wallet;
	private Wallet bank;
	public BlackjackController() { // Constructor	
		
	}
	
	@GetMapping("") 
	public String newGame(Model model) {
			
		Hand hand = new Hand();
		hand.addCard(new FaceCard("K", "Spades"));
//		hand.addCard(new NumberCard(4, "Clubs"));
//		hand.addCard(new AceCard("Diamonds"));
//		
		System.out.println(hand.getCards());
		
		deckOfCards = new Stack<Deck>();
		cardHistory = new Stack<Card>();
		
		Wallet wallet = new Wallet();
		Wallet bank = new Wallet();
		
		player = new Participant(wallet);
		System.out.println("Welcome to the game, Priya");
		
		dealer = new Participant(bank);
		System.out.println("The dealer has joined the game");
		
		//Participant player = new Participant();
		//System.out.println();
		
		model.addAttribute("hand", hand);
		model.addAttribute("wallet", wallet.getTotalMoney());
		
		
		return "blackjack/index";
	}
	
	@PostMapping("/game")
	public String betValue(Model model) {
		model.addAttribute("wallet", wallet.getTotalMoney());
		//System.out.println(wallet.getTotalMoney());
		
		return "blackjack/game";
		
	}
	
	@PostMapping("/hit")
	public String hitHand() {
		//we used the same name (num) as the name from the input type field in the form
		
		return "blackjack/game";
		
	}
	
	@PostMapping("/endGame")
	public String endGame() {
		//we used the same name (num) as the name from the input type field in the form
		
		return "blackjack/result";
		
	}
	
	@PostMapping("/startNewGame")
	public String startNewGame() {
		//we used the same name (num) as the name from the input type field in the form
		
		return "redirect:/";
		
	}

	@PostMapping("/stand")
	public String standHand() {
		//we used the same name (num) as the name from the input type field in the form
		
		return "blackjack/game";
		
	}
	

	


}
