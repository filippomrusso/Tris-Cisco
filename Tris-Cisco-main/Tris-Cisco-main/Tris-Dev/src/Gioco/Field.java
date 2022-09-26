package Gioco;

import java.util.Scanner;

//Impostare i nomi 				< IMPLEMENTATO >
//Comunicare turno 				< IMPLEMENTATO >
//Funzione che stabilisce l'inizio della partita < IMPLEMENTATO >
//Funzione partita in corso     < IMPLEMENTATO >
//Duarata partita in secondi 	< IMPLEMENTATO >
//Numero giocate				< IMPLEMENTATO >
//Comunicare vittoria / stallo
//Funzione giocata				< IMPLEMENTATO >
//Recuperare nomi 				< IMPLEMENTATO >

public class Field {
	
	Scanner input = new Scanner(System.in);

	private String[][] gameField = {

			{ " ", " ", " " },

			{ " ", " ", " " },

			{ " ", " ", " " } };
	

	public void drawField() {
		for (int i = 0; i < gameField.length; i++) {
			StringBuilder sb = new StringBuilder();
			System.out.println(gameField[i][0] + " | " + gameField[i][1] + " | " + gameField[i][2]);			
		}
	}

	public static int[] convertCoordinates(String choice) {

		// 1 2 3
		// a [0,0][1,0][2,0]
		// b [0,1][1,1][2,1]
		// c [0,2][1,2][2,2]

		if (choice.equalsIgnoreCase("a1")) {
			int[] scelta = { 0, 0 };
			return scelta;
		}

		if (choice.equalsIgnoreCase("a2")) {
			int[] scelta = { 0, 1 };
			return scelta;
		}

		if (choice.equalsIgnoreCase("a3")) {
			int[] scelta = { 0, 2 };
			return scelta;
		}

		if (choice.equalsIgnoreCase("b1")) {
			int[] scelta = { 1, 0 };
			return scelta;
		}

		if (choice.equalsIgnoreCase("b2")) {
			int[] scelta = { 1, 1 };
			return scelta;
		}

		if (choice.equalsIgnoreCase("b3")) {
			int[] scelta = { 1, 2 };
			return scelta;
		}

		if (choice.equalsIgnoreCase("c1")) {
			int[] scelta = { 2, 0 };
			return scelta;
		}

		if (choice.equalsIgnoreCase("c2")) {
			int[] scelta = { 2, 1 };
			return scelta;
		}

		if (choice.equalsIgnoreCase("c3")) {
			int[] scelta = { 2, 2 };
			return scelta;
		}

		else {
			int[] scelta = { -1, -1 }; // errore
			return scelta;
		}
	}

	public static boolean gameOver(Player p) {
		System.out.println("|GAME OVER|");
		System.out.println("Hai vinto tu, " + p.getNamePlayer());
		System.out.println("\n");
		return true;
	}

	public void drawPlayerChoice(Player p, Field f) {


		p.setnMoves();

		int choiceCoordinate[];

		do {
			System.out.println("Giocatore " + p.getNamePlayer() 
			+ ", con segno " + p.getPlayerSign() 
			+ ", fai la tua scelta");
			
			String choice = input.nextLine();
			
			choiceCoordinate = convertCoordinates(choice);

		} while ((( choiceCoordinate[0] == -1) && (choiceCoordinate[1] == -1)) 
				|| ((f.getField(choiceCoordinate[0], choiceCoordinate[1]).equalsIgnoreCase("x")
				|| (f.getField(choiceCoordinate[0], choiceCoordinate[1]).equalsIgnoreCase("y")))));

		gameField[choiceCoordinate[0]][choiceCoordinate[1]] = p.getPlayerSign();

		

	}

	public String getField(int index1, int index2) {
		return gameField[index1][index2];
	}

	public boolean checkWin(Player p) {

		/*
		 * String[] row1 = {gameField[0][0], gameField[1][0], gameField[2][0]}; String[]
		 * row2 = {gameField[0][1], gameField[1][1], gameField[2][1]}; String[] row3 =
		 * {gameField[0][2], gameField[1][2], gameField[2][2]};
		 * 
		 * String[] column1 = {gameField[0][0], gameField[0][1], gameField[0][2]};
		 * String[] column2 = {gameField[1][0], gameField[1][1], gameField[1][2]};
		 * String[] column3 = {gameField[2][0], gameField[2][1], gameField[2][2]};
		 * 
		 * String[] cross1 = {gameField[0][0], gameField[1][1], gameField[2][2]};
		 * String[] cross2 = {gameField[0][2], gameField[1][1], gameField[2][0]};
		 */

		if (gameField[0][0].equals(p.getPlayerSign()) && gameField[0][1].equals(p.getPlayerSign())
				&& gameField[0][2].equals(p.getPlayerSign())) {
			return gameOver(p);
		}

		if (gameField[0][0].equals(p.getPlayerSign()) && gameField[1][0].equals(p.getPlayerSign())
				&& gameField[2][0].equals(p.getPlayerSign())) {
			return gameOver(p);
		}

		if (gameField[0][1].equals(p.getPlayerSign()) && gameField[1][1].equals(p.getPlayerSign())
				&& gameField[2][1].equals(p.getPlayerSign())) {
			return gameOver(p);
		}

		if (gameField[0][2].equals(p.getPlayerSign()) && gameField[1][2].equals(p.getPlayerSign())
				&& gameField[2][2].equals(p.getPlayerSign())) {
			return gameOver(p);
		}

		if (gameField[1][0].equals(p.getPlayerSign()) && gameField[1][1].equals(p.getPlayerSign())
				&& gameField[1][2].equals(p.getPlayerSign())) {
			return gameOver(p);
		}

		if (gameField[2][0].equals(p.getPlayerSign()) && gameField[2][1].equals(p.getPlayerSign())
				&& gameField[2][2].equals(p.getPlayerSign())) {
			return gameOver(p);
		}

		if (gameField[2][0].equals(p.getPlayerSign()) && gameField[1][1].equals(p.getPlayerSign())
				&& gameField[0][2].equals(p.getPlayerSign())) {
			return gameOver(p);
		}

		if (gameField[0][0].equals(p.getPlayerSign()) && gameField[1][1].equals(p.getPlayerSign())
				&& gameField[2][2].equals(p.getPlayerSign())) {
			return gameOver(p);
		}

		return false;
	}

}