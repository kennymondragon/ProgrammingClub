package cardgame.application;

import cardgame.BlackJackGame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printPrompt();

        System.out.print("Enter a number: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number: ");
            scanner.next();
        }git 
        int game = scanner.nextInt();
        switch (game) {
            case 1:
                BlackJackGame.main(args);
                break;
            default:
                System.out.println("Game not found");
                break;
        }

        System.out.println("Exiting.");
    }

    public static void printPrompt() {
        System.out.println("Select a game: \n1) Blackjack");
    }

}
