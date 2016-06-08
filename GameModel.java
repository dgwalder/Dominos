package GameFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameModel {
	GameBoard gb;
	Player players [];
	static GameModel model = null;
	
	/** Creates a single GameModel. */	
	public static GameModel instance(){
		
		if(model == null){
			model = new GameModel();
		}
		
		return model;
	}
	
	GameModel(){
		gb = new GameBoard();
		players = new Player[4];
	}
	
	void initModel (){
		Domino[] dominos = new Domino[28];
		int num = 0;
		
		for (int i=0;i<7;i++){
			for (int j=i;j<7; j++){
				dominos[num] = new Domino (i, j);
				num ++;
			}	
		}
		
		List<Integer> arrlist = new ArrayList<Integer>(28);
		for (int k=0;k<28;k++){
			arrlist.add(k);
		}
		Collections.shuffle(arrlist);
		
		for (int l=0;l<28;l++){
			this.players[28%l].populateHand(dominos[(int) arrlist.remove(0)]);
		} 
	}
}
