import java.util.ArrayList;
import java.util.Scanner;


public class Players {

	private static ArrayList<Player> allPlayers = new ArrayList<Player>();
	private static Scanner input = new Scanner(System.in);
	private static String inputString;
	private static Integer inputInteger;
	private static boolean goodInput = false;
	
	public Players() {
		getPlayers();
		playPlayers();
	}
	
	public static void getPlayers() {
		System.out.println("How many human players will be playing: ");
		getInput();
		transformInput();
	}
	
	public static void playPlayers() {
		for (int i = 0; i < inputInteger; i++) {
			Player player = new Player();
			allPlayers.add(player);
		}
	}
	
	private static String getInput() {
		inputString = input.nextLine();
		return inputString;
	}
	
	private static Integer transformInput() {
		while (goodInput == false) {
			try {
				inputInteger = Integer.parseInt(inputString);	
				goodInput = true;
			}
			catch (Exception e) {
				System.out.println("Please enter a positive digit entry only"); 
				goodInput = false;
			}
		}
		return inputInteger;
	}
	
	public static ArrayList<Player> getAllPlayers() {
		return allPlayers;
	}
}