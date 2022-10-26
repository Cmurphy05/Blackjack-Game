import java.util.Scanner;

public class House extends GenericPlayer {
	
	Deck deck = new Deck();
	
	Scanner s = new Scanner(System.in);
	
	public House(String name) {
		this.name = name;
	}

	@Override
	public boolean isHitting(String input) {
		return false;
	}
	
	public void flipFirstCard() {
		Card grab = cardCollection.get(1);
		grab.flip(false);
	}
	
	public void flipAll() {
		for(int i = 0; i < cardCollection.size(); i++) {
			Card grab = cardCollection.get(i);
			grab.flip(true);
		}
	}

}
