import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        P1Random rng = new P1Random();
        int pCard; //player card
        int pHand; //player hand
        int dHand; //dealer hand
        int numGame = 1; //number of games
        int numChoice = 0; //menu choice
        int pWins = 0; //player wins
        int dWins = 0; //dealer wins
        int tieGames = 0; //tie games

            while (numChoice != 4) { //while user had not exited game...
                    System.out.println("START GAME #" + numGame);
                    pHand = 0;
                    pCard = rng.nextInt(13) + 1;
                    if (pCard == 1) System.out.println("Your card is a ACE!");
                    else if (pCard == 11) System.out.println("Your card is a JACK!");
                    else if (pCard == 12) System.out.println("Your card is a QUEEN!");
                    else if (pCard == 13) System.out.println("Your card is a KING!");
                    else System.out.println("Your card is a " + pCard + "!");
                        if (pCard > 10) pCard = 10;
                        pHand = pHand + pCard;
                        System.out.println("Your hand is: " + pHand + "\n");
                    do {
                    //repeat code so I can jump back to this point in the loop
                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");
                    System.out.print("\nChoose an option: ");
                    numChoice = s.nextInt();

                    switch (numChoice) {
                        case 1:
                            //new card & hand, if 21: Blackjack, if >21: player loses
                            pCard = rng.nextInt(13) + 1;
                            if (pCard == 1) System.out.println("Your card is a ACE!");
                            else if (pCard == 11) System.out.println("Your card is a JACK!");
                            else if (pCard == 12) System.out.println("Your card is a QUEEN!");
                            else if (pCard == 13) System.out.println("Your card is a KING!");
                            else System.out.println("Your card is a " + pCard + "!");
                            if (pCard > 10) pCard = 10;
                            pHand = pHand + pCard;
                            System.out.println("Your hand is: " + pHand + "\n");
                            if (pHand == 21) {
                                System.out.println("BLACKJACK! You win!\n");
                                pWins++;
                                numGame++;
                                numChoice = 2;
                            }
                            else if (pHand > 21) {
                                System.out.println("\nYou exceeded 21! You lose.\n");
                                dWins++;
                                numGame++;
                                numChoice = 2;
                            }
                            else continue;
                            break;
                        case 2:
                            //hold hand
                            numGame++;
                            dHand = rng.nextInt(11) + 16;
                            System.out.println("\nDealer's hand: " + dHand);
                            System.out.println("Your hand is: " + pHand);
                            if (pHand > dHand) {
                                System.out.println("You win!\n");
                                pWins++;
                            } else if (dHand > 21) {
                                System.out.println("You win!\n");
                                pWins++;
                            } else if (pHand == dHand) {
                                System.out.println("It's a tie! No one wins!\n");
                                tieGames++;
                            } else {
                                System.out.println("Dealer wins!\n");
                                dWins++;
                            }
                            break;
                        case 3:
                            //Stats
                            System.out.println("\nNumber of Player wins: " + pWins);
                            System.out.println("Number of Dealer wins: " + dWins);
                            System.out.println("Number of tie games: " + tieGames);
                            System.out.println("Total # of games played is: " + --numGame);
                            java.lang.String perWins = String.format ("%.1f", (float)((pWins*100)/numGame));
                            System.out.println("Percentage of Player wins: " +perWins+ "%\n");
                            numGame++;
                            numChoice = 1;
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("\nInvalid input!\nPlease enter an integer value between 1 and 4.\n");
                            break;
                        }
                    }
                    while (numChoice < 2 || numChoice > 4);
        }
    }
}