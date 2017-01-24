package blackjack;

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

		//Creating a list of player hands
		ArrayList<ArrayList<Card>> lists = new ArrayList<ArrayList<Card>>(playerNum);
		for(int i=0;i<playerNum;i++)
			lists.add(new ArrayList<Card>());

		System.out.println("");
		System.out.println("\nThe deck has been shuffled, the players have been readied. Lets Play!");
		System.out.println("Rules are simple, Play to 21. Go over and you bust, go under and you might lose!");
		System.out.println("Good Luck and Have Fun!");

		for (int i = 0; i < playerNum; i++) {
			deck.dealCard(lists.get(i));
		}

		// for i<playernum if i = 0 then print dealer else print player hand 1-4

		for (int i = 0; i < playerNum; i++) {
			if (i == 0) {
				for (int f = 0; f < lists.get(0).size(); i++) {
					System.out.println(lists.get(0).get(f));
				}
			}
		}
	}

	public static void game() {
	}
	
}
