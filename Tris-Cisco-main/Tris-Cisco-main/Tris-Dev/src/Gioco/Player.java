package Gioco;


public class Player {
	
	private String namePlayer;
	private String playerSign;  // x / o
	private boolean victory  = false;  // Default = true : indica lo stato di "vita del giocatore"
	private int nMoves;
	
	public int getnMoves() {
		return nMoves;
	}

	private Player(String namePlayer, String playerSign) {
		this.namePlayer = namePlayer;
		this.playerSign = playerSign;
	}

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
	
	public void setVictory(boolean b) {
		this.victory = b;
	}

	
	
	public static class PlayerBuilder{

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
			return new Player(namePlayer, playerSign);
		}
		
		
		public PlayerBuilder setNamePlayer(String namePlayer) {
			this.namePlayer = namePlayer;
			return this;
		}
		
		public PlayerBuilder setPlayerSign(String playerSign) {
			this.playerSign = playerSign;
			return this;
		}

	
	}
	
}