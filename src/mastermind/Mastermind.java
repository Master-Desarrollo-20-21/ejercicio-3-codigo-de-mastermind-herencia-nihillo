package mastermind;

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
      answer = console.readString("\nCONTINUE? (y/n): "); 
    } while (!answer.equals("y") && !answer.equals("n")); 
    return answer.equals("y"); 
  } 

  public static void main(String[] args) { 
    new Mastermind().play();
  } 

}