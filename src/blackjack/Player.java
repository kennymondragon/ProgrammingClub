//Olson
//PC
//1-24-17


import java.util.ArrayList;

class Player
{
	ArrayList<Card> hand = new ArrayList<Card>();
	private int handValue=0;
	private float balance = 0;
	private float bet = 0;


	void printHand()
	{
		//runs a for loop to cycle through cards in hand to print
		for(int i=0;i<hand.size();i++)
		{
			System.out.println(hand.get(i));
		}
	}
	void addHandValue(Card a)
	{
			//takes in card from dealCard method and adds it to the value of the hand
			handValue = handValue + a.getValue();
	}
	int getHandValue()
	{
		return handValue;
	}
	float getBalance()
	{
		return balance;
	}
	float getBet()
	{
		return bet;
	}
	void setBet(float a)
	{
		bet = a;
	}
	void setBalance(float a)
	{
		balance = a;
	}
	

}