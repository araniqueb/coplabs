import java.util.Random;
import java.util.Scanner;

public class Blackjack {

    public static class P1Random
    {
        private long next;

        public P1Random()
        {
            next = 0;
        }

        private short nextShort()
        {
            return nextShort(Short.MAX_VALUE);
        }

        private short nextShort(short limit)
        {
            next = next * 1103515245 + 12345;
            return (short) Math.abs(((next / 65536) % limit));
        }

        private int nextInt()
        {
            return nextInt(Integer.MAX_VALUE);
        }

        public int nextInt(int limit)
        {
            return ((((int) nextShort()) << 16) | ((int) nextShort())) % limit;
        }

        private double nextDouble()
        {
            return (double) nextInt() / (double) Integer.MAX_VALUE;
        }
    }


    public static void main(String[] args) {


        Scanner scnr = new Scanner(System.in);

        int choice = 0;
        boolean b = true;
        boolean a = true;
        int firstCard = 0;
        int game = 0;
        int playerWins = 0;
        int dealerWins = 0;
        int tieGames = 0;
        P1Random rng = new P1Random();
        game++;
        int gamesEnded =0;


        while (b == true) {


            int hand = 0;
            int dealerHand= 0;
            a = true;
            System.out.println("START GAME #" + game);
            System.out.println();
            firstCard = rng.nextInt(13) + 1;
            switch (firstCard) {
                case 1:
                    System.out.println("Your card is a ACE!");
                    hand = hand + 1;
                    break;

                case 2:
                    System.out.println("Your card is a 2!");
                    hand = hand + 2;
                    break;

                case 3:
                    System.out.println("Your card is a 3!");
                    hand = hand + 3;
                    break;

                case 4:
                    System.out.println("Your card is a 4!");
                    hand = hand + 4;
                    break;

                case 5:
                    System.out.println("Your card is a 5!");
                    hand = hand + 5;
                    break;

                case 6:
                    System.out.println("Your card is a 6!");
                    hand = hand + 6;
                    break;

                case 7:
                    System.out.println("Your card is a 7!");
                    hand = hand + 7;
                    break;

                case 8:
                    System.out.println("Your card is a 8!");
                    hand = hand + 8;
                    break;

                case 9:
                    System.out.println("Your card is a 9!");
                    hand = hand + 9;
                    break;

                case 10:
                    System.out.println("Your card is a 10!");
                    hand = hand + 10;
                    break;

                case 11:
                    System.out.println("Your card is a JACK!");
                    hand = hand + 10;
                    break;

                case 12:
                    System.out.println("Your card is a QUEEN!");
                    hand = hand + 10;
                    break;

                case 13:
                    System.out.println("Your card is a KING!");
                    hand = hand + 10;
                    break;
            }
            System.out.println("Your hand is: " + hand);
            System.out.println();

            while (a == true) {


                //CHOICES
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println();
                System.out.print("Choose an option: " );
                System.out.print("");
                System.out.println();
                try {
                  String input = scnr.next();
                    choice = Integer.parseInt(input);
                } catch(Exception e) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                    System.out.println();
                    continue;
                }



                if (choice == 1) {
                    firstCard = rng.nextInt(13) + 1;
                    switch (firstCard) {
                        case 1:
                            System.out.println("Your card is a ACE!");
                            hand = hand + 1;
                            break;

                        case 2:
                            System.out.println("Your card is a 2!");
                            hand = hand + 2;
                            break;

                        case 3:
                            System.out.println("Your card is a 3!");
                            hand = hand + 3;
                            break;

                        case 4:
                            System.out.println("Your card is a 4!");
                            hand = hand + 4;
                            break;

                        case 5:
                            System.out.println("Your card is a 5!");
                            hand = hand + 5;
                            break;

                        case 6:
                            System.out.println("Your card is a 6!");
                            hand = hand + 6;
                            break;

                        case 7:
                            System.out.println("Your card is a 7!");
                            hand = hand + 7;
                            break;

                        case 8:
                            System.out.println("Your card is a 8!");
                            hand = hand + 8;
                            break;

                        case 9:
                            System.out.println("Your card is a 9!");
                            hand = hand + 9;
                            break;

                        case 10:
                            System.out.println("Your card is a 10!");
                            hand = hand + 10;
                            break;

                        case 11:
                            System.out.println("Your card is a JACK!");
                            hand = hand + 10;
                            break;

                        case 12:
                            System.out.println("Your card is a QUEEN!");
                            hand = hand + 10;
                            break;

                        case 13:
                            System.out.println("Your card is a KING!");
                            hand = hand + 10;
                            break;
                    }

                    System.out.println("Your hand is: " + hand);
                    System.out.println();

                    if (hand > 21) {
                        System.out.println("You exceeded 21! You lose.");
                        dealerWins++;
                        game++;
                        gamesEnded++;
                        System.out.println();
                        a= false;

                    }
                    if (hand == 21) {
                        System.out.println("BLACKJACK! You win!");
                        System.out.println();
                        game++;
                        gamesEnded++;
                        a = false;
                        playerWins++;
                    }



                } else if (choice == 2) {
                    dealerHand = rng.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + hand);
                    System.out.println();

                    if (dealerHand > 21) {
                        System.out.println("You win!");
                        System.out.println();
                        game++;
                        gamesEnded++;
                        playerWins++;
                        a = false;

                    }
                    if (hand == dealerHand) {
                        System.out.println("It's a tie! No one wins!");
                        System.out.println();
                        game++;
                        gamesEnded++;
                        tieGames = tieGames + 1;
                        a = false;
                    }
                     if (hand > dealerHand) {
                         System.out.println("You win!");
                         System.out.println();
                         game++;
                         gamesEnded++;
                         a = false;
                     }
                         else if ((dealerHand > hand) && (dealerHand <= 21)) {
                             System.out.println("Dealer wins!");
                             dealerWins++;
                         game++;
                         gamesEnded++;
                             System.out.println();
                             a = false;

                    }


                    } else if (choice == 3) {
                    System.out.println("Number of Player wins: " + playerWins);
                    System.out.println("Number of Dealer wins: " + dealerWins);
                    System.out.println("Number of tie games: " + tieGames);
                    System.out.println("Total # of games played is: " + gamesEnded);
                    System.out.print("Percentage of Player wins: " + (float) ((playerWins * 100)) / gamesEnded);
                    System.out.println("%");
                    System.out.println();

                } else if (choice == 4) {
                    System.exit(0);
                    a = false;
                    b= false;

                } else {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                    System.out.println();
                }

            }
        }
    }



}









