import java.util.ArrayList;
import java.util.Scanner;


public class Computers {

	private static ArrayList<Computer> allComputers = new ArrayList<Computer>();
	private static Scanner input = new Scanner(System.in);
	private static String inputString;
	private static Integer inputInteger;
	private static boolean goodInput = false;
	
	public Computers() {
		getComputers();
		playComputers();
	}
	
	public static void getComputers() {
		System.out.println("How many computer players will be playing: ");
		getInput();
		transformInput();

	}
	
	public static void playComputers() {
		for (int i = 0; i < inputInteger; i++) {
			Computer computer = new Computer();
			allComputers.add(computer);
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
	
	public static ArrayList<Computer> getAllComputers() {
		return allComputers;
	}
}