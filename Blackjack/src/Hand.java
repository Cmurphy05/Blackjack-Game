import java.util.ArrayList;

public class Hand extends CardCollection implements Comparable<Hand>{
	
	protected int winner;

	protected Hand() {
		super(2);
	}
	
	//checks for an ace - if there is an A in the name of the card, then there is an ace
	protected boolean checkAce() {
		String ace = "";
		for(int i=0; i<cardCollection.size(); i++) {
			ace = cardCollection.get(i).toString();
			if(ace.contains("A")) {
				return true;
			}
		}
		return false;
	}
	
	//gets the total hand value - if the total value of the hand is less than or equal to 21 and there is an ace, then the value will increase by 10 so the ace will equal 11
	public int getHandValue() {
		int totalValue = 0;
		for(int i = 0; i < cardCollection.size(); i++) {
			totalValue += cardCollection.get(i).getValue();
		}
		if(checkAce() == true && totalValue <= 11) {
			totalValue+=10;
		}
		return totalValue;
	}
	
	//checks for a blackjack - if there is an ace and if the value of a card equals 10, then blackjack is true
	public boolean isBlackJack() {
		if(getHandValue() == 21) {
			return true;
		}
		return false;
	}
	
	//get method to get the elements of Hand's cardCollection
	public String getHandList() {
		String hand = "";
			for(int i = 0; i < cardCollection.size(); i++) {
				hand = cardCollection.toString();
			}
			if(hand.length() == 0) {
				return "Hand is empty";
			}
			else {
				return hand;
			}
	}
	
	@Override
	public int compareTo(Hand o) {
		Integer thisHand = getHandValue();
		Integer otherHand = o.getHandValue();
		
		winner = thisHand.compareTo(otherHand);
		
		return winner;
	}
	

}
