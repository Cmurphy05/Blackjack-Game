import java.util.Scanner;
public class BlackJackGame {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Deck deck = new Deck();
		Hand hand = new Hand();
		int numPlay = 0;
		int numPlayerPlay = 0;
		double wagerReturn;
		boolean playerBust = false;
		boolean dealerBust = false;
		boolean play = true;
		
		//rules of the game
		System.out.println("Welcome to Blackjack!");
		System.out.println();
		System.out.println("Blackjack Rules: ");
		System.out.println("	-You are dealt 2 cards face up. The dealer is dealt 2 cards with one face-up and one face-down.");
		System.out.println("	-Cards are equal to their value with face cards being 10 and an Ace being 1 or 11.");
		System.out.println("	-The players cards are added up for their total.");
		System.out.println("	-Players “Hit” to gain another card from the deck. Players “Stay” to keep their current card total.");
		System.out.println("	-Dealer “Hits” until they equal or exceed 17.");
		System.out.println("	-The goal is to have a higher card total than the dealer without going over 21.");
		System.out.println("	-If the player total equals the dealer total, it is a “Push” and the hand ends."); 
		System.out.println("	-Players win their bet if they beat the dealer. Players win 1.5x their bet if they get “Blackjack” which is 21.");
		System.out.println();
		System.out.println();
		
		//Start - player name / making the player
		System.out.println("Please, player, enter your name here: ");
		String name = scanner.nextLine();
		Player player = new Player(name);
		House dealer = new House("Dealer");
		System.out.println();
		System.out.println("Hello " + player + "! Let's get started!");

		player.getChips();
		
