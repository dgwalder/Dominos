package GameFiles;

public class GameBoard {
	//stores the number of dominos played so far 
	//initialized to 0
	int numDominosPlayed = 0;

	//aEnd1 and aEnd2 stores the values of the available options on the board
	int aEnd1, aEnd2;
	
	//stores the number corresponding to which player's turn it is 
	int playerTurn; 
	
	//keeps track of how many turns have been played in the game so far
	int numTurns;
	
	public GameBoard (){
		this.numDominosPlayed = 0;
	}
		
	//function which determines if a game is blocked
	public boolean isBlocked()
	{
		if (this.aEnd1 == this.aEnd2)
		{
			if (this.aEnd1 == 2/*the number count of that number is at 7 */){
				return true;
			}
			else{ 
				return false;
			}
		}
		return false;
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
