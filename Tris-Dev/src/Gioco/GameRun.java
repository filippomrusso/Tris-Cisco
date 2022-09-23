package Gioco;

import java.util.Scanner;

public class GameRun {
	
	public static void main(String...strings) {
	
	
		Field f = new Field();
		f.drawField();
	}
	
	
	public Player[] playerCreation() {
		
		//StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(System.in);
		String name1 = in.nextLine();
		Player player1 = new Player.PlayerBuilder()
									.setNamePlayer(name1)
									.setPlayerSign("x")
									.build();
		
		String name2 = in.nextLine();
		Player player2 = new Player.PlayerBuilder()
								   .setNamePlayer(name2)
								   .setPlayerSign("o")
								   .build();
		
		Player[] players = {player1, player2};
		return players;
								   
						
		
	}
	
	public void runGame() {
		
		
		
	}

}
