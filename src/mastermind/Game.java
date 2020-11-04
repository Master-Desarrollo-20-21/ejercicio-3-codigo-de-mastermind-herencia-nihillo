package mastermind;

public class Game {
	private final int MAX_ATTEMPTS = 10;
	
	private ProposedCombination[] attempts;
	private int attemptsNumber;
	private SecretCombination secretCombination;
		
	public Game() {
		this.attempts = new ProposedCombination[MAX_ATTEMPTS];
		this.attemptsNumber = 0;
		this.secretCombination = new SecretCombination();
	}

	public void play() {
		Console console = new Console();
		do {
			console.out(attemptsNumber + " attempt(s)\n");
			console.out(this.secretCombination.obfuscated() + "\n");
			if (attemptsNumber > 0) {
				for (int i = 0; i < attemptsNumber; i++) {
					attempts[i].showResult();
				}
			}
			this.nextAttempt();
		} while (!this.isEndGame());
	}

	private boolean isEndGame() {
		return this.attempts[this.attemptsNumber - 1].isWinnerResult()
			|| this.isFinishedAttempts();
	}

	private boolean isFinishedAttempts() {
		if (this.attemptsNumber >= MAX_ATTEMPTS) {
			Console console = new Console();
			console.out("YOU LOSE");
			return true;
		}
		return false;
	}

	private void nextAttempt() {
		ProposedCombination nextAttempt;
		Console console = new Console();
		
		do {
			nextAttempt = new ProposedCombination(console.readString("Propose a combination: \n")); 
		} while (!nextAttempt.isValid());
		
		this.attempts[this.attemptsNumber] = nextAttempt;
		this.attemptsNumber++;
		this.secretCombination.provideResult(nextAttempt);
	}
	
	
}
