package GameFiles;

public class Player {
	
	Domino pDominos [];
	//keeps a track of the number of doubles a player has in their hand
	int numDoubles = 0;

	//keeps track of how many dominos the person has left in their hand 
	int numDominos = 0;
	
	public Player(){
		this.numDominos = 0;
	}
	
	public void populateHand(Domino d){
		this.pDominos[numDominos] = d;
		numDominos++;
	}
	
	//list of doubles in persons hand
	//still in construction
	
	//list of dominoes with the highest sum starting at the highest
	//still in construction
		
	//function which determines if a player has double 6
	//function is ran at the start of the game
	//returns 1 if they do, otherwise 0 
	public boolean haveDoubleSix(Domino d)
	{
		if(this.numDoubles>0){
			for (int i=0;i<7;i++){
				if(this.pDominos[i].isDouble()){
					if(this.pDominos[i].getSide1() == 6){
						return true;	
					}
				}
			}
		}
		return false;
	}	
	
	//function which determines whether a player has a dead double in their hand
	//returns 1 if they do, otherwise 0 
	public boolean isDeadDoubleInHand()
	{
		//Num count of that number is @ 6 and either of the ends is not equal to the number of that 
		/*
		if (numCount(isDoubleOf(list of doubles)) == 6) && (aEnd1 != (isDoubleOf(list of doubles))
		*/
		return false;
	}

	//function that determines whether the player has won
	//runs AFTER the player completes their turn (because thats when the numDominoes would have already updated)
	public boolean hasWonGame()
	{
		if (numDominos == 0)
			return true;
		else 
			return false;
	}
	
	public int getNumDoubles()
	{
		int num = 0;
		for (int i = 0; i<7; i++){
			if(this.pDominos[i].isDouble()){
				num++;
			}
		}
		return num;
	}
}
