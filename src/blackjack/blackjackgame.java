//Ben Olson
//PC
//1-27-17

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.concurrent.TimeUnit;

class blackjackgame {
	public static void main(String[] args) {
		Deck deck = new Deck();
		int playerNum = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to BlackJack! How many Players?");
		playerNum = s.nextInt();

		while (playerNum < 0 || playerNum > 5) {
			System.out.println("Unusable amount of players! Please input another amount between 0-5!");
			playerNum = s.nextInt();
			// quick check for within range
		}
		System.out.print("Please Wait...");
		System.out.print(".");

		System.out.print(".");
		System.out.print(".");

		deck.shuffleDeck();

		// Creating a list of player hands
		ArrayList<Player> players = new ArrayList<Player>(playerNum+1);
		for (int i = 0; i < playerNum+1; i++){players.add(new Player());}

		System.out.println("");
		System.out.println("\nThe deck has been shuffled, the players have been readied. Lets Play!");
		System.out.println("Rules are simple, Play to 21. Go over and you bust, go under and you might lose!");
		System.out.println("Good Luck and Have Fun!");

		//for loop to run through players and deal cards
		
		for(int i=0;i<=players.size();i++)
		{
			deck.dealCard(players.get(i));
			deck.dealCard(players.get(i));
		}
		
		for(int i=players.size();i>=0;i--)
		{
			//for loop cycles through players top down
			//because dealer is position zero

			//"var" needs to be changed to an actual String var
			while(var!="Stand"&&(players.get(i).getHandValue()<21))
			{
				//Read in S=Stand H=Hit
				//if hit||H then deal card while/check handValue<21
				//update screen to show current hand
				//if handValue>21 then player bust and move on else return to top
			}
			//String var needs to be set back to a default after player while loop
		}
	}

}
