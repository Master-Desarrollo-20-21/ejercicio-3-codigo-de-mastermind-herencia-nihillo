package mastermind;

public class SecretCombination extends Combination {
	
	public SecretCombination(String colors) {
		super(colors);
	}
	
	public SecretCombination() {
		super();
	}

	public void provideResult(ProposedCombination attempt) {
		int blacks = 0;
		int whites = 0;
		boolean[] flags = {false, false, false, false};
		
		for (int i = 0; i < attempt.colors.length(); i++) {
			if (attempt.colors.charAt(i) == this.colors.charAt(i)) {
				blacks++;
				flags[i] = true;
			} else {
				for (int j = 0; j < this.colors.length(); j++) {
					if (!flags[j] && attempt.colors.charAt(i) == this.colors.charAt(j)) {
						whites++;
						flags[j] = true;
					}
				}
			}
		}
		
		attempt.setResult(blacks, whites);
	}

	public String obfuscated() {
		String obfuscated = "";
		do {
			obfuscated += "x";
		} while (obfuscated.length() < this.getColors().length());
		return obfuscated;
	}
	
	public static void main(String[] args) {
		SecretCombination secret = new SecretCombination("abcd");
		ProposedCombination proposed = new ProposedCombination("abde");
		
		secret.provideResult(proposed);
		proposed.showResult();
	}
}
