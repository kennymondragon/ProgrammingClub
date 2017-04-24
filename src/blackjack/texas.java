//Programming Club 2017
//texas holdem style poker game

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Arrays; appears to be unused


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
		System.out.println(pair(player,community));
		
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
	
	/**
	 * Determines if player has a pair
	 * @param p player containing their hand
	 * @param community the cards available to all players
	 */
	static boolean pair(Player p, ArrayList<Card> community )
	{
		//Maybe have this chunk be called prior to the function and just pass in hand
		//Otherwise every scoring function is doing something like this
		ArrayList<Card> hand = new ArrayList<Card>(community);//new ArrayList<Card>;
		for(Card i : p.getCards())
			hand.add(i);
		Collections.sort(hand);
		
		
		
		for(int i=hand.size()-1;i>1;i--) // size-1 to start at end of array, i>0 to avoid reaching off end
			if(hand.get(i).getValue()==hand.get(i-1).getValue()) //i-1 to check the next lowest card
				return true;
		
		return false;
	}
	/**
	 * Determines if player has two pair
	 * @param p player containing their hand
	 * @param community the cards available to all players
	 * @return true if has two pair
	 * @return false if no two pair
	 */
	static boolean TwoPair(Player p, ArrayList<Card> community)
	{
		ArrayList<Card> temp = new ArrayList<Card>();
		
		ArrayList<Card> hand = new ArrayList<Card>(community);//new ArrayList<Card>;
		for(Card i : p.getCards())
			hand.add(i);
		Collections.sort(hand);
		
		
		for(int i=hand.size()-1;i>1;i--) // size-1 to start at end of array, i>0 to avoid reaching off end
			if(hand.get(i).getValue()==hand.get(i-1).getValue()) //i-1 to check the next lowest card
				temp.add(i);
				temp.remove(i);
				temp.add(i-1);
				temp.remove(i-1);
				//return true;
		for(int i=hand.size()-1;i>1;i--) // size-1 to start at end of array, i>0 to avoid reaching off end
			if(hand.get(i).getValue()==hand.get(i-1).getValue()) //i-1 to check the next lowest card
				temp.add(i);
				temp.remove(i);
				temp.add(i-1);
				temp.remove(i-1);
		
		if((temp.size()/4)==1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
		
		
	}
	/**
	 * Determines if player has a straight
	 * @param p player containing their hand
	 * @param community the cards available to all players
	 */
	static void straight(Player p, ArrayList<Card> community)
	{
		a.hand.addAll(b);
		Collections.sort(a.hand);
		a.printHand();
		//take in both player hand and community array
		//see above
	}
	/**
	 * Determines if player has a Royal Flush
	 * @param p player containing their hand
	 * @param community the cards available to all players
	 */
	static void RFlush(Player p, ArrayList<Card> community)
	{
		//if statements starting at high card and going through
		//comparing if the higher card is greater than the lower card
		//taking into account card value
	}
	/*
		still need:
		-straight
		-royal flush
		-flush
		-three of a kind
		-four of a kind
	
	
	/**
	 *Updates the Ace,King,Queen,Jack to respective numbers in the deck
	 *@param Deck d incoming operating deck
	 */
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



