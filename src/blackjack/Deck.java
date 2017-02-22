//Pen Wilson
//PC
//1-27-17

//package blackjack;
import java.util.Collections;
import java.util.ArrayList;

public class Deck {
	ArrayList<Card> theDeck = new ArrayList<Card>();

	public Deck() {
		String f;
		String s;
		int v = 0;
		for (int i = 0; i < 52; i++) {
			Card temp;
			switch (i / 13) {
			case 0:
				s = "Spades";
				break;
			case 1:
				s = "Diamonds";
				break;
			case 2:
				s = "Clubs";
				break;
			case 3:
				s = "Hearts";
				break;
			default:
				s = "Something Broke in Switch suit";
				break;
			}
			;
			switch (i % 13) {
			case 0:
				f = "Ace of ";
				v = 11;
				break;
			case 1:
				f = "Two of ";
				v = 2;
				break;
			case 2:
				f = "Three of ";
				v = 3;
				break;
			case 3:
				f = "Four of ";
				v = 4;
				break;
			case 4:
				f = "Five of ";
				v = 5;
				break;
			case 5:
				f = "Six of ";
				v = 6;
				break;
			case 6:
				f = "Seven of ";
				v = 7;
				break;
			case 7:
				f = "Eight of ";
				v = 8;
				break;
			case 8:
				f = "Nine of ";
				v = 9;
				break;
			case 9:
				f = "Ten of ";
				v = 10;
				break;
			case 10:
				f = "Jack of ";
				v = 10;
				break;
			case 11:
				f = "Queen of ";
				v = 10;
				break;
			case 12:
				f = "King of ";
				v = 10;
				break;
			default:
				f = "Something broke in rank switch";
				break;
			}

			temp = new Card(v, s, f);
			theDeck.add(temp);
		}
	}

	void shuffleDeck() {
		Collections.shuffle(theDeck);
	}

	// when passing in an ArrayList specify the type...
	void dealCard(Player a) {
		a.addHandValue(theDeck.get(0)); //adds value while adding card to hand
		//if (a.getHandValue() > 21)
			//a.flipisout();
		a.hand.add(theDeck.remove(0)); //Equivalent of pop
	}
	void display()
	{
		for(int i=0;i<52;i++)
		{
			System.out.println(theDeck.get(i));
		}
	}

}
