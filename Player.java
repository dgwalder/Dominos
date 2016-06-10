	package GameFiles;

//TODO finish deadDouble method - after creating numCount in GameModel

//TODO store the dominos as a list in order of highest sum 

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
		//Num count of that number is @ 6 and neither of the ends is equal to that number 
		//if (numCount(isDoubleOf(list of doubles)) == 6) && (aEnd1 != (isDoubleOf(list of doubles))
		
		return false;
	}
	
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
}
