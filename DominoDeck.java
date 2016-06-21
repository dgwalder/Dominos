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
	public int getSize(){
		return deck.size();
	}
	
	public void shuffle(){
		Collections.shuffle(deck);
	}
	
	public Domino deal(){
		return deck.remove(0);
	}
}
