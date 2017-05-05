//Normandale Programming
//Spring 2017


public class Card implements Comparable<Card>
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
	public void setValue(int a)
	{
		value = a;
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
	public int compareTo(Card compareCard) 
	{

		int compareValue = ((Card) compareCard).getValue();

		//ascending order
		return this.value - compareValue;

		//descending order
		//return compareValue - this.value;

	}
}
