import java.util.Scanner;

abstract public class GenericPlayer extends Hand {
	
	Scanner scanner = new Scanner(System.in);
	
	protected String name;
	
	protected GenericPlayer() {
	}
	
	public String getName() {
		System.out.println("What is the name of the player?");
		name = scanner.nextLine();
		return name;
	}
	
	public boolean isBusted() {
		if(getHandValue() > 21) {
			return true;
		}
		return false;
	}
	
	public void reset() {
		cardCollection.clear();
	}
	
	public void busted() {
		System.out.println("Player/Dealer Busted");
	}
	
	abstract public boolean isHitting(String input);
	
	public String toString() {
		return name;
	}
}
