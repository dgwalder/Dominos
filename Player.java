package GameFiles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
	
//TODO - finish play method

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
	
	//adds dominos to a player's hand
	public void populateHand(Domino d){
		hand.add(d);
		if (d.isDouble()){
			numDoubles ++;
		}
		//will be used for debugging purposes
		numDominos++;
	}	
	
	//sort the hand by order of the sum
	//then puts the doubles at the front of the hand
	public void handSort(){
		hand.sort(new Comparator<Domino>() {
	        public int compare(Domino d1, Domino d2) {
	            return d2.getSum2().compareTo(d1.getSum2());
	        }
	    });
		for (int i=0; i<hand.size();i++){
			if(hand.get(i).isDouble()){
				hand.add(0, hand.remove(i));
			}
		}
	}
	
	//sums all dominos in a players hand
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
		gb.setNumDominosPlayed(1);
		gb.numSum[6]++;
	}
		
	//the play of the player
	void play(GameBoard gb){
		//check first if is possible to play a double
		for (int i=0; i<numDoubles;i++){
			if (hand.get(i).getSide1()== gb.getEnd1()){
				hand.remove(i);
				gb.setNumDominosPlayed(1);
				numDoubles--;
				return;
			}
			else if (hand.get(i).getSide1()== gb.getEnd2()){
				hand.remove(i);
				gb.setNumDominosPlayed(1);
				numDoubles--;
				return;
			}
		}
		
		//if it is not possible to play a double then check all cards
		//starting with the one with the highest sum
		for (int j=numDoubles; j<hand.size();j++){
			//if one of the sides of the dominos is equal to either end
			//update the new end to reflect that of the opposite side of domino
			//remove that domino from the players hand, update the numDominosPlayed
		}
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
}
