//package cardgame;

//Programming Club 2017
//texas holdem style poker game


import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Arrays; appears to be unused

class texas {
	static void Game() {
		String[] args = new String[6];
		String Q = " ";
		boolean gameStatus = true;
		Scanner s = new Scanner(System.in);
		while (gameStatus == true) {
			texas.main(args);

			System.out.println("Would you like to play again?");
			System.out.println();
			Q = s.next();
			if (Q.equals("no") || Q.equals("n") || Q.equals("NO") || Q.equals("No")) {
				gameStatus = false;
				GameServer.main(args);
			}	
		}

		s.close();
	}

	public static void main(String[] args) {
		ArrayList<Card> community = new ArrayList<Card>(); // community cards
		ArrayList<Card> burnpile = new ArrayList<Card>();	// that people
															// compare their
															// hand to
		Deck deck = new Deck();
		Player player = new Player();
		Player dealer = new Player();

		updateDeck(deck); // update card values to be able to play the game

		deck.shuffleDeck();

		deck.dealCard(player);
		deck.dealCard(dealer);
		deck.dealCard(player);
		deck.dealCard(dealer);
		
		
		System.out.println("");
		Scanner s = new Scanner(System.in);
		String input;
		
		burnpile.add(deck.getCard());
		community.add(deck.getCard());
		community.add(deck.getCard());
		community.add(deck.getCard());
		
		
		System.out.println("Your Cards:");
		for(Card c : player.hand)
		{
			System.out.println(c);
		}
		System.out.println("Would you like to call, raise or fold?");
		input = s.nextLine();
		
		//if statement the following for fold right away, putting isout at true
		
		if(((input == "f")||(input == "F"))==true)
		{
			player.setisOut(true);
		}
		else
		{
			System.out.println("");
			System.out.println("These are the community cards as the dealer turns them:");
			for(Card c : community)
			{
				for(int i=100000000;i>0;i--){}
				System.out.println(c);
				for(int i=100000000;i>0;i--){}
				for(int i=100000000;i>0;i--){}
				for(int i=100000000;i>0;i--){}
			}
		}
		
		boolean flag = false;
		while((player.getIsOut() == false)||(flag == false))
		{
			/*System.out.println("Your Cards:");
			for(Card c : player.hand)
			{
				System.out.println(c);
			}*/
			System.out.println("");
			for(Card c : community)
			{
				System.out.println(c);
			}
		
			System.out.println("Would you like to call, raise or fold?");
			input = s.nextLine();
			switch(input)
			{
				case "c" :	
					community.add(deck.getCard()); 
					break ;
				case "C" :	
					community.add(deck.getCard());
					break;
					
				case "r":
					community.add(deck.getCard());
					break;
				
				case "R":
					community.add(deck.getCard());
					break;	
				
				case "f":
					player.setisOut(true);
					break;		
				
				case "F":
					player.setisOut(true);
					break;
						
				default:
					System.out.println("Invalid input...");
					break;
			}
			if(community.size() == 5)
				flag = true;
		}


	}
	/*
	 * static void checkHand(Player a,ArrayList b) { a.hand.addAll(b);
	 * Collections.sort(a.hand); }
	 */

	/**
	 * Checks on all the scoring functions, throws errors if they do not work
	 * correctly.
	 */
	static void checkScoringFunctions() {

	}

