package Gioco;

import java.util.Scanner;

//Impostare i nomi 				< IMPLEMENTATO >
//Comunicare turno 
//Funzione che stabilisce l'inizio della partita
//Funzione partita in corso 
//Duarata partita in secondi 
//Numero giocate				< IMPLEMENTATO >
//Comunicare vittoria / stallo
//Funzione giocata				< IMPLEMENTATO >
//Recuperare nomi 				< IMPLEMENTATO >

public class Field {

	private String[][] gameField = new String[3][3];

	public void drawField() {
		for(int i = 0; i < gameField.length; i ++) {
			StringBuilder sb = new StringBuilder();
			sb
			.append(gameField[i][0])
			.append(" | ")
			.append(gameField[i][1])
			.append(" | ")
			.append(gameField[i][2])
			.append("\n");
			
			System.out.print(sb);
			sb = null;
		}	
	}
	
	public static int[] convertCoordinates(String choice) {
		
		// 		1	 2	 3
		//	a [0,0][1,0][2,0]
		//	b [0,1][1,1][2,1]
		//	c [0,2][1,2][2,2]
		
		
		
		if(choice.equalsIgnoreCase("a1")) {
			int[] scelta = {0,0};
			return scelta;
		}
		
		if(choice.equalsIgnoreCase("a2")) {
			int[] scelta = {1,0};
			return scelta;
		}
		
		if(choice.equalsIgnoreCase("a3")) {
			int[] scelta = {2,0};
			return scelta;
		}
		
		if(choice.equalsIgnoreCase("b1")) {
			int[] scelta = {0,1};
			return scelta;
		}
		
		if(choice.equalsIgnoreCase("b2")) {
			int[] scelta = {1,1};
			return scelta;
		}
		
		if(choice.equalsIgnoreCase("b3")) {
			int[] scelta = {2,1};
			return scelta;
		}
		
		if(choice.equalsIgnoreCase("c1")) {
			int[] scelta = {0,2};
			return scelta;
		}
		
		if(choice.equalsIgnoreCase("c2")) {
			int[] scelta = {1,2};
			return scelta;
		}
		
		if(choice.equalsIgnoreCase("c3")) {
			int[] scelta = {2,2};
			return scelta;
		}
		
		else {
			 int[] scelta = {-1, -1};		// errore
			 return scelta;
		}
	}
	
	
	public void drawPlayerChoice(Player p) {
		
		Scanner input = new Scanner(System.in);
		
		p.setnMoves();
		
		StringBuilder sb = new StringBuilder();
		int choiceCoordinate[];
		
		do {
		sb.append("Giocatore ")
		.append(p.getNamePlayer() + ", ")
		.append("con segno "  + p.getPlayerSign() + ", ")
		.append("fai la tua scelta");
		
		choiceCoordinate = convertCoordinates(input.nextLine());
		
		} while ((choiceCoordinate[0] == -1) && (choiceCoordinate[1] == -1));
		
		gameField[choiceCoordinate[0]][choiceCoordinate[1]] = p.getPlayerSign();
		
	}

}
