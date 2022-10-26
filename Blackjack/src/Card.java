import java.util.Scanner;

public class Card {
	
	private String name;
	private int cardValue;
	private boolean faceUp;
	
	public Card(String name, int cardValue, boolean faceUp) {
		this.name = name;
		this.cardValue = cardValue;
		this.faceUp = faceUp;
	}
	
	public String toString() {
		if(faceUp == true) {
			return name;
		}
		else {
			return "XX";
		}
	}
	
	public int getValue() {
		if(faceUp == true) {
		return cardValue;
		}
		else {
			return 0;
		}
	}
	
	public boolean isFaceUp() {
		if(faceUp == false) {
		return false;
		}
		else {
			return true;
		}
	}
	
	public void flip(boolean flip) {
		this.faceUp = flip;
	}
}
