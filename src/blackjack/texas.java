//Programming Club 2017
//texas holdem style poker game

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;


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
			{
				gameStatus = false;
				GameServer.main(args);
			}
		}
		
		s.close();
	}	
	
	public static void main(String[] args)
	{
		ArrayList<Card> community = new ArrayList<Card>(); //community cards that people compare their hand to
		Deck deck = new Deck();
		Player player = new Player();
		
		updateDeck(deck); //update card values to be able to play the game
		
		deck.shuffleDeck();
		
		deck.dealCard(player);
		deck.dealCard(player);

		community.add(deck.getCard());
		community.add(deck.getCard());
		community.add(deck.getCard());
		
		System.out.println("Player Hand");
		player.printHand();
		System.out.println("");
		System.out.println("Community Cards");
		for(int i=0;i<community.size();i++)
		{
			System.out.println(community.get(i));
		}
		
		System.out.println("");
		pair(player,community);
		
		/*player.hand.addAll(community);
		System.out.println("");
		System.out.println("Player Hand after addition");
		player.printHand();
		
		Collections.sort(player.hand);
		System.out.println("");
		System.out.println("Player Hand after sort");
		player.printHand();*/
		
		
		
	}
	/*static void checkHand(Player a,ArrayList b)
	{
		a.hand.addAll(b);
		Collections.sort(a.hand);
	}*/
	
	static boolean pair(Player a,ArrayList b)
	{
		boolean pair=false;
		a.hand.addAll(b);
		Collections.sort(a.hand);
		//a.printHand();
		
		while((pair==false)&&(count!=a.hand.size()))
		{
			//code to iterate through hand using an element as a pivot point
			//to find a match to the pivot card
		}
		
		
		//take in both player hand and community array
		//add the two together and check whole array for two pairs of cards that match
		
		return pair;
	}
	static void TwoPair(Player a,ArrayList b)
	{
		a.hand.addAll(b);
		Collections.sort(a.hand);
		a.printHand();
		//take in both player hand and community array
		//add the two together and check whole array for two pairs of cards that match	
	}
	static void straight(Player a,ArrayList b)
	{
		a.hand.addAll(b);
		Collections.sort(a.hand);
		a.printHand();
		//take in both player hand and community array
		//see above
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
// Functions that check for hands, straight, pair, 2pair etc... 
/* game is played by the players each getting two cards, 
the two players to the left of the dealer put up the big and small blinds
the players bet, the dealer then deals 3 as community, 
then each player bets again, dealer deals 1, round of betting, then the dealer deals the last card the river, 
then the showdown and last bet take place.

the idea is to have the best 5 card hand out of the two dealt and the community cards

*/



