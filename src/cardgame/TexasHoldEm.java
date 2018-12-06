//package cardgame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class TexasHoldEm {
	static void Game() {
		String[] args = new String[6];
		
		String Q = " ";
		boolean gameStatus = true;
		Scanner s = new Scanner(System.in);
		
		while (gameStatus == true) {
			TexasHoldEm.main(args);

			System.out.println("Would you like to play again?");
			System.out.println();
			Q = s.next();
			if (Q.equals("no") || Q.equals("n") || Q.equals("NO") || Q.equals("No")) {
				gameStatus = false;
				GameServer.main(args);
			}	
		}

		s.close();
	}

	
	public static void main(String[] args) {
		ArrayList<Card> community = new ArrayList<Card>(); //community cards, players will compare hand to
		ArrayList<Card> burnpile = new ArrayList<Card>(); // burn pile, discard pile
		List <Player> numPlayer = new ArrayList<Player>();
		
		Deck deck = new Deck();
		Scanner userInput = new Scanner(System.in);
		Player dealer = new Player();
		Player dealerTwo = new Player();
		
		
		int playerCount;
		String name;
		
		System.out.println("Enter total amount of players (2-7 players)");
		playerCount = userInput.nextInt();//user enters total amount of players 
		
		for(int i  = 0; i < playerCount; i++) {
	
			numPlayer.add(new Player());// total player count
		
		}
		
		System.out.println("Total number of players is " + numPlayer.size());
		
		updateDeck(deck); //update deck values throughout game
		deck.shuffleDeck();
		
	
		for(int j = 0; j < 2; j++){// deal each player 2 cards 
			
			for(int i = numPlayer.size()-1; i >= 0; i--){// deal card to each player
			
				
			deck.dealCard(numPlayer.get(i));
			}// end of first for loop 
		
		}
		
		burnpile.add(deck.getCard());
		community.add(deck.getCard());
		community.add(deck.getCard());
		community.add(deck.getCard());
		
		Scanner firstPlayer = new Scanner(System.in);
		String input;
		
		for( int  j = 0; j < 3; j++) {// number of rounds
			for(int i = 0; i < numPlayer.size(); i++) {// going through the total players 
		
				System.out.println(" Community cards \n" +"---------------\n" + community);
				System.out.println("\n Player's Cards:" + "\n ---------------------------------------"); 
			
			for(Card pOne : numPlayer.get(i).hand){//this looks for specific index of player, and receives hand of player
				System.out.println(pOne);
				} // showing player's card 
			
			
			System.out.println("\nWould you like to .....(Enter first letter of choice)" + "\n Call (match the bet of the previous player) " +
				"\n Raise(bet an amount doubled or higher than previous plaer) " + "\n Fold (end your participation in game)"); // players options 
				
			dealer = numPlayer.get(i);// equal dealer to specific index of player array 
			
			playerChoice(dealer, deck, community, firstPlayer); // calls the players options 
				
			if(dealer.getIsOut() == true) {//checks to see if  player has folded 
			 numPlayer.remove(i); // removes player if they fold 
				}
		   
			}//end of for loop running through players
			
		}// end of rounds for loop
		
	}// end of main method

	

	static void playerChoice(Player dealer, Deck deck, ArrayList<Card> community, Scanner firstPlayer){// this method will take a player object, deck, community arraylist, first player scanner
		 String input;// in the parameter in order to execute the code inside 
		do {	
			
			 input=firstPlayer.nextLine();
			switch(input)
			{
				case "c" :	
					community.add(deck.getCard()); 
					break ;
				case "C" :	
					community.add(deck.getCard());
					break;
					
				case "r":
					dealer.setisOut(true);
					break;
				
				case "R":
					dealer.setisOut(true);
					break;	
				
				case "f":
					dealer.setisOut(true);
					break;		
				
				case "F":
				 dealer.setisOut(true);
					break;
						
				default:
					System.out.println("Invalid input...");
					break;
			}

		 }while (!input.equals("c")&&!input.equals("C")&&!input.equals("r")&&!input.equals("R")&&!input.equals("f")&&!input.equals("F")); // this is repeating while user does not enter proper value indicated  
			
	}

	

	static void updateDeck(Deck d) {
		for (int i = 0; i < 52; i++) {
			if ((i % 13) == 10) {
				d.theDeck.get(i).setValue(11);
			} else if ((i % 13) == 11) {
				d.theDeck.get(i).setValue(12);
			} else if ((i % 13) == 12) {
				d.theDeck.get(i).setValue(13);
			} else if ((i % 13) == 0) {
				d.theDeck.get(i).setValue(14);
			}
		}
	}

}// class
