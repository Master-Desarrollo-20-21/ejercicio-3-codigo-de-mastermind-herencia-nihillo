package mastermind;

import java.util.Random;

public class Combination {
	protected final int COMBINATION_LENGTH = 4;
	protected final String VALID_COLORS = "rbygop";
	
	protected String colors;
	
	public Combination(String colors) {
		this.colors = colors;
	}
	
	public Combination() {
		Random random = new Random();
		String colors = "";
		
		for (int i = 0; i < COMBINATION_LENGTH; i++) {
			colors += VALID_COLORS.charAt(random.nextInt(VALID_COLORS.length()));
		}
		
		this.colors = colors;
	}
	
	public String getColors() {
		return this.colors;
	}
}
