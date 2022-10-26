import java.util.ArrayList;
import java.util.Scanner;

public class Player extends GenericPlayer{
	
	public double chipValue;
	private double wager;
	
	private Scanner scanner = new Scanner(System.in);
	
	
	public Player(String name) {
		this.name = name;
	}
	
	public void win(double wager) {
		this.wager = wager;
		System.out.println(name + " won!");
		chipValue += wager;
	}
	
	public void loss(double wager) {
		this.wager = wager;
//		System.out.println(name + " lost");
		chipValue -= wager;
	}
	
	public void getChips() {
		chipValue += 500.00;
	}
	
	private void chipsUpdate(double mod) {

	}
 	
	public boolean isBetting(String input) {
		
		String answer = input;
		
		if(answer.equalsIgnoreCase("bet")) {
			return true;
		}
		return false;
	}
	
	public boolean isHitting(String input) {
		
		String answer = input;
		
		if(answer.equalsIgnoreCase("hit")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
