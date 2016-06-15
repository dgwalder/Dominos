package GameFiles;

public class GameBoard {
	//stores the number of dominos played so far 
	//initialized to 0
	private int numDominosPlayed = 0;

	//aEnd1 and aEnd2 stores the values of the available options on the board
	private int aEnd1, aEnd2;
	
	//keeps track of how much of each number has been played so far 
	int [] numSum;
	
	public GameBoard (){
		this.numDominosPlayed = 0;
		numSum = new int [6];
	}
	
	public void setEnd1(int a){
		this.aEnd1 = a;
	}
	
	public void setEnd2(int a){
		this.aEnd2 = a;
	}
	
	public int getEnd1(){
		return this.aEnd1;
	}
	
	public int getEnd2(){
		return this.aEnd2;
	}
	
	public void setNumDominosPlayed(int a){
		this.numDominosPlayed+= a;
	}
		
	//function which determines if a game is blocked
	//a game is blocked when the 2 ends of the board have equal values 
	//and 7 dominos (including the double) or 6 (without the double) have already been playerd
	public boolean isBlocked()
	{
		if (aEnd1 == aEnd2)
		{
			if (aEnd1 == 2){
				//TODO - check if the 7 dominos containing the number at that end has been played
				return true;
			}
		}
		return false;
	}

	
}
