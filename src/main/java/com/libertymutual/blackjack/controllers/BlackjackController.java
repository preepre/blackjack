package com.libertymutual.blackjack.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.blackjack.models.AceCard;
import com.libertymutual.blackjack.models.Card;
import com.libertymutual.blackjack.models.Deck;
import com.libertymutual.blackjack.models.FaceCard;
import com.libertymutual.blackjack.models.Game;
import com.libertymutual.blackjack.models.Hand;
import com.libertymutual.blackjack.models.NumberCard;
import com.libertymutual.blackjack.models.Participant;
import com.libertymutual.blackjack.models.Wallet;



@Controller
@RequestMapping("/")
public class BlackjackController { // game
	
	private Stack<Deck> deckOfCards = new Stack<Deck>();
	private Stack<Card> cardHistory = new Stack<Card>();
	
	private Deck deck = new Deck();
	
	private Wallet wallet = new Wallet();
	private Wallet bank = new Wallet();
	
	private int betAmount = 0;
	
	private Hand hand = new Hand();
	private Hand dealerHand = new Hand();
	
	private Participant player = new Participant(wallet, hand);	
	private Participant dealer = new Participant(bank, hand);

	//private int playerWon = 1;
	private int totalPayout;
	private Game game = new Game();
	
	private int checkPlayerSums[];
	private int checkDealerSums[];
	
	int finalPayout = 0;
	
	//private int valueBet = 0;
	
	public BlackjackController() { 
		
		
	}
	
	@GetMapping("") 
	public String newGame(Model model) {
		
		deck.shuffle();
		
		model.addAttribute("wallet", wallet.getTotalMoney());
		
		return "blackjack/index";
	}
	
	@PostMapping("/bet")
	public String betValue(Model model, @RequestParam(name = "betAmount") int betValue) {
		
		betAmount = betValue;
		
		
		if (wallet.getTotalMoney() > 0 && betAmount > 0 && wallet.getTotalMoney() > betAmount) {

			model.addAttribute("wallet", wallet.betAmount(betAmount));
			model.addAttribute("hand", hand);
			model.addAttribute("dealerHand", dealerHand);
			model.addAttribute("betAmount", betAmount);
			
			
			hand.addCard(deck.getCard());
			hand.addCard(deck.getCard());
			
			dealerHand.addCard(deck.getCard());
			dealerHand.addCard(deck.getCard());

			return "blackjack/game";
		}
		
		//totalPayout = game.finalPayout(checkPlayerSums[0], checkPlayerSums[1], checkDealerSums[0], checkDealerSums[1], betAmount);
		//model.addAttribute("totalPayout", wallet.getTotalMoney() + totalPayout );
		
		
		return "blackjack/result";
		
	}
	
	@PostMapping("/hit")
	public String hitHand(Model model) {

		model.addAttribute("wallet", wallet.getTotalMoney());
		model.addAttribute("hand", hand);
		model.addAttribute("dealerHand", dealerHand);
		model.addAttribute("betAmount", betAmount);
		
		Card newCard = deck.getCard();
		
		if(newCard != null) {
			hand.addCard(newCard);	

		}
		
		if (hand.isBust()) {
			finalPayout = game.finalPayout(hand, dealerHand, betAmount);

		
			model.addAttribute("finalPayout", wallet.won(finalPayout));
			model.addAttribute("wallet", wallet.betAmount(finalPayout));
			return "blackjack/result";
		}
		
		
		return "blackjack/game";
		

		
	}
	
	@PostMapping("/stand")
	public String standHand(Model model) {

		model.addAttribute("wallet", wallet.getTotalMoney());
		model.addAttribute("hand", hand);
		model.addAttribute("dealerHand", dealerHand);
		model.addAttribute("betAmount", betAmount);
		
		int[] checkDealerSums = dealerHand.getValues();
		
		while( (checkDealerSums[0] > 21 && checkDealerSums[1] <= 16)
				|| (checkDealerSums[1] > 21 && checkDealerSums[0] <= 16)
				|| (checkDealerSums[0] <= 16 && checkDealerSums[1] <= 16))
		{
			Card dealerNewCard = deck.getCard();
			
			if (dealerNewCard != null) {
				dealerHand.addCard(dealerNewCard);
			}
			checkDealerSums = dealerHand.getValues();	
		}
		
//		totalPayout = game.finalPayout(checkPlayerSums[0], checkPlayerSums[1], checkDealerSums[0], checkDealerSums[1], betAmount);
//		model.addAttribute("totalPayout", wallet.getTotalMoney() + totalPayout );	
		finalPayout = game.finalPayout(hand, dealerHand, betAmount);

		model.addAttribute("finalPayout", wallet.won(finalPayout));
		model.addAttribute("wallet", wallet.betAmount(finalPayout));
		
				
		return "blackjack/result"; 
		 
	}
	
	@PostMapping("/endGame")
	public String endGame(Model model) {
		
		model.addAttribute("wallet", wallet.getTotalMoney());
		model.addAttribute("hand", hand);
		model.addAttribute("dealerHand", dealerHand);
		model.addAttribute("betAmount", betAmount);
		finalPayout = game.finalPayout(hand, dealerHand, betAmount);

		model.addAttribute("finalPayout", wallet.won(finalPayout));
		model.addAttribute("wallet", wallet.betAmount(finalPayout));
		//totalPayout = game.finalPayout(checkPlayerSums[0], checkPlayerSums[1], checkDealerSums[0], checkDealerSums[1], betAmount);
		//model.addAttribute("totalPayout", wallet.getTotalMoney() + totalPayout );
		
		
		wallet.clear();
		deck = new Deck();
		deck.shuffle();
		
		wallet = new Wallet();
		bank = new Wallet();
		
		hand = new Hand();
		dealerHand = new Hand();
		
		player = new Participant(wallet, hand);	
		dealer = new Participant(bank, dealerHand);
		betAmount = 0;
		finalPayout = 0;
					

		return "blackjack/result";
		
	}
	
	@PostMapping("/startNewGame")
	public String startNewGame() {

		wallet.clear();
		deck = new Deck();
		deck.shuffle();
		
		wallet = new Wallet();
		bank = new Wallet();
		
		hand = new Hand();
		dealerHand = new Hand();
		
		player = new Participant(wallet, hand);	
		dealer = new Participant(bank, dealerHand);
		
		betAmount = 0;
		finalPayout = 0;
		
		
				
		return "redirect:/";
		
	}	



}