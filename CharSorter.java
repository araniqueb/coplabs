import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        int choice = 0;
        boolean a = true;

        System.out.println("Welcome to Character Sorter Program");
        System.out.println("Please input a string to be sorted");
        String userSort = scnr.nextLine();
        System.out.println();

        while (a = true) {
        System.out.println("Please select the option you would like to see");
        System.out.println();


        System.out.println("1. Display character frequencies alphabetically");
        System.out.println("2. Display sorted frequencies");
        System.out.println("3. Show types of character frequencies");
        System.out.println("4. Exit");
        //choice = scnr.nextInt();
            try {
                String input = scnr.next();
                choice = Integer.parseInt(input);
            } catch(Exception e) {
                System.out.println("Error, bad input, please input a number 1-4");
                System.out.println();
                continue;
            }



            switch (choice) {
            case 1: {
                char[] charArray = userSort.toCharArray();
                char tempChar;
                for (int i = 0; i < charArray.length; i++) {
                    for (int j = 0; j < charArray.length; j++) {
                        if (charArray[i] < charArray[j]) {
                            tempChar = charArray[i];
                            charArray[i] = charArray[j];
                            charArray[j] = tempChar;
                        }
                    }
                }
                String sortedString = "";
                for (int i = 0; i < charArray.length; i++) {
                    userSort += charArray[i];
                }
                System.out.println(sortedString + "\n");
                int counter;
                sortedString = "";

                for (int i = 0; i < charArray.length; i++) {
                    counter = 0;
                    for (int j = 0; j < charArray.length; j++) {
                        if (charArray[i] == charArray[j]) {
                            counter++;
                        }
                    }
                    if (!sortedString.contains("Char: " + charArray[i])) {
                        if (sortedString.equals("")) {
                            sortedString += " " + charArray[i] + " freq: " + counter + "\n";
                        } else {
                            sortedString += " " + charArray[i] + " freq: " + counter + "\n";

                        }
                    }
                }
                    System.out.println(sortedString);
                System.out.println("");
                a = true;
                }

            break;

            case 2: {
                int n = userSort.length();
                List<Character>[] res = new ArrayList[n + 1];
                int[] cnt = new int[128];
                char[] ss = userSort.toCharArray();
                for (int i = 0; i < n; ++i) {
                    res[i + 1] = new ArrayList<>();
                    cnt[ss[i]]++;
                }
                    for (int i = 0; i < 128; ++i) {
                        if (cnt[i] != 0) {
                            res[cnt[i]].add((char) i);
                        }
                    }
                       int i=0;
                        for (i = n; i > 0; --i) {
                            if (!res[i].isEmpty()) {
                                for (char c : res[i])
                                    System.out.println(c + " freq: " + i);
                                System.out.println("");
                            }
                            }
                        }

a = true;


                break;

            case 3: {

               int whiteSpace = 0;
                int textual = 0;
                int numerical = 0;
                int symbols = 0;

                System.out.println("The sorted by frequency characters are: ");

                char[] data = userSort.toCharArray();
                Arrays.sort( data );

                Map<Character, Integer> countMap = new LinkedHashMap<>();
                for ( char c : data ) {
                    if ( countMap.containsKey( c ) ) {
                        countMap.put( c, countMap.get( c ) + 1 );
                    } else {
                        countMap.put( c, 1 );
                    }
                }

                for ( Map.Entry<Character, Integer> e : countMap.entrySet() ) {

                    char key = e.getKey();
                    //System.out.printf( "%c -> %d occurences\n", e.getKey(), e.getValue() );

                    if ((key >= 'a' && key <= 'z') || (key >= 'A' && key <= 'Z')) {
                        textual += e.getValue();
                    } else if (key >= '0' && key <= '9') {
                        numerical += e.getValue();
                    } else if (key == ' ') {
                        whiteSpace += e.getValue();
                    } else {
                        symbols += e.getValue();
                    }

                }
                    System.out.printf("Textual Characters count: %d\n", textual);
                    System.out.printf("Numerical Characters count: %d\n", numerical);
                    System.out.printf("Whitespace Characters count: %d\n", whiteSpace);
                    System.out.printf("Symbol Characters count: %d\n", symbols);
                    System.out.println("");
            }
           a = true;

               break;

            case 4:
                System.out.println("Character Sorter Exited Successfully");
               return;

        }
        }

        }
    }