	/**
	 * Takes a player and the community deck and updates player classes scores.
	 * 
	 * @param p
	 *            Player
	 * @param community
	 *            Array of community cards
	 */
	static void scorePlayer(Player p, ArrayList<Card> community) {
		ArrayList<Card> hand = new ArrayList<Card>(community);
		for (Card i : p.getHand())
			hand.add(i);
		Collections.sort(hand);

		// Making arrays of each suit
		ArrayList<Card> clubs = new ArrayList<Card>();
		ArrayList<Card> spades = new ArrayList<Card>();
		ArrayList<Card> hearts = new ArrayList<Card>();
		ArrayList<Card> diamonds = new ArrayList<Card>();

		for (Card i : hand)
			if (i.getSuit() == "Clubs")
				clubs.add(i);
			else if (i.getSuit() == "Spades")
				spades.add(i);
			else if (i.getSuit() == "Diamonds")
				diamonds.add(i);
			else if (i.getSuit() == "Hearts")
				hearts.add(i);

		ArrayList<ArrayList<Card>> suits = new ArrayList<ArrayList<Card>>();
		suits.add(clubs);
		suits.add(spades);
		suits.add(diamonds);
		suits.add(hearts);

		// Royal Flush Check
		for (ArrayList<Card> i : suits) {
			if (i.size() >= 5) {
				if (i.get(i.size() - 1).getValue() == 14 && i.get(i.size() - 2).getValue() == 13
						&& i.get(i.size() - 3).getValue() == 12 && i.get(i.size() - 4).getValue() == 11
						&& i.get(i.size() - 5).getValue() == 10) {
					p.handScore = "RFlush";
					return;
				}
			}

		}
		// Straight Flush BROKE
		for (int i = 0; i <= 2; i++) {
			if (hand.get(6 - i).getValue() == 14 && hand.get(6 - i).getSuit() == hand.get(5 - i).getSuit()
					&& hand.get(5 - i).getValue() == 13 && hand.get(5 - i).getSuit() == hand.get(4 - i).getSuit()
					&& hand.get(4 - i).getValue() == 12 && hand.get(4 - i).getSuit() == hand.get(3 - i).getSuit()
					&& hand.get(3 - i).getValue() == 11 && hand.get(3 - i).getSuit() == hand.get(2 - i).getSuit()
					&& hand.get(2 - i).getValue() == 10 && hand.get(2 - i).getSuit() == hand.get(3 - i).getSuit()) {
				p.handScore = "sFlush";
				return;
			}
		}
		// Four of a kind
		int count = 0;
		for (int i = hand.size() - 1; i > 3; i--) {
			if (hand.get(i).getValue() == hand.get(i - 1).getValue()
					&& hand.get(i).getValue() == hand.get(i - 2).getValue()
					&& hand.get(i).getValue() == hand.get(i - 3).getValue()) {
				p.handScore = "threeKind";
				return;
			}
		}
		// Full House
		count = 0;
		Boolean threeCards = false;
		String threeSuit = new String("");
		for (int i = hand.size() - 1; i > 2; i--) {
			if (hand.get(i).getValue() == hand.get(i - 1).getValue()
					&& hand.get(i).getValue() == hand.get(i - 2).getValue()) {
				threeCards = true;
				threeSuit = hand.get(i).getSuit();
			}
		}
		if (threeCards) {
			count = 0;
			for (int i = hand.size() - 1; i > 0; i--) {
				if (hand.get(i).getValue() == hand.get(i - 1).getValue() && hand.get(i).getSuit() != threeSuit)
					count += 1;
				if (count == 2) {
					p.handScore = "twoPair";
					return;
				}
			}
		}

		// Flush
		for (ArrayList<Card> i : suits)
			if (i.size() >= 5) {
				p.handScore = "flush";
				return;
			}
		// Straight

		// Three of a kind
		count = 0;
		for (int i = hand.size() - 1; i > 2; i--) {
			if (hand.get(i).getValue() == hand.get(i - 1).getValue()
					&& hand.get(i).getValue() == hand.get(i - 2).getValue()) {
				p.handScore = "threeKind";
				return;
			}
		}
		// Two pair
		count = 0;
		for (int i = hand.size() - 1; i > 0; i--) {
			if (hand.get(i).getValue() == hand.get(i - 1).getValue())
				count += 1;
			if (count == 2) {
				p.handScore = "twoPair";
				return;
			}
		}

		// Pair
		for (int i = hand.size() - 1; i > 0; i--)
			if (hand.get(i).getValue() == hand.get(i - 1).getValue()) {
				p.handScore = "pair";
				return;
			}

		// High Card
	}

	/**
	 * Determines if given cards have a pair
	 *
	 * @param hand
	 *            Array of cards
	 * @return true if pairs, false otherwise
	 */
	static boolean pair(ArrayList<Card> hand) {
		for (int i = hand.size() - 1; i >= 1; i--)
			// i-1 to check the next lowest card
			if (hand.get(i).getValue() == hand.get(i - 1).getValue())
				return true;

		return false;
	}

