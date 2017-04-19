//Olson
//PC
//1-24-17

//package blackjack;

import java.util.ArrayList;

class Player
{
	ArrayList<Card> hand = new ArrayList<Card>();
	private int handValue=0;
	private float balance = 0;
	private float bet = 0;
	private boolean isOut = false;


	
	/**
	 * Returns an array of the players hand
	 * @return player.hand
	 */
	ArrayList<Card> getCards()
	{
		return hand;
	}
	
	/**
	 * Prints hand to console
	 */
	void printHand()
	{
		//runs a for loop to cycle through cards in hand to print
		for(int i=0;i<hand.size();i++)
		{
			System.out.println(hand.get(i));
		}
	}
	
	/**
	 * ????
	 */
	void addHandValue(Card a)
	{
			//takes in card from dealCard method and adds it to the value of the hand
			handValue = handValue + a.getValue();
	}
	
	/**
	 * ????
	 * @return
	 */
	int getHandValue()
	{
		return handValue;
	}
	
	/**
	 * ????
	 * @return
	 */
	float getBalance()
	{
		return balance;
	}
	
	/**
	 * players bet
	 * @return
	 */
	float getBet()
	{
		return bet;
	}
	
	/**
	 * Is player still in game
	 * @return
	 */
	boolean getisOut()
	{
		return isOut;
	}
	
	/**
	 * Set players bet
	 * @param a the incoming bet
	 */
	void setBet(float a)
	{
		bet = a;
	}
	
	/**
	 * Set the players balance
	 * @param a incoming balance
	 */
	void setBalance(float a)
	{
		balance = a;
	}
	
	/**
	 * ???
	 * @param newbool
	 */
	void setisOut(boolean newbool)
	{
		isOut = newbool;
	}
	
	/**
	 * ????
	 */
	void flipisOut()
	{
		isOut = !isOut;
	}
}
