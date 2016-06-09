package GameFiles;

public class GameBoard {
	//stores the number of dominos played so far 
	//initialized to 0
	int numDominosPlayed = 0;

	//aEnd1 and aEnd2 stores the values of the available options on the board
	int aEnd1, aEnd2;
	
	public GameBoard (){
		this.numDominosPlayed = 0;
	}
		
	//function which determines if a game is blocked
	//a game is blocked when the 2 ends of the board have equal values 
	//and 7 dominos (including the double) or 6 (without the double) have already been playerd
	public boolean isBlocked()
	{
		if (this.aEnd1 == this.aEnd2)
		{
			if (this.aEnd1 == 2){
				//TODO - check if the 7 dominos containing the number at that end has been played
				return true;
			}
		}
		return false;
	}

	
}
