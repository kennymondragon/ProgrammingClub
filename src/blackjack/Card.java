//Ben Olson
//PC

package blackjack;

public class Card 
{
	private int value=0;
	private String face;
	private String suit;
	
	public Card(int val, String s,String f)
	{
		this.value = val;
		this.face = f;
		this.suit = s;
	}
	
	public int getValue()
	{
		return value;
	}
	public String getSuit()
	{
		return suit;
	}
	public String getFace()
	{
		return face;
	}
	public String toString()
	{
		return face + suit;
	}
}