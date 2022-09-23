package Gioco;

//Impostare i nomi 
//Comunicare turno 
//Funzione che stabilisce l'inizio della partita
//Funzione partita in corso 
//Duarata partita in secondi 
//Numero giocate
//Comunicare vittoria / stallo
//Funzione giocata
//Recuperare nomi 				< IMPLEMENTATO >

public class Player {
	
	private String namePlayer;
	private String playerSign;  // x / o
	private boolean victory  = false;  // Default = true : indica lo stato di "vita del giocatore"
	private int nMoves;
	
	public int getnMoves() {
		return nMoves;
	}

	private Player() {}

	public String getNamePlayer() {
		return namePlayer;
	}

	public String getPlayerSign() {
		return playerSign;
	}

	public boolean isVictory() {
		return victory;
	}
	
	public void setnMoves() {
		this.nMoves ++;
	}

	
	
	public class PlayerBuilder{

		private String namePlayer;
		private String playerSign;  // x / o
		private boolean victory  = false;		
		private int nMoves;
		
		
		
	
		public PlayerBuilder() {
			this.namePlayer = "";
			this.playerSign = "";
			this.nMoves = 0;
			this.victory = false;
		}
		
		public Player build() {
			return new Player();
		}
		
		
		public PlayerBuilder setNamePlayer(String namePlayer) {
			this.namePlayer = namePlayer;
			return this;
		}
		
		public PlayerBuilder setPlayerSign(String playerSign) {
			this.playerSign = playerSign;
			return this;
		}
		public PlayerBuilder setVictory() {
			this.victory = true;
			return this;
		}
	}

}
