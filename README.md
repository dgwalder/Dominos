# Dominos
Jamaican Game of Dominos

Engineer: 	Damani Walder
Project:	Dominos

/*********************************/

	General Info
	- consist of 'dominos' that have 2 numbers on it.
	- the numbers range from 0(known as blank) to 6
	- all the dominos are unique
	- 28 total dominos
	- Each player begins the game with 7 dominos. 
	- There are 4 players in every game

	Ways to win
	- the first person to play all the dominos in their hand wins the game	
	- the person to have the lowest sum in the case that the game is blocked
	
	The main gameplay consist of the first person "posing with a double 6" then everyone has their own turn 
	thereafter which they can play a domino from their hand. A player can only play one domino at a time

	Following this, players try to match dominos in their hand to the available domino sides on
	the board by matching one side of the domino from their hand to the available side on the board
		
	- Many different strategies to play this game
		One of the more common strategies is trying to get rid of all doubles first	then trying to get rid of 
		the higher valued cards that match the available options on the board(ones with the higher sum)
			- Get rid of doubles first 
				this is due to the fact that there is an odd number of each number (eg only 7 dominos 
				have the number 6 on it) so it is possible that all the opportunities to play your 
				double will be gone and you are stuck with it in your hand because you cannot play it.
				We say that the double died in your hand.

			- Get rid of higher valued dominos first
				this is due to the fact that the game can be "blocked" in which case players have to 
				add the total of all the numbers on all their dominos. The person with the least 
				total sum will win that game

	
	Assumptions
	- a total of 28 dominos can never be played as someone would win before that happens 
	- at least 4 turns pass before someone can win 
 		- (someone must have something to match within the first 4 turns)


/*******************************/

GameBoard Class
	
	---------
	Attributes 
	- aEnd1 and aEnd2
		- 2 attributes which signify the available ends of the curernt game  
		- if a double is played, then values for availabe ends do not change that turn
	- numDominos played
		- stores the number of dominos which have been played 	
	
	- numCount
		- running count of each number of dominos containing a specific number which have 
		  been played thus far

	---------
	Methods
	- isBlocked
		- method which determines if the game is blocked
	

Player Class
	
	- To determine whether a player can play that turn, the program will first check if the doubles in 
	that person's hand matches up with the current available options. Else, starting with the highest 
	valued (with respect to sum) domino, check if any side of that domino matches with the available
	options on the board

	- Each player starts the game with 7 dominos

	---------
	Attributes 
	- hand
		- Stores dominos currently in the players hand 
	- numDoubles
		- stores a running count of the doubles in that player's hand 
	
	- numDominos ***will be removed due to ArrayList Impl*** 
		- stores a runing count of the number of dominos in that persons hand 	

	---------
	Methods
	- populateHand
		- method used to add dominos to a players hand
		- *** updates the running counts accordingly
	- sumDominos
		- sums all the dominos in a players hand
	
	- pose	
		- method used to pose
	
	- play	
		- method for playing dominos 
		- called at a player's turn
	
	---------
	Possible Additions
	- store the dominos using a sorted list
		- when the dominos are dealt to the player, sort the list according to highest sum, 
		therefore allowing you to play the highest sum domino which is available first
	
	- method: deadDoubleInHand
		- method determines if a player has a deadDouble in their hand
	
	- method: getNumDoublesRemaining
		- method which returns the number of doubles remaining in a players hand 

GameModel Class

	----------
	Attributes 
	- GameBoard
	- Player
	- PlayerTurn
		- attribute that stores the number of the player whose turn it is 
	- numTurns
		- attribute which stores the total number of turns that have been played
	- winner
		- stores the winner 
	
	---------
	Methods
	- initModel
		- method which initializes the model elements
	- playGame
		- method for gameplay
	- hasWonGame
		- determines whether a player has won the game
		- if this is true for any player, the game is done
	- nextTurn
		- method which cycles through turns

Domino Class

	----------
	Attributes
	- side1
	- side2
		- attributes representing the two sides of a domino
	
	---------
	Methods

	- getSum
		- method which returns the sumn of both sides of domino
	- isDouble 
		- method that determines if the domino is a double 
	
	**Possible Removal - may be unnecessary ****
	- DoubleIsOf
		- method that returns what the double is of
		- returns 7 if it is not a double


