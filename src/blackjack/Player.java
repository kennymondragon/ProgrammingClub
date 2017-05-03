//Olson

//PC
//1-24-17

package blackjack;
import java.util.ArrayList;

class Player
{
	ArrayList<Card> hand = new ArrayList<Card>();
	private int handValue=0;
	private float balance = 0;
	private float bet = 0;
	private boolean isOut = false;
	public String handScore;


	
	/**
	 * Returns an array of the players hand
	 * @return player.hand 
	 */
	ArrayList<Card> getHand()
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
	 * this function is currently called specifically from dealCard() method
	 * @param Card a incoming Card from deal function
	 */
	void addHandValue(Card a)
	{
			handValue = handValue + a.getValue();
	}
	
	/**
	 * Function to retreive the hand value of the player
	 * @return int handValue
	 */
	int getHandValue()
	{
		return handValue;
	}
	
	/**
	 * Get Balance of Player, whats left of their "purse"
	 * @return float Balance
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
	 * kenny function
	 * @param newbool
	 */
	void setisOut(boolean newbool)
	{
		isOut = newbool;
	}
	
	/**
	 * kenny function
	 */
	void flipisOut()
	{
		isOut = !isOut;
	}
}