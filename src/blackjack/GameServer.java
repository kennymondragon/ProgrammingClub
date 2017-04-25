//B Olson
//PC
//1-31-17

//package blackjack;

import java.util.ArrayList;
import java.util.Scanner;




class GameServer
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int choice = 0;
		ArrayList<String> games = new ArrayList<String>();
		games.add("Blackjack");
		games.add("Texas Hold-em");
		System.out.println("Hello, Welcome the PC Game Server!");
		System.out.println("Please choose from the following games one which you would like to play.");
		System.out.println("");
		System.out.println("GAMES");
		System.out.println("----------");
		for(int i=0;i<games.size();i++)
		{
			System.out.println((i+1)+". "+games.get(i));
		}
		System.out.println("");
		choice = s.nextInt();
		switch(choice)
		{
			case 1: blackjackgame.Game();
			case 2: texas.Game();
		};
			
		s.close();
	}
}
		