		while(play && player.chipValue > 0) {
			
			//Betting
			System.out.println();
			System.out.println("You start with $" + player.chipValue + " in chips.");
			System.out.println("How much would you like to bet? Please input with decimals");
			double wager = scanner.nextDouble();
			player.chipValue -= wager;
			
			//Dealer shuffles
			System.out.println();
			System.out.println("The dealer shuffles the deck.");
			deck.shuffle();
			
			//dealer gives card to player, and player is revealed their card and its value
			System.out.println();
			System.out.println("The dealer then slides you two cards face up.");
			deck.draw(player);
			deck.draw(player);
			System.out.println();
			System.out.println("Your two cards are: " + player.getHandList());
			System.out.println("Your total value in your hand is: " + player.getHandValue());
			boolean playerBlackjack = player.isBlackJack();
			
			//dealer gives himself cards and one of the cards is revealed to the player
			System.out.println();
			System.out.println("The dealer then places two cards for himself, one face up and one face down.");
			deck.draw(dealer);
			deck.draw(dealer);
			dealer.flipFirstCard();
			System.out.println();
			System.out.println("The dealer's cards are: " + dealer.getHandList());
			System.out.println("The dealer's total hand value for what you can see is: " + dealer.getHandValue());
			dealer.flipAll();
			boolean dealerBlackjack = dealer.isBlackJack();
			
			player.compareTo(dealer);
			
			//players turn - on first move, they can hit, stand, bet, or check their money
			String input;
			while(!playerBlackjack) {
				
				if(numPlayerPlay == 0) {
					System.out.println();
					System.out.println("What would you like to do? You can hit, stand, bet, or check your money.");
					input = scanner.next();
					input += scanner.nextLine();
				
				
					if(player.isHitting(input)) {
						numPlayerPlay++;
						deck.draw(player);
						System.out.println();
						System.out.println("The dealer hands you another card");
						System.out.println("Your cards are now " + player.getHandList());
						System.out.println("Your total value in your hand is: " + player.getHandValue());
						
						if(player.isBusted()) {
							playerBust = true;
							player.loss(wager);
							System.out.println();
							System.out.println("You busted.");
							break;
						}
					}
					
					else if(input.equalsIgnoreCase("stand")) {
						numPlayerPlay++;
						System.out.println();
						System.out.println("Great. It is now the dealer's move.");
						break;
					}
					
					else if(player.isBetting(input) && numPlay == 0) {
						System.out.println();
						System.out.println("How much more would you like to bet? Please input with decimals");
						wager += scanner.nextDouble();
					}
					
					else if(input.equalsIgnoreCase("check money") && numPlay == 0) {
						System.out.println();
						System.out.println("You have: $" + player.chipValue);
					}
					
					else {
						System.out.println();
						System.out.println("That is not a valid response");
					}
				
				}
				
				//on players move after their first move, they can only hit or stand
				else {
					System.out.println();
					System.out.println("What would you like to do? You can hit or stand");
					input = scanner.next();
					input += scanner.nextLine();
				
				
					if(player.isHitting(input)) {
						numPlayerPlay++;
						deck.draw(player);
						System.out.println();
						System.out.println("The dealer hands you another card");
						System.out.println("Your cards are now " + player.getHandList());
						System.out.println("Your total value in your hand is: " + player.getHandValue());
						
						if(player.isBusted()) {
							playerBust = true;
							player.loss(wager);
							System.out.println();
							System.out.println("You busted.");
							break;
						}
					}
					
					else if(input.equalsIgnoreCase("stand")) {
						numPlayerPlay++;
						System.out.println();
						System.out.println("Great. It is now the dealer's move.");
						break;
					}
					
					else {
						System.out.println();
						System.out.println("That is not a valid response");
					}
					
				}
	
			}
			
			//Dealers Turn
	//		boolean dealersTurn = true;
			System.out.println();
			System.out.println("The dealer flips his cards all faceup");
			System.out.println("The dealer's cards are: " + dealer.getHandList());
			System.out.println("The dealer's total hand value is: " + dealer.getHandValue());
			
			while(!dealerBlackjack) {
				//if the dealers cards are less than 17 the dealer will hit
				if(dealer.getHandValue() < 17) {
					deck.draw(dealer);
					System.out.println();
					System.out.println("The dealer hits");
					System.out.println();
					System.out.println("The dealer's cards are now: " + dealer.getHandList());
					System.out.println("The dealer's total hand value is: " + dealer.getHandValue());
					//if after hitting the dealers cards exceed 21 then the dealer busts
					if(dealer.isBusted()) {
						dealerBust = true;
						System.out.println();
						System.out.println("The dealer busts");
						break;
					}
				} 
				//if the dealers cards are greater than or equal to 17 then the dealer stands
				if(dealer.getHandValue() >= 17 && dealer.getHandValue() < 22) {
					System.out.println();
					System.out.println("The dealer stands");
					break;
				}
				
			}
			
			//if the player and dealer do not bust
			if(!playerBust && !dealerBust) {
				//players value is more than dealers
				if(player.compareTo(dealer) > 0) {
					wagerReturn = wager * 1.5;
					System.out.println();
					System.out.println("You win!!! You get: $" + wagerReturn);
					player.chipValue += wagerReturn;
				}
				//player and dealer have the same value cards
				else if(player.compareTo(dealer) == 0) {
					wagerReturn = wager;
					System.out.println();
					System.out.println("You and the dealer have the same value. It is a tie. Your bet is pushed back to you");
					player.chipValue += wagerReturn;
				}
				//dealers value is more than player
				else if(player.compareTo(dealer) < 0) {
					System.out.println();
					System.out.println("You lose. You lost: $" + wager);
				}
			}
			//if the player does not bust but the dealer does bust
			else if(!playerBust && dealerBust) {
				wagerReturn = wager * 1.5;
				System.out.println();
				System.out.println("You win!!! You get: $" + wagerReturn);
				player.chipValue += wagerReturn;
			}
			//if the player busts but the dealer does not bust
			else if(playerBust && !dealerBust) {
				System.out.println();
				System.out.println("You lose. You lost: $" + wager);
			}
			//if the player and the dealer bust
			else if(playerBust && dealerBust) {
				wagerReturn = wager;
				System.out.println();
				System.out.println("You and the dealer both busted. It is a tie. Your bet is pushed back to you");
				player.chipValue += wagerReturn;
			}
			
			boolean endOfGame = true;
			
			while(endOfGame) {
				
				System.out.println();
				System.out.println("Would you like to play again?");
				String playAgain = scanner.next();
				
				if(playAgain.equalsIgnoreCase("yes")) {
					player.reset();
					dealer.reset();
					numPlayerPlay = 0;
					numPlay++;
					play = true;
					System.out.println();
					System.out.println("Great let's play again!");
					break;
				}
				
				else if(playAgain.equalsIgnoreCase("no")) {
					play = false;
					System.out.println();
					System.out.println("Ok. Shutting down.");
					break;
				}
				else {
					System.out.println("That is not a valid response.");
				}
			}
		
		}
	}

}
