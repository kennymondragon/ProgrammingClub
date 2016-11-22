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
			}
		}
	}

}
