package GameFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DominoDeck {
	private List<Domino> deck;
	
	public DominoDeck(){
		deck = new ArrayList<Domino>();
		
		for (int i=0;i<7;i++){
			for (int j=i;j<7; j++){
				Domino d = new Domino (i, j);
				deck.add(d);
			}	
		}
	}
	
	public void shuffle(){
		Collections.shuffle(deck);
	}
	
	public void deal(Player p){
		for(int i=0;i<7;i++){
			p.populateHand(deck.remove(0));
		}
	}
}
