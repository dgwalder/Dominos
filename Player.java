package GameFiles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
	
public class Player {
	//list of dominos in players hand
	List<Domino> hand;
	
	//keeps a track of the number of doubles a player has in their hand
	int numDoubles = 0;

	//keeps track of how many dominos the person has left in their hand 
	int numDominos = 0;
	
	public Player(){
		this.numDominos = 0;
		int numDoubles = 0;
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
		
	//this method determines play of the player

	//if one of the sides of the dominos is equal to either end
	//update the new end to reflect that of the opposite side of domino
	//remove that domino from the players hand, update the numDominosPlayed
	
	//if no move is available, the player passes this turn
	void play(GameBoard gb){
		//check first if is possible to play a double
		for (int i=0; i<numDoubles;i++){
			if (hand.get(i).getSide1()== gb.getEnd1() || hand.get(i).getSide1()== gb.getEnd2()){
				gb.numSum[hand.get(i).getSide1()]++;
				hand.remove(i);
				gb.setNumDominosPlayed(1);
				numDominos--;
				numDoubles--;
				return;
			}
		}
		
		//if it is not possible to play a double then check the other
		//remaining dominos for available plays 
		for (int j=numDoubles; j<hand.size();j++){
			int play=0;
			if (hand.get(j).getSide1() == gb.getEnd1()){
				gb.setEnd1(hand.get(j).getSide2());
				play=1;	
			}else if (hand.get(j).getSide2() == gb.getEnd1()){
				gb.setEnd1(hand.get(j).getSide1());
				play=1;	
			}else if (hand.get(j).getSide1() == gb.getEnd2()){
				gb.setEnd2(hand.get(j).getSide2());
				play=1;
			}else if (hand.get(j).getSide2() == gb.getEnd2()){
				gb.setEnd2(hand.get(j).getSide1());
				play=1;
			}
			
			if(play == 1){
				gb.numSum[hand.get(j).getSide1()]++;
				gb.numSum[hand.get(j).getSide2()]++;
				hand.remove(j);
				gb.setNumDominosPlayed(1);
				numDominos--;
				return;
			}
		}
		//if there are no available moves this turn for this player 
		System.out.println("This player has passed");
		return;
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
	}*/
	
}
