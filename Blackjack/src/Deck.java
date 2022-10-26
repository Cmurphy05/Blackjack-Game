import java.util.ArrayList;
import java.util.Collections;

public class Deck extends CardCollection{
	
	Hand hand = new Hand();
	
	protected Deck() {
		super(52);
	}
	
	//adds all 52 cards to the Deck's cardCollection
	private void populateDeck() {

		cardCollection.clear();
		
		String[] suit = {"S", "C", "D", "H"};
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
		String[] names = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		
		for(String suits : suit) {
			for(int i = 0; i < 13; i++) {
				addCard(new Card(suits+names[i], values[i], false));
			}
		}
	}

	//get method to return the numerical size of the ArrayList
	public int getSize() {
		return cardCollection.size();
	}
	
	//Doesn't actually shuffle the deck - only repopulate's the deck
	public void shuffle() {
		populateDeck();
	}
	
	//grabs a random card and removes it from deck's cardCollection, then adds it to hand's cardCollection - does this twice
	public void draw(Hand h) {
		Card grab = cardCollection.get((int) (Math.random() * cardCollection.size()));
		removeCard(grab);
		grab.flip(true);
		h.addCard(grab);
	}
	
	//remove method when done - gets the deck's cardCollection and uses toString to print
	public String getList() {
		String list = "";
		for(int i = 0; i < cardCollection.size(); i++) {
			list = cardCollection.toString();
		}
		return list;
	}
	
	
}
