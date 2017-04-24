package GameCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class DominoDeck {
	private List<Domino> deck;
	
	/**
	 * Constructor for domino deck
	 */
	DominoDeck(){
		createDeck();
		shuffle();
	}
	
	/**
	 * Creates Dominos and adds them to the deck
	 */
	private void createDeck(){
		deck = new ArrayList<>();
		
		for (int i=0;i<7;i++){
			for (int j=i;j<7; j++){
				Domino d = new Domino (i, j);
				deck.add(d);
			}	
		}
	}
	
	/**
	 * Shuffles the deck
	 */
	private void shuffle(){
		Collections.shuffle(deck);
	}
	
	/**
	 * Deals a single domino from the deck
	 * @return domino
	 */
	Domino deal(){
		return deck.remove(0);
	}
}