	/**
	 * Determines if player has two pair
	 * 
	 * @param p
	 *            player containing their hand
	 * @param community
	 *            the cards available to all players
	 * @return true if has two pair
	 * @return false if no two pair
	 */
	static boolean TwoPair(Player p, ArrayList<Card> community) {
		ArrayList<Card> temp = new ArrayList<Card>();

		ArrayList<Card> hand = new ArrayList<Card>(community);// new
																// ArrayList<Card>;
		for (Card j : p.getHand())
			hand.add(j);
		Collections.sort(hand);

		for (int i = hand.size() - 1; i >= 1; i--) // size-1 to start at end of
													// array, i>0 to avoid
													// reaching off end
		{
			if (hand.get(i).getValue() == hand.get(i - 1).getValue()) // i-1 to
																		// check
																		// the
																		// next
																		// lowest
																		// card
			{
				temp.add(hand.get(i));
				// hand.remove(i);
				temp.add(hand.get(i - 1));
				// hand.remove(i-1);
			}
		}
		for (int i = hand.size() - 1; i >= 1; i--) // size-1 to start at end of
													// array, i>0 to avoid
													// reaching off end
		{
			if (hand.get(i).getValue() == hand.get(i - 1).getValue()) // i-1 to
																		// check
																		// the
																		// next
																		// lowest
																		// card
				if (!(temp.get(0) == hand.get(i))) {
					temp.add(hand.get(i));
					// hand.remove(i);
					temp.add(hand.get(i - 1));
					// hand.remove(i-1);
				}
		}

		if (!temp.isEmpty()) {
			if ((temp.size() / 4) == 1 || (temp.size() / 6) == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	/**
	 * Determines if player has a straight
	 * 
	 * @param p
	 *            player containing their hand
	 * @param community
	 *            the cards available to all players
	 * @return true if straight
	 * @return false if no straight
	 */
	static void straight(Player p, ArrayList<Card> community) {
		ArrayList<Card> temp = new ArrayList<Card>(community);// new
																// ArrayList<Card>;
		for (Card j : p.getHand())
			temp.add(j);
		Collections.sort(temp);

		if ((temp.get(1).getValue() - temp.get(0).getValue()) == 1)
			if ((temp.get(2).getValue() - temp.get(1).getValue()) == 1)
				if ((temp.get(3).getValue() - temp.get(2).getValue()) == 1)
					if ((temp.get(4).getValue() - temp.get(3).getValue()) == 1)
						flush(p,temp);

		if ((temp.get(2).getValue() - temp.get(1).getValue()) == 1)
			if ((temp.get(3).getValue() - temp.get(2).getValue()) == 1)
				if ((temp.get(4).getValue() - temp.get(3).getValue()) == 1)
					if ((temp.get(5).getValue() - temp.get(4).getValue()) == 1)
						flush(p,temp);

		if ((temp.get(3).getValue() - temp.get(2).getValue()) == 1)
			if ((temp.get(4).getValue() - temp.get(3).getValue()) == 1)
				if ((temp.get(5).getValue() - temp.get(4).getValue()) == 1)
					if ((temp.get(6).getValue() - temp.get(5).getValue()) == 1)
						flush(p,temp);

	}

	/**
	 * Determines if player has a Flush.
	 * Straight Flush: Five cards in (bi)numerical
	 * order, all of identical suit. In the event of a tie: Highest rank at the
	 * top of the sequence wins.
	 * 
	 * @param p
	 *            player object containing their hand
	 * @param community
	 *            the cards available to all players
	 */
	static void flush(Player p, ArrayList<Card> community)
	{
		ArrayList<Card> temp = new ArrayList<Card>(community);// new
																// ArrayList<Card>;
		for (Card j : p.getHand())
			temp.add(j);
		Collections.sort(temp);

		if ((temp.get(1).getValue() - temp.get(0).getValue()) == 1)
			if ((temp.get(2).getValue() - temp.get(1).getValue()) == 1)
				if ((temp.get(3).getValue() - temp.get(2).getValue()) == 1)
					if ((temp.get(4).getValue() - temp.get(3).getValue()) == 1)
						flush(p,temp);

		if ((temp.get(2).getValue() - temp.get(1).getValue()) == 1)
			if ((temp.get(3).getValue() - temp.get(2).getValue()) == 1)
				if ((temp.get(4).getValue() - temp.get(3).getValue()) == 1)
					if ((temp.get(5).getValue() - temp.get(4).getValue()) == 1)
						flush(p,temp);

		if ((temp.get(3).getValue() - temp.get(2).getValue()) == 1)
			if ((temp.get(4).getValue() - temp.get(3).getValue()) == 1)
				if ((temp.get(5).getValue() - temp.get(4).getValue()) == 1)
					if ((temp.get(6).getValue() - temp.get(5).getValue()) == 1)
						flush(p,temp);
	}

	/**
	 * Determines if player has a Royal Flush The best possible straight flush
	 * is known as a royal flush, which consists of the ace, king, queen, jack
	 * and ten of a suit. The royal flush is an unbeatable hand.
	 * 
	 * @param p
	 *            player containing their hand
	 * @param community
	 *            the cards available to all players
	 */
	static void RFlush(ArrayList<Card> hand) {
	}
	/*
	 * still need: -straight - done 4-25-17 BO -royal flush -full house -flush
	 * -three of a kind -four of a kind
	 */

	/**
	 * Updates the Ace,King,Queen,Jack to respective numbers in the deck
	 * 
	 * @param Deck
	 *            d incoming operating deck
	 */
	static void updateDeck(Deck d) {
		for (int i = 0; i < 52; i++) {
			if ((i % 13) == 10) {
				d.theDeck.get(i).setValue(11);
			} else if ((i % 13) == 11) {
				d.theDeck.get(i).setValue(12);
			} else if ((i % 13) == 12) {
				d.theDeck.get(i).setValue(13);
			} else if ((i % 13) == 0) {
				d.theDeck.get(i).setValue(14);
			}
		}
	}

}
