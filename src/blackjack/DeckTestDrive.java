package blackjackKen;

public class DeckTestDrive 
{
	public static void main()
	{
		Deck deck1 = new Deck();
	
		for(int i=0;i<52;i++)
		{
			System.out.println(deck1.theDeck.get(i));
		}
		deck1.shuffleDeck();
		System.out.println(">>>");
		for(int i=0;i<52;i++)
		{
			System.out.println(deck1.theDeck.get(i));
		}
	}
}
