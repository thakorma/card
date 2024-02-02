package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[8]; // Increase the array size to accommodate one extra card
        
        // Fill magicHand with random cards
        for (int i = 0; i < magicHand.length - 1; i++)
        {
            Card c = new Card();
            c.setValue(generateRandomValue());
            c.setSuit(Card.SUITS[generateRandomNumber(0, 3)]);
            magicHand[i] = c;
        }

        // Add one luck card (hard-coded 2 of Clubs)
        Card luckCard = new Card();
        luckCard.setValue(2);
        luckCard.setSuit(Card.SUITS[2]); // Clubs
        magicHand[7] = luckCard;
        
        // Display the magic hand
        System.out.println("Magic Hand:");
        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }

        // Ask the user for Card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a card value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.print("Enter a suit (0-3 where 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int userSuit = scanner.nextInt();
        
        // Create user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuit]);
        
        // Search magicHand for the user's card
        boolean found = false;
        for (Card card : magicHand) {
            if (card.equals(userCard)) {
                found = true;
                break;
            }
        }
        
        // Report the result
        if (found) {
            System.out.println("\nCongratulations! Your card is in the magic hand.");
        } else {
            System.out.println("\nSorry, your card is not in the magic hand.");
        }
        
        scanner.close();
    }

    // Helper method to generate a random value for the card (1-13)
    private static int generateRandomValue() {
        return generateRandomNumber(1, 13);
    }

    // Helper method to generate a random number within a specified range
    private static int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
