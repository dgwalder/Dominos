package GameFiles;

//TODO finish deadDouble method - after creating numCount in GameModel

//TODO - finish play method
	
//TODO - finish pose method

//TODO (if simulating game) -> sort domino in list based on sum of each domino 

	public class Player {
	
	Domino [] pDominos;
	
	//keeps a track of the number of doubles a player has in their hand
	int numDoubles = 0;

	//keeps track of how many dominos the person has left in their hand 
	int numDominos = 0;
	
	public Player(){
		this.numDominos = 0;
	}
	
	public void populateHand(Domino d){
		this.pDominos[numDominos] = d;
		if (pDominos[numDominos].isDouble()){
			numDoubles ++;
		}
		numDominos++;
	}
	
	//method which determines if a player has double 6
	//method will be ran at start of game 
	public boolean haveDoubleSix()
	{
		if(numDoubles>0){
			for (int i=0;i<7;i++){
				if(pDominos[i].isDouble()){
					if(pDominos[i].getSide1() == 6){
						return true;	
					}
				}
			}
		}
		return false;
	}	
	
	public int sumDominos(){
		int sum=0;
		for(int i=0; i<=numDominos;i++){
			 sum += pDominos[numDominos].getSum();
		}
		return sum;
	}
	
	//function which determines whether a player has a dead double in their hand
	//returns 1 if they do, otherwise 0 
	public boolean isDeadDoubleInHand()
	{
		if (numDoubles > 0){
			
		}
		//find the doubles in the players hand
		//check that number against the numCount in GameModel
		
		//Num count of that number is @ 6 and neither of the ends is equal to that number 
		//if (numCount(isDoubleOf(list of doubles)) == 6) && (aEnd1 != (isDoubleOf(list of doubles))
		
		return false;
	}
	
	//method returns the number of doubles left in the player's hand
	public int getNumDoublesRemaining()
	{
		int num = 0;
		for (int i = 0; i<numDominos; i++){
			if(this.pDominos[i].isDouble()){
				num++;
			}
		}
		return num;
	}
	
	//method responsible for posing doubleSix
	void pose(){
		//cycle thru dominos and find the double six
		//play the double six
	}
	
	//the play of the player
	void play(GameBoard gb){
		
	}
}
