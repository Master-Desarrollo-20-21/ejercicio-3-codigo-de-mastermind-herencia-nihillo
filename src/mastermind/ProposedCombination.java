package mastermind;

public class ProposedCombination extends Combination {
	
	private int[] result;
	
	public ProposedCombination(String colors) {
		super(colors);
		this.result = new int[2];
	}

	public void showResult() {
		Console console = new Console();
		console.out(this.colors + " --> " + this.result[0] + " blacks, " + this.result[1] + " whites\n" );
	}

	public void setResult(int blacks, int whites) {
		this.result[0] = blacks;
		this.result[1] = whites;
	}

	public boolean isValid() {
		Console console = new Console();
		
		if (this.colors.length() != 4) {
			console.out("Wrong proposed combination length\n");
			return false;
		}
		
		for (int i = 0; i < this.colors.length(); i++) {
			if (VALID_COLORS.indexOf(this.colors.charAt(i)) == -1) {
				console.out("Wrong colors, they must be: rbygop\n");
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isWinnerResult() {
		Console console = new Console();
		if (this.result[0] == 4) {
			console.out("YOU WIN!");
			return true;
		}
		return false;
	}

}
