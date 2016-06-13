package GameFiles;

//TODO finsih implementation of numSum

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
	
	//the winner
	//intialized to 4 which does not represent a valid player 
	int winner = 4;
	
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
	
	void initModel (){
		DominoDeck gameDeck = new DominoDeck();
		gameDeck.shuffle();
		
		for (int l=0;l<4;l++){
			gameDeck.deal(players[l]);
		} 
	}
	
	void playGame(){
		//the player with doubleSix in their hand plays this domino first 
		for (int i=0;i<4;i++){
			if(players[i].haveDoubleSix()){
				playerTurn=i;
			}
		}
		
		//begin game
		while(winner!= 4){
			players[playerTurn].play(gb);
			hasWon();
			nextTurn();
		}
	}
	
	//method which determines whether a player has won the game 
	public boolean hasWon(){
		int currentSum;
		
		//intialized to a value higher than possible for hand of 7
		int winSum = 64;
		
		if (players[playerTurn].numDominos == 0){
			winner = playerTurn;
			return true;
		}
		else if(gb.isBlocked()){
			for(int i=0;i<4;i++){
				currentSum = players[i].sumDominos();
				//TODO - future add a condition if 2 players tie 
				if (currentSum < winSum){
					winSum = currentSum;
					winner = i;
				}
			}
			return true;
		}	
		return false;
	}
	
	//method which cycles through turns for players  
	public void nextTurn()
	{
		if (this.playerTurn < 3)
			this.playerTurn = playerTurn + 1;
		else  
			this.playerTurn = 0;
	}
}
