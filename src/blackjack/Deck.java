package blackjack;

import java.util.Collections;
import java.util.ArrayList;


public class Deck 
{
	ArrayList<Card> theDeck = new ArrayList<Card>();
	
	public Deck()
	{
		String f;
		String s;
		int v=0;
		for(int i=0;i<52;i++)
		{
			Card temp;
			switch(i/13)
			{
				case 0: s = "Spades";break;
				case 1: s = "Diamonds";break;
				case 2: s = "Clubs";break;
				case 3: s = "Hearts";break;
				default: s = "Something Broke in Switch suit";break;
			};
			switch(i%13)
			{
				case 0: f="Two of";v=2;break;
				case 1: f="Three of";v=3;break;
				case 2: f="Four of";v=4;break;
				case 3: f="Five of";v=5;break;
				case 4: f="Six of";v=6;break;
				case 5: f="Seven of";v=7;break;
				case 6: f="Eight of";v=8;break;
				case 7: f="Nine of";v=9;break;
				case 8: f="Ten of";v=10;break;
				case 9: f="Jack of";v=10;break;
				case 10: f="Queen of";v=10;break;
				case 11: f="King of";v=10;break;
				case 12: f="Ace of";v=11;break;
				default: f="Something broke in rank switch";break;
			}
			
			temp = new Card(v,s,f);
			theDeck.add(temp);
		}
	}
	
	void shuffleDeck()
	{
		Collections.shuffle(theDeck);
	}
	// when passing in an ArrayList specify the type...
	void dealCard(ArrayList<Card> a)
	{
		a.add(theDeck.get(0));
		a.remove(0);
	}

}
