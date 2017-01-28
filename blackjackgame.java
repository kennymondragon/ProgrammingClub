//Ben Olson
//PC

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
class blackjackgame
{
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		int playerNum = 1;
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to BlackJack! How many Players?");
		playerNum= playerNum + s.nextInt();
		while(playerNum<1||playerNum>6)
		{
			System.out.println("Unusable amount of players! Please input another amount between 1-6!");
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
		
		ArrayList<Player> lists = new ArrayList<Player>();
		for(int i = 0; i < playerNum; i++) 
		{
    			Player player = new Player();
    			lists.add(player);
			//creating "Hands" out of lists
		}
		
		System.out.println("");
		System.out.println("The deck has been shuffled, the players have been readied. Lets Play!");
		System.out.println("Rules are simple, Play to 21. Go over and you bust, go under and you might lose!");
		System.out.println("Good Luck and Have Fun!");

		for(int i=0;i<2;i++)
		{
			for(int f=0;f<lists.size();f++){deck.dealCard(lists.get(f));}
		}

			//should really make a player class...


		System.out.println();
		System.out.println();
		System.out.println();
		
		

		for(int i=0;i<playerNum;i++)
		{
			//outer loop dictates what player we are displaying
			if(i==0)
			{
				//If statement checks if zero for dealer
				lists.get(0).printHand();
			}
			else
			{
				lists.get(i).printHand();
			}
		}
	}

}