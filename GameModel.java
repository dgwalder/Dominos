package GameCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import GameCode.GameBoard;
import GameCode.Domino;
import GameCode.DominoDeck;

public class GameModel {
	private List<Player> player;
	GameBoard gb;
	static GameModel model;
	
	int playerTurn;
	int winner;
	
	/** 
	 * Creates a single GameModel. 
	 */	
	public static GameModel instance(){
		if(model == null){
			model = new GameModel();
		}
		return model;
	}
	
	public List<Player> getPlayers(){
		return player;
	}
	/*
	 * GameModel Constructor
	 */
	GameModel(){
		initModel();
	}
	
	/**
	 * Initializes the game model
	 */
	
	private void initModel (){
		player = createPlayers();
		gb = new GameBoard();
		DominoDeck gameDeck = new DominoDeck();
		
		distributeDominos(gameDeck);
	
		//Print hand
		player.forEach(Player::printHand);
		
		System.out.println("Initialization Complete");
		System.out.println();
	}
	
	/**
	 * Game play
	 */
	void playGame(){
		Domino x;

		System.out.println("Game play has begun");

		pose();

		//Gameplay
		int count = 0;
		while(winner!= 7 && count != 8){
			player.get(playerTurn).play(gb);
			hasWon();
			nextTurn();
			count ++;
		}

		System.out.println("Game play is over");
	}
	
	/**
	 * Creates the players of the game 
	 * @return list of Players 
	 */
	private ArrayList<Player> createPlayers(){
		ArrayList<Player> playerList = new ArrayList<Player>();
		
		playerList.add(new Player("Player 1", 0));
		playerList.add(new Player("Player 2", 1));
		playerList.add(new Player("Player 3", 2));
		playerList.add(new Player("Player 4", 3));
		return playerList;
	}
	
	/**
	 * Distributes cards to the players 
	 */
	private void distributeDominos(DominoDeck deck){
		player.forEach(p-> {
			for (int i=0;i<7;i++){
				p.addDomino(deck.deal());
			}
		});	
	}
	
	/**
	 * Player with double six poses
	 */
	void pose(){
		//the player with doubleSix in their hand plays this domino first
		for (Player p: player){
			if(p.doesPlayerPose()){
				playerTurn = p.playerNum;
				p.removeFromHand(new Domino(6,6));
				gb.pose(new Domino(6,6));
				break;
			}
		}

		System.out.println(player.get(playerTurn).playerName + " posed");
		System.out.println(" ---------");
		System.out.println();
		nextTurn();
	}
	
	/**
	 * Cycles through player turns
	 */
	private void nextTurn()
	{
		if (playerTurn < player.size()-1)
			playerTurn = playerTurn + 1;
		else  
			playerTurn = 0;
		System.out.println(player.get(playerTurn).playerName + "'s turn");
		System.out.print("Available Ends -> ");
		System.out.print(gb.getEnd1());
		System.out.println(" || " + gb.getEnd1());
		
	}
	
	//method which determines whether a player has won the game 
	boolean hasWon(){
		//int currentSum;
		
		//intialized to a value higher than possible for hand of 7
		//int winSum = 64;
		
		if (player.get(playerTurn).getNumInHand() == 0){
			winner = playerTurn;
			System.out.print(player.get(playerTurn).playerName + " is the winner");
			return true;
		}
		/*
		else if(gb.isBlocked()){
			for(int i=0;i<4;i++){
				currentSum = player[i].sumDominos();
				//TODO - future add a condition if 2 players tie 
				if (currentSum < winSum){
					winSum = currentSum;
					winner = i;
				}
			}
			System.out.print(winner);
			System.out.println("is the winner");
			return true;
		}
		*/	
		return false;
	}
}
