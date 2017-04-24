package GameCode;

import java.util.ArrayList;
import java.util.List;

final class GameBoard {
	//stores the number of dominos played so far 
	private int numDominosPlayed = 0;
	private List<Domino> graveyard = new ArrayList<>();

	//stores the values at the available ends of the board
	private int aEnd1, aEnd2;
		
	//keeps track of how much of each number has been played so far 
	int [] numSum;
		
	GameBoard (){
		numDominosPlayed = 0;
		numSum = new int [6];
	}
			
	/**
	 * determines if GameBoard is blocked
	 * @return
	 */
	public boolean isBlocked()
	{
		return ((aEnd1 == aEnd2) && (numSum[aEnd1] >= 6));
	}
	
	/**
	 * checks if a move is available for given domino
	 * @return
	 */
	boolean isMoveAvailable(Domino d){
		boolean moveAvailable = false;
		if (d.getSide1() == getEnd1()){
			moveAvailable = true;
		}else if (d.getSide2() == getEnd1()){
			moveAvailable = true;
		}else if (d.getSide1() == getEnd2()){
			moveAvailable = true;
		}else if (d.getSide2() == getEnd2()){
			moveAvailable = true;
		}
		return moveAvailable;
	}

	void pose(Domino d){
		setEnd1(d.getSide1());
		setEnd2(d.getSide2());
		graveyard.add(d);
	}

	void playDomino(Domino d) {
		if (d.getSide1() == getEnd1()){
			setEnd1(d.getSide2());
		}else if (d.getSide2() == getEnd1()){
			setEnd1(d.getSide1());
		}else if (d.getSide1() == getEnd2()){
			setEnd2(d.getSide2());
		}else {
			setEnd2(d.getSide1());
		}
		graveyard.add(d);
		numDominosPlayed++;
		
		//Todo update the num sum variable when a card is played
	}
	
	/******* Getters and Setters *****/
	private void setEnd1(int a){
		aEnd1 = a;
	}
		
	private void setEnd2(int a){
		aEnd2 = a;
	}

	int getEnd1(){
		return aEnd1;
	}
		
	int getEnd2(){
		return this.aEnd2;
	}
}
