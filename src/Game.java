public class Game {
	
	public Game() {
		System.out.println("Welcome to the guessing game!");
		Players.getPlayers();
		Computers.getComputers();
		Players.playPlayers();
		Computers.playComputers();
		new ScoreBoard();
	}

	public static void main(String[] args) {
		new Game();
	}
}