package blackjackKen;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.concurrent.TimeUnit;

class blackjackgame
{
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		int playerNum = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to BlackJack! How many Players?");
		playerNum=s.nextInt();
		
		while(playerNum<0||playerNum>5)
		{
			System.out.println("Unusable amount of players! Please input another amount between 0-5!");
			playerNum = s.nextInt();
			//quick check for within range
		}
		System.out.print("Please Wait...");
		System.out.print(".");
		for(int i=0;i<500000000;i++){} //give some wait time
		for(int i=0;i<500000000;i++){} //give some wait time
		System.out.print(".");
		for(int i=0;i<500000000;i++){} //give some wait time
		for(int i=0;i<500000000;i++){} //give some wait time
		System.out.print(".");
		for(int i=0;i<500000000;i++){} //give some wait time
		for(int i=0;i<500000000;i++){} //give some wait time
		
		deck.shuffleDeck();
		
		// when declaring and initializing an ArrayList specify the type...
		ArrayList<ArrayList<Card>> lists = new ArrayList<ArrayList<Card>>();
		for(int i = 0; i < playerNum; i++) 
		{
			// Adding Card Array to Array of Arrays I.E Hands
			// when declaring and initializing an ArrayList specify the type...
    			ArrayList<Card> list = new ArrayList<Card>();
    			lists.add(list);
			//creating "Hands" out of lists
		}
		
		System.out.println("");
		System.out.println("The deck has been shuffled, the players have been readied. Lets Play!");
		System.out.println("Rules are simple, Play to 21. Go over and you bust, go under and you might lose!");
		System.out.println("Good Luck and Have Fun!");

		for(int i=0;i<playerNum;i++)
		{

			deck.dealCard(lists.get(i));
		}
		
		//for i<playernum if i = 0 then print dealer else print player hand 1-4

		for(int i=0;i<playerNum;i++)
		{
			if(i==0)
			{
				for(int f=0;f<lists.get(0).size();i++)
				{
					System.out.println(lists.get(0).get(f));
				}
			}
		}
	}

}
