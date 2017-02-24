//Programming Club 2017
//texas holdem style poker game

import java.util.Scanner;
import java.util.Collections.ArrayList;
import java.util.Collections;


class texas
{
	static void Game()
	{
		String[] args= new String[6];
		String Q = " ";
		boolean gameStatus=true;
		Scanner s = new Scanner(System.in);
		while(gameStatus == true)
		{
			texas.main(args);
			
			System.out.println("Would you like to play again?");
			System.out.println();
			Q = s.next();
			if(Q.equals("no")||Q.equals("n")||Q.equals("NO")||Q.equals("No"))
				gameStatus = false;
		}
		s.close();
	}	
	
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		
		updateDeck(deck);
		
		deck.display();
		
		for(int i=0;i<52;i++)
		{
			System.out.println(deck.theDeck.get(i).getValue());
		}
		
	}
	
	
	static void updateDeck(Deck d)
	{
		for(int i=0;i<52;i++)
		{
			if((i%13)==10)
			{
				d.theDeck.get(i).setValue(11);
			}
			else if((i%13)==11)
			{
				d.theDeck.get(i).setValue(12);
			}
			else if((i%13)==12)
			{
				d.theDeck.get(i).setValue(13);
			}
			else if((i%13)==0)
			{
				d.theDeck.get(i).setValue(1);
			}
		}
	}
	
}

//initialize deck
//reset card values so that A=1 K=13 Q=12 J=11
// suit values should be 0-3
// Arraylist of poker hands, sorted to be greatest to least top down
/* game is played by the players each getting two cards, 
the two players to the left of the dealer put up the big and small blinds
the players bet, the dealer then deals 3 as community, 
then each player bets again, dealer deals 1, round of betting, then the dealer deals the last card the river, 
then the showdown and last bet take place.

the idea is to have the best 5 card hand out of the two dealt and the community cards

*/



