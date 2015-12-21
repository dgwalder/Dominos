# Dominos
Jamaican Game of Dominos

Engineer: 	Damani Walder
Project:	Dominos

/*********************************/
// Jamaican domino game - ReadMeFile

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


/*******************************/

Class for board
	Each board represents a game. The game ends when a player wins

	- 2 attributes which signify the available ends, aEnd1 and aEnd2 
	- if a double is played, then values for availabe ends do not change that turn
	- isBlocked - that will be called after every play
	- attribute that stores the number of the player whos turn it is 
	
	************
	Need to create this urgently it is crucial to a lot of the functions	
	************
	- Have a running count of each number of a specific number played thus far
		- would make it easier to find if the game is blocked 
		- will be easy to know whether a double has died in someones hand 

	- nextTurn
		- To cycle through turns
		- adds 1 to the counter each time, if @ 4, resets to 1 (4 players, 4 distinct numbers 1-4)

Class for players/hand
	To determine whether a player can play that turn, the program will first check if the doubles in 
	that person's hand matches up with the current available options. Else, starting with the highest 
	valued (with resoect to sum) domino, check if any side of that domino matches with the available
	options on the board

	- Players start the game with 7 dominos

	- have a running list of the doubles in that persons hand 
	- have a running list of the dominos with the highest sum 
	- have a runing count of dominos in that persons hand
	
	- haveDoubleSix - which is called at the start of every game
		- player with double six automatically begins the game

	- deadDoubleInHand
		- will be 1 if the player has a dead double in their hand, 0 otherwise
		- intialized to value of 0

	- hasWonGame
		- determines whether that player has won the game. If any player has this as 1, the whole game
			is finished


Class for dominos
	Each domino wil have 2 attributes -> side 1 and side 2

	- isDouble - 1 if the domino is a double, 0 otherwise 


/**********************/
Assumptions

- a total of 28 dominos can never be played as someone would win before that happens 
- at least 4 turns pass before someone can win (someone must have something to match within the first
	4 turns)
- Each player class represents a hand
- Each board represents a game
- The game is finished when a player wins 


/***************/
Future Iteration

- Add a function that will randomly generate the dominos for each hand 
	- if a player gets 5 or more doubles to start with, then everyones hand is regenerated
