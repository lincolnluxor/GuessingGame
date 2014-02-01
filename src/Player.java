import java.util.ArrayList;
import java.util.Scanner;


public class Player {
	private Integer minimumInteger = 1;
	private Integer maximumInteger = 100; 
	private Integer numberOfGuesses = 1;
	private Integer correctInteger = 0;
	private ArrayList<String> allGuesses = new ArrayList<String>();
	private boolean correctGuess = false;
	private Scanner input = new Scanner(System.in);
	private String inputString;
	private Integer inputInteger;
	private boolean goodInput = false;
	
	public Player() {
		welcomeMessage();
		getRandom();
		checkGuesses();
		completeGame();
	}
	
	private void welcomeMessage() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("___  _    ____ _   _ ____ ____ ");
		System.out.println("|__] |    |__|  \\_/  |___ |__/ ");
		System.out.println("|    |___ |  |   |   |___ |  \\");
		System.out.println("");       
		System.out.println("How many human players will be playing: ");
	}
	
	private boolean checkGuesses() {
		while (correctGuess == false) {
			transformInput();
			analyzeInput();
		}
		return correctGuess;
	}
	
	private boolean analyzeInput() {
		if (inputInteger == correctInteger) {
			correctGuess = true;
		}
		else {
			if (inputInteger < correctInteger) {
				minimumInteger = inputInteger + 1;
			}
			else {
				maximumInteger = inputInteger - 1;
			}
			numberOfGuesses++;
			resetGuesses();
		}
		return correctGuess;
	}
	
	private void resetGuesses() {
		correctGuess = false;
		goodInput = false;
	}
	
	private Integer transformInput() {
		while (goodInput == false) {
			getInput();
			try {
				inputInteger = Integer.parseInt(inputString);	
				if ((inputInteger >= minimumInteger) && (inputInteger <= maximumInteger)) {
					goodInput = true;
				}
				else {
					goodInput = false;
				}
			}
			catch (Exception e) {
				System.out.println("Please enter a digit entry only"); 
				goodInput = false;
			}
		}
		return inputInteger;
	}
	
	private void guessText() {
		if (minimumInteger == maximumInteger) {
			if (inputInteger < minimumInteger) {
				System.out.print(inputString + " is too low.  ");
			}
			else {
				System.out.print(inputString + " is too high.  ");
			}
			System.out.println("Try " + maximumInteger + "!");
		}
		else if (numberOfGuesses == 1) {
			System.out.println("Guess a number between " + minimumInteger + "-" + maximumInteger);
		}
		else if (inputInteger < minimumInteger) {
			System.out.println(inputString + " is too low.  Guess between " + minimumInteger + "-" + maximumInteger);
		}
		else if (inputInteger > maximumInteger) {
			System.out.println(inputString + " is too high.  Guess between " + minimumInteger + "-" + maximumInteger);
		}
		else {
			System.out.println(inputString + " is not a number between " + minimumInteger + "-" + maximumInteger);
		}
	}
	
	private String getInput() {
		guessText();
		inputString = input.nextLine();
		allGuesses.add(inputString);
		return inputString;
	}
	
	private void completeGame() {
		System.out.println(inputInteger.toString() + " was correct!");
		System.out.println("It took you " + numberOfGuesses.toString() + " tries.");
	}
	
	private Integer getRandom() {
		while (correctInteger < minimumInteger || correctInteger > maximumInteger) {
			double randomDouble = Math.random() * (maximumInteger + 1);
			correctInteger = (int) randomDouble;
		}
		return correctInteger;
	}
	
	public Integer getNumberOfGuesses() {
		return numberOfGuesses;
	}
}