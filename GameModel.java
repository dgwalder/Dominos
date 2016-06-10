package GameFiles;

//TODO make moves such as add domino to top and add to bottom

//TODO fix hasWon method 

//TODO numCount method?

public class GameModel {
	GameBoard gb;
	Player [] players;
	static GameModel model = null;
	
	//stores the number corresponding to which player's turn it is 
	int playerTurn; 
		
	//keeps track of how many turns have been played in the game so far
	int numTurns;
	
	//keeps track of how much of each number has been played so far 
	int [] numSum;
	
	/** Creates a single GameModel. */	
	public static GameModel instance(){
		if(model == null){
			model = new GameModel();
		}
		return model;
	}
	
	GameModel(){
		gb = new GameBoard();
		players = new Player[4];
		numSum = new int [6];
	}
	
	//TODO - the first person to play(pose) is the player with the double six in their hand
	void initModel (){
		DominoDeck gameDeck = new DominoDeck();
		gameDeck.shuffle();
		
		for (int l=0;l<4;l++){
			gameDeck.deal(players[l]);
		} 
	}
	
	//function that determines whether the player has won
	//runs AFTER the current player completes their turn
	public boolean hasWon(){
		for (int i = 0;i<4;i++){
			if (players[playerTurn].numDominos == 0){
				return true;
			}
			// also check the game block win criteria
		}	
		return false;
	}
	
	//function cycles through turns 
	public void nextTurn()
	{
		if (this.playerTurn < 3)
			this.playerTurn = playerTurn + 1;
		else  
			this.playerTurn = 0;
	}
}
