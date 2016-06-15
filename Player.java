package GameFiles;

import java.util.ArrayList;
import java.util.List;
	
//TODO - finish pose method

//TODO (if simulating game) -> sort domino in list based on sum of each domino 

public class Player {
	//list of dominos in players hand
	List<Domino> hand;
	
	//keeps a track of the number of doubles a player has in their hand
	int numDoubles = 0;

	//keeps track of how many dominos the person has left in their hand 
	int numDominos = 0;
	
	public Player(){
		this.numDominos = 0;
		this.hand = new ArrayList<Domino>();
	}
	
	public void populateHand(Domino d){
		hand.add(d);
		if (d.isDouble()){
			numDoubles ++;
		}
		//will be used for debugging purposes
		numDominos++;
	}
	
	//method which determines if a player has double 6
	//method will be ran at start of game to determine which player
	//plays first
	/*public boolean haveDoubleSix()
	{
		if(numDoubles>0){
			for (int i=0;i<hand.size();i++){
				if(hand.get(i).isDouble()){
					if(hand.get(i).getSide1() == 6){
						return true;	
					}
				}
			}
		}
		return false;
	}*/	
	
	public int sumDominos(){
		int sum=0;
		for(int i=0; i<=hand.size();i++){
			 sum += hand.get(i).getSum();
		}
		return sum;
	}
	
	//method responsible for posing doubleSix
	void pose(GameBoard gb){
		hand.remove(new Domino(6,6));
		gb.setEnd1(6);
		gb.setEnd2(6);
		gb.changeNumDomPlayed(1);
	}
		
	//the play of the player
	void play(GameBoard gb){
		
	}
	
	
	/*
	//function which determines whether a player has a dead double in their hand 
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
	*/
}
