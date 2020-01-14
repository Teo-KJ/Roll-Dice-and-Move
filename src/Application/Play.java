package Application;

public class Play {
	public Play() {
		
	}
	
	public static void main (String [] args) {
		System.out.println("Let the game begin!\n");
		
		GameBoard start = new GameBoard();
		
		start.playGame();
	}
}
