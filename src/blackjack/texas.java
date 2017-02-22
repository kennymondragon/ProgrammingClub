class texas
{
	void game()
	{
	}
	
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		
		updateDeck(deck);
		
		deck.display();
		
		
	}
	
	
	static void updateDeck(Deck d)
	{
		for(int i=0;i<52;i++)
		{
			if(((i%10)==1)&& d.theDeck.get(i).getValue()!=11)
			{
				d.theDeck.get(i).setValue(11);
			}
			else if(((i%10)==2)&& d.theDeck.get(i).getValue()!=2)
			{
				d.theDeck.get(i).setValue(12);
			}
			else if(((i%10)==3)&& d.theDeck.get(i).getValue()!=3)
			{
				d.theDeck.get(i).setValue(13);
			}
		}
	}
	
}

//initialize deck
//reset card values so that A=1 K=13 Q=12 J=11
// suit values should be 0-3
// Arraylist of poker hands, sorted to be greatest to least top down
/* game is played by the players each getting two cards, 
the two players to the left of the dealer put up the big and small blinds
the players bet, the dealer then deals 3 as community, 
then each player bets again, dealer deals 1, round of betting, then the dealer deals the last card the river, 
then the showdown and last bet take place.

the idea is to have the best 5 card hand out of the two dealt and the community cards

*/



