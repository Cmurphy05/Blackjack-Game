import java.util.ArrayList;
import java.util.Scanner;

abstract public class CardCollection{
	
	protected ArrayList<Card> cardCollection;
	
	protected CardCollection(int cards) {
		this.cardCollection = new ArrayList<Card>(cards);
	}
	
	public void addCard(Card c) {
		cardCollection.add(c);
	}

	public void removeCard(Card c) {
		cardCollection.remove(c);
	}
	
}
