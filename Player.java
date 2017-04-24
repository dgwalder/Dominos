package GameCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import GameCode.Domino;

class Player {
	final String playerName;
	final int playerNum;
	private List<Domino> hand;
	
	/**
	 * Constructor for the Player class
	 * @param name
	 * @param num
	 */
	Player(String name, int num){
		playerName = name;
		playerNum = num;
		hand = new ArrayList<>();
	}
	
	int getNumInHand(){
		return hand.size();
	}
	
	/**
	 * adds Dominos to a Players hand
	 * @param d Domino to be added
	 */
	void addDomino(Domino d){
		hand.add(d);
	}

	void printHand(){
		System.out.print(playerName+": ");
		hand.forEach(domino -> System.out.print(domino.getSide1()+"||" + domino.getSide2()+ "  "));
		System.out.println();
	}
	
	/**
	 * Return true if Double 6 (six) is in the players hand
	 * @return true if Double 6 in hand
	 */
	boolean doesPlayerPose(){
		for (Domino d: hand){
			if(d.getSide1()==6 && d.getSide2()==6){
				hand.remove(d);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Players move
	 * @param gb
	 */
	void play(GameBoard gb){
        boolean playedDomino = false;
	    for(Domino d: hand) {
            if(gb.isMoveAvailable(d)){
                gb.playDomino(d);
                removeFromHand(d);
                System.out.println(playerName + " has played " + d.toString());
                playedDomino = true;
                break;
            }
        }

        if(!playedDomino){
            System.out.println(playerName + " has passed this turn");
	    }
		System.out.println(" ------ ");
	}

	void removeFromHand(Domino d){
        for(Domino dominoInHand: hand) {
            if (d.equals(dominoInHand)){
                hand.remove(dominoInHand);
                break;
            }
        }
    }
}
