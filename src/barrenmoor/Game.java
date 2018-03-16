package barrenmoor;

import java.util.Scanner;
import barrenmoor.Player;
import barrenmoor.Grid;

public class Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Are you ready to play the best game ever?! Y/N");
		
		String input = sc.next();
		if(input.equalsIgnoreCase("Y")) {
			startGame(sc);		
		}else{
			System.exit(0);
		}
	}
	
	public static void startGame(Scanner sc) {
		Player player = new Player(2, 2);
		Grid grid = new Grid(5,5, player);
		
		boolean quit = false;
		
		while(!quit) {
			System.out.println("North, South, East or West? Beware of Grizzly Bears. Press c for a clue or q to quit.");
			String input = sc.next();
			
			if(!(input.equalsIgnoreCase("c"))) {
			
			if(!(input.equalsIgnoreCase("q"))) {
				grid.resetCoord(player.getX(), player.getY());
				if(input.equalsIgnoreCase("North")) { 
					player.setX(player.getX()-1);
				}else if(input.equalsIgnoreCase("South")) {
					player.setX(player.getX()+1);
				}else if(input.equalsIgnoreCase("East")) {
					player.setY(player.getY()+1);
				}else if(input.equalsIgnoreCase("West")) {
					player.setY(player.getY()-1);
				}
				int value = grid.checkTreasure(player.getX(), player.getY());
				
				if(value == -1) {
					System.out.println("CONGRATS YOU FOUND THE TREASURE!!");
					System.exit(0);
				}
				
				grid.setCoord(player.getX(), player.getY());
				
				
				System.out.println("Coordinates: " + player.getX() + "," + player.getY());	
				grid.printGrid();
				
			}
			else {
				quit = true;
			}	
		}else {
			double distance = Math.hypot(0-player.getX(), 0-player.getY());
			System.out.println("You are: " + distance + " footsteps away. Hehehehe.");
		}
	}
	}
}
