import java.util.ArrayList;
import java.util.Collections;

public class ScoreBoard {
	ArrayList<Integer> scores = new ArrayList<Integer>();
	ArrayList<Player> ap = new ArrayList<Player>();
	ArrayList<Computer> cp = new ArrayList<Computer>();
	
	public ScoreBoard() {
		loadPlayers();
		loadComputers();
		getScores();
		getWinners();
	}
	
	private ArrayList<Player> loadPlayers() {
		ap = Players.getAllPlayers();
		return ap;
	}
	private ArrayList<Computer> loadComputers() {
		cp = Computers.getAllComputers();
		return cp;
	}
	
	private ArrayList<Integer> getScores() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (ap.size() != 0) {
			for (int i = 0; i < ap.size(); i++) {
				scores.add(ap.get(i).getNumberOfGuesses());
				System.out.println("Player " + (i+1) + ": " + ap.get(i).getNumberOfGuesses());
			}
		}
		if (cp.size() != 0) {
			for (int i = 0; i < cp.size(); i++) {
				scores.add(cp.get(i).getNumberOfGuesses());
				System.out.println("Computer " + (i+1) + ": " + cp.get(i).getNumberOfGuesses());
			}
		}
		return scores;
	}
	
	private void getWinners() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < scores.size(); i++) {
			if (ap.size() != 0 && i < ap.size()) {
				if (Collections.min(scores) == ap.get(i).getNumberOfGuesses()) {
					System.out.println("Winner! Player " + (i+1) + " with a score of " + Collections.min(scores));
				}
			}
			if ((cp.size() != 0 && i >= ap.size()) || ap.size() == 0) {
				int iterator;
				if (ap.size() != 0) {
					iterator = i - ap.size();	
				}
				else {
					iterator = i;
				}
				if (Collections.min(scores) == cp.get(iterator).getNumberOfGuesses()) {
					System.out.println("Winner! Computer " + (iterator+1) + " with a score of " + Collections.min(scores));
				}
			}
		}
	}
}