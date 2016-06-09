package GameFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TODO make moves such as add domino to top and add to bottom
//TODO move the creation of the dominos to its own class
//TODO move the dealing out of dominos to players to its own method

//TODO - move the hasWon method from player
//		mod the hasWon method to also check the game block win criteria


public class GameModel {
	GameBoard gb;
	Player players [];
	static GameModel model = null;
	
	//stores the number corresponding to which player's turn it is 
	int playerTurn; 
		
	//keeps track of how many turns have been played in the game so far
	int numTurns;
	
	
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
	}
	
	//TODO - the first person to play(pose) is the player with the double six in their hand
	void initModel (){
		Domino[] dominos = new Domino[28];
		int num = 0;
		
		for (int i=0;i<7;i++){
			for (int j=i;j<7; j++){
				dominos[num] = new Domino (i, j);
				num ++;
			}	
		}
		
		List<Integer> arrlist = new ArrayList<Integer>(28);
		for (int k=0;k<28;k++){
			arrlist.add(k);
		}
		Collections.shuffle(arrlist);
		
		for (int l=0;l<28;l++){
			this.players[28%l].populateHand(dominos[(int) arrlist.remove(0)]);
		} 
	}
	
	//function cycles through turns 
		public void nextTurn()
		{
			if (this.playerTurn < 4)
				this.playerTurn = playerTurn + 1;
			else  
				this.playerTurn = 1;
		}
}
