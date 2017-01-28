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
		playerNum = s.nextInt()+1; //Plus one because the house is always playing

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
		ArrayList<Player> players = new ArrayList<Player>(playerNum);
		for (int i = 0; i < playerNum; i++){players.add(new Player());}

		System.out.println("");
		System.out.println("\nThe deck has been shuffled, the players have been readied. Lets Play!");
		System.out.println("Rules are simple, Play to 21. Go over and you bust, go under and you might lose!");
		System.out.println("Good Luck and Have Fun!");

		
		//game(deck, players);
		for (int i = 0; i < playerNum; i++) {
			deck.dealCard(players.get(i));
		}
		for(int i=0;i<players.size();i++)
		{
			System.out.println(players.get(i).printHand() +" "+ players.get(i).printHand());
		}
	}

}
