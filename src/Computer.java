import java.util.ArrayList;
import java.util.Random;


public class Computer {
	private Integer minimumInteger = 1;
	private Integer maximumInteger = 100; //change back to 100
	private Integer numberOfGuesses = 1;
	private ArrayList<String> allGuesses = new ArrayList<String>();
	private boolean correctGuess = false;
	private Integer correctInteger = 0;
	private Integer inputInteger;
	
	public Computer() {
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
		System.out.println("____ ____ _  _ ___  _  _ ___ ____ ____"); 
		System.out.println("|    |  | |\\/| |__] |  |  |  |___ |__/ ");
		System.out.println("|___ |__| |  | |    |__|  |  |___ |  \\");
		System.out.println("");                                       
	}
	
	private boolean checkGuesses() {
		while (correctGuess == false) {
			computerChoice();
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
			correctGuess = false;
		}
		return correctGuess;
	}

	private Integer computerChoice(){
		Random rand = new Random();
		//clean this up and make it relatable to a difficulty level.  Level 1 = just 1 random chance?  Level 10 = 10/averaged?
		int ave;
		if (minimumInteger == maximumInteger) {
			ave = maximumInteger;
		}
		else {
			int r1 = rand.nextInt(maximumInteger - minimumInteger) +1 + minimumInteger;//2-1=1+1=2
			int r2 = rand.nextInt(maximumInteger - minimumInteger) +1 + minimumInteger;
			int r3 = rand.nextInt(maximumInteger - minimumInteger) +1 + minimumInteger;
			int r4 = rand.nextInt(maximumInteger - minimumInteger) +1 + minimumInteger;
			int r5 = rand.nextInt(maximumInteger - minimumInteger) +1 + minimumInteger;
			int r6 = rand.nextInt(maximumInteger - minimumInteger) +1 + minimumInteger;
			int r7 = rand.nextInt(maximumInteger - minimumInteger) +1 + minimumInteger;
			int r8 = rand.nextInt(maximumInteger - minimumInteger) +1 + minimumInteger;
			int r9 = rand.nextInt(maximumInteger - minimumInteger) +1 + minimumInteger;
			int r10 = rand.nextInt(maximumInteger - minimumInteger) +1 + minimumInteger;
			ave = (r1+r2+r3+r4+r5+r6+r7+r8+r9+r10)/10; 
		}
		allGuesses.add(Integer.toString(ave));
		if (numberOfGuesses == 1) {
			System.out.print("Answer: " + correctInteger +" | Guess: ");
		}
		else {
			System.out.print(", ");
		}
		try {
			Thread.sleep(900);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print(ave);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		inputInteger = ave;
		return inputInteger;
	}
	
	private Integer getRandom() {
		while (correctInteger < minimumInteger || correctInteger > maximumInteger) {
			double randomDouble = Math.random() * (maximumInteger + 1);
			correctInteger = (int) randomDouble;
		}
		return correctInteger;
	}
	
	private void completeGame() {
		System.out.println(" (Correct)");
		System.out.println("It took the Computer " + " " + numberOfGuesses.toString() + " tries.");
	}
	
	public Integer getNumberOfGuesses() {
		return numberOfGuesses;
	}
}