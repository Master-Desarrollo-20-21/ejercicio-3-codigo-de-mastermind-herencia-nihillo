public class Mastermind { 

  private Game game; 

  public Mastermind(){ 
    this.game = new Game(); 
  } 

  private void play() { 
    do { 
      this.game.play(); 
    } while(this.isResumed()); 
  } 

  private boolean isResumed() { 
    String answer; 
    Console console = new Console(); 
    do { 
      answer = console.readString("¿Quieres continuar? (s/n): "); 
    } while (!answer.equals("s") && !answer.equals("n")); 
    return answer.equals("s"); 
  } 

  public static void main(String[] args) { 
    new Mastermind().play(); 
  } 

}