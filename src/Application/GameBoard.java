package Application;

import java.util.Scanner;

public class GameBoard {
	public static final int boardDim = 10;
	Scanner sc = new Scanner(System.in);
	
	public GameBoard() {
		
	}
	
	public int rollDice() {
		return (int) (Math.random()*6) + 1;
	}
	
	public void playGame() {
		int diceFig = rollDice();
		String reply;
		int point = 1;
		
		while (true) {
			gameBoard(calculatePositionFromPoints(point));
			diceFig = rollDice();
			System.out.println("Do you want to play? (Press N to exit)");
			reply = sc.nextLine();
			if (reply.equalsIgnoreCase("n") || point>boardDim*4-4) {
					System.out.println("Game over.");
					break;
				}
			point += diceFig;
			System.out.println("Dice value: " + diceFig);
			System.out.println("Current step is at " + point);
		}
	}
	
	public Location calculatePositionFromPoints(int point) {
		
		if (point < 10) {return new Location(point, 1);}
		if (point < 19) {return new Location(10, point-9);}
		if (point < 28) {return new Location(11-point+18, 10);}
		if (point < 37) {return new Location(1, 11-point+27);}
		else return new Location(1,1);		
	}
	
	public void emptyBoard() {
		String normalPiece = "[ ]";
		String whitespaces = "   ";
		
		for (int i=1; i<=boardDim; i++) {
			for (int j=1; j<=boardDim; j++) {
				if (j>1 && j<boardDim && i!=1 && i!=boardDim) System.out.print(whitespaces);
				else System.out.print(normalPiece);
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void gameBoard(Location location) {
		String normalPiece = "[ ]";
		String whitespaces = "   ";
		String occupiedPiece = "[X]";
		
		for (int i=1; i<=boardDim; i++) {
			for (int j=1; j<=boardDim; j++) {
				
				if ((i == location.y)&&(j == location.x)) System.out.print(occupiedPiece);
				else if (j>1 && j<boardDim && i!=1 && i!=boardDim) System.out.print(whitespaces);
				else System.out.print(normalPiece);
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
