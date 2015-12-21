//Engineer: 	Damani Walder
//Project:		Dominos


public class gameBoard()
{
	//stores the number of dominos played so far 
	//initialized to 0
	int numDominosPlayed = 0;

	//aEnd1 and aEnd2 stores the values of the available options on the board
	int aEnd1, aEnd2;

	//stores the number corresponding to which player's turn it is 
	int playerTurn; 

	//keeps track of how many turns have been played in the game so far
	int numTurns;

	//function which determines if a game is blocked
	isBlocked()
	{
		if (aEnd1 == aEnd2)
		{
			if (/*the number count of that number is at 7 */)
				return 1;
			else 
				return 0;
		}
	}

	//function cycles through turns 
	nextTurn()
	{
		if (playerTurn < 4)
			playerTurn = playerTurn + 1;
		else  
			playerTurn = 1;
	}
}

public class player()
{
	//keeps a track of the number of doubles a player has in their hand
	int numDoubles;

	//keeps track of how many dominos the person has left in their hand 
	int numDominos = 7;

	//list of doubles in persons hand
	//still in construction

	//list of dominoes with the highest sum starting at the highest
	//still in construction

	//fucion which determines if a player has double 6
	//function is ran at the start of the game
	//returns 1 if they do, otherwise 0 
	int haveDoubleSix(class domino x)
	{
		if(x.isDouble)
		{
			if(x.side1 == 6)
				return 1;
			else
				return 0;
		}
	}

	//fuction which determines whether a player has a dead double in their hand
	//returns 1 if they do, otherwise 0 
	int deadDoubleInHand()
	{
		/*Num count of that number is @ 6 and either of the ends is not equal to the number of that  */
		/*
		if (numCount(isDoubleOf(list of doubles)) == 6) && (aEnd1 != (isDoubleOf(list of doubles))
		*/
	}

	//function that determines whether the player has won
	//runs AFTER the player completes their turn (because thats when the numDominoes would have already updated)
	int hasWonGame()
	{
		if (numDominos == 0)
			return 1;
		else 
			return 0;
	}
}

public class domino()
{
	int side1;
	int side2;

	//function which determines whether a domino is a double
	//if side1 = side2
	//returns 1 is it is a double, 0 if not
	int isDouble()
	{
		if (domino.side1 == domino.side2)
			return 1;
		else 
			return 0;
	}

	//make a function that just returns what that double is of
	//then can use that in the deadDoubleInHand function
	int doubleIsOf()
	{
		if (isDouble)
			return domino.side1
	}

}
