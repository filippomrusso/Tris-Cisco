package Gioco;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.StopWatch;

public class GameRun {
	
	public static void main(String...strings) {
		
		GameRun g = new GameRun();
		boolean play = g.newGame();
		
		if(play) {
			runGame();
		}
		
		else{
			System.out.println("Non sei mica obbligato");
		};
	
	
	}
	
	
	public static Player[] playerCreation() {
		
		System.out.println("Benvenuto! Player 1, inserisci il tuo nome");
		Scanner in = new Scanner(System.in);
		String name1 = in.nextLine();
		Player player1 = new Player.PlayerBuilder()
									.setNamePlayer(name1)
									.setPlayerSign("x")
									.build();
		System.out.println(player1);
		
		
		System.out.println("Benvenuto! Player 2, inserisci il tuo nome");
		String name2 = in.nextLine();
		Player player2 = new Player.PlayerBuilder()
								   .setNamePlayer(name2)
								   .setPlayerSign("o")
								   .build();
		System.out.println(player2);
		
		
		Player[] players = {player1, player2};
		return players;
								   
						
	}
	
	
	public boolean newGame() {
		Scanner in = new Scanner(System.in);
		String choice;
		boolean check = true;
		
		while(check == true){
		System.out.println("Vuoi iniziare una partita? y/n ");
		choice = in.nextLine();
		
		if( choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")){
			check = false;
			return true;
		}
		
		if( choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
			check = false;
			return false;
		}
		
	}
		
		return true;
				
	}
	
	public static void runGame() {
		
		Player[] players = playerCreation();
		
		Player p1 = players[0];
		Player p2 = players[1];
		
		Field f = new Field();
		StopWatch timer = new StopWatch();
		
		timer.start();
		f.drawField();
		
		int turno = 0;
		
		
		while(!p1.isVictory() && !p2.isVictory()) {
			
			Player p = (turno%2  == 0 ? p1 : p2);
			
			f.drawPlayerChoice(p,f);
			f.drawField();
			p.setVictory(f.checkWin(p));
			
			
			turno++;
			
		}
		
		
		
		timer.stop();
		System.out.println("La partita è durata: " + "\n"
		+ timer.getTime() * 1000 + " secondi");
		
		
		
	}

}