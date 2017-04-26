//Programming Club 2017
//texas holdem style poker game

//package blackjack;
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
		System.out.println("Sorted");
		
		
		
		System.out.println("");
		System.out.println(pair(player,community));
		System.out.println("");
		System.out.println(TwoPair(player,community));
		System.out.println("");
		System.out.println(straight(player,community));
		
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
		for(Card i : p.getHand())
			hand.add(i);
		Collections.sort(hand);
		
		for(int i=hand.size()-1;i>=0;i--)
		{
			System.out.println(hand.get(i));
		}
		
		System.out.println("");
		
		for(int i=hand.size()-1;i>=1;i--) // size-1 to start at end of array, i>0 to avoid reaching off end
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
		for(Card j : p.getHand())
			hand.add(j);
		Collections.sort(hand);
		
		
		for(int i = hand.size()-1;i>=1;i--) // size-1 to start at end of array, i>0 to avoid reaching off end
		{	
			if(hand.get(i).getValue()==hand.get(i-1).getValue()) //i-1 to check the next lowest card
			{
				temp.add(hand.get(i));
				//hand.remove(i);
				temp.add(hand.get(i-1));
				//hand.remove(i-1);
			}
		}
		for(int i = hand.size()-1;i>=1;i--) // size-1 to start at end of array, i>0 to avoid reaching off end
		{	
			if(hand.get(i).getValue()==hand.get(i-1).getValue()) //i-1 to check the next lowest card
				if(!(temp.get(0)==hand.get(i)))
				{
					temp.add(hand.get(i));
					//hand.remove(i);
					temp.add(hand.get(i-1));
					//hand.remove(i-1);
				}
		}
			
		
		if(!temp.isEmpty())
		{
			if((temp.size()/4)==1 || (temp.size()/6)==1)
			{
				return true;
			}
			else
			{
				return false;
			}
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
	 * @return true if straight
	 * @return false if no straight
	 */
	static void straight(Player p, ArrayList<Card> community)
	{
		ArrayList<Card> hand = new ArrayList<Card>(community);//new ArrayList<Card>;
		for(Card j : p.getHand())
			hand.add(j);
		Collections.sort(hand);
		
		
		if((hand.get(1).getValue()-hand.get(0).getValue())==1)
			if((hand.get(2).getValue()-hand.get(1).getValue())==1)
				if((hand.get(3).getValue()-hand.get(2).getValue())==1)
					if((hand.get(4).getValue()-hand.get(3).getValue())==1)
						flush(hand);
		
		if((hand.get(2).getValue()-hand.get(1).getValue())==1)
			if((hand.get(3).getValue()-hand.get(2).getValue())==1)
				if((hand.get(4).getValue()-hand.get(3).getValue())==1)
					if((hand.get(5).getValue()-hand.get(4).getValue())==1)
						flush(hand);
		
		if((hand.get(3).getValue()-hand.get(2).getValue())==1)
			if((hand.get(4).getValue()-hand.get(3).getValue())==1)
				if((hand.get(5).getValue()-hand.get(4).getValue())==1)
					if((hand.get(6).getValue()-hand.get(5).getValue())==1)
						flush(hand);
		
		
	}
	/**
	 * Determines if player has a Flush
	 * Straight Flush: Five cards in numerical order, all of identical suits.
	 * In the event of a tie: Highest rank at the top of the sequence wins.
	 * @param p player containing their hand
	 * @param community the cards available to all players
	 */
	static void flush(ArrayList<Card> hand)
	{
		
	}
	/**
	 * Determines if player has a Royal Flush
	 * The best possible straight flush is known as a royal flush, 
	 * which consists of the ace, king, queen, jack and ten of a suit.
	 * The royal flush is an unbeatable hand.
	 * @param p player containing their hand
	 * @param community the cards available to all players
	 */
	static void RFlush(ArrayList<Card> hand)
	{
	}
	/*
		still need:
		-straight - done 4-25-17 BO
		-royal flush
		-full house
		-flush
		-three of a kind
		-four of a kind
	*/
	
	
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
				d.theDeck.get(i).setValue(14);
			}
		}
	}
	
}



