import java.util.Scanner;
import java.util.*;
import java.lang.*;

public class RLE {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        String rleString = "";
        boolean a = true;
        int option = 0;

        while (a = true) {
            System.out.println("What would you like to do?");
            System.out.println("1.Input string to be encoded");
            System.out.println("2.View encoded string");
            System.out.println("3.View decoded string");
            System.out.println("4.Exit program");
            System.out.print("Option: ");
            try {
                String input = scnr.next();
                option = Integer.parseInt(input);
            } catch(Exception e) {
                System.out.println("Error! Invalid input. Please enter an integer from 1-4");
                System.out.println();
                continue;
            }
            System.out.println();
            //menu options or whatnot

            if (option == 1) {
                System.out.print("Enter message: ");
                rleString = scnr.next();
            }

             else if (option == 2) {
                System.out.print("The encoded data is: ");
                char[][] rle = encodeRLE(rleString);
                display(rle);
                System.out.println();
            }
                else if (option == 3) {
                System.out.print("The decoded data is: ");
                System.out.println(decodeRLE(rleString));
                System.out.println();
            }
                else if (option == 4) {
                System.out.println("Program terminated");
                System.exit(0);

            }
            if ((option > 4) || (option < 1)) {
                System.out.println("Error! Invalid input. Please enter an integer from 1-4");
                System.out.println();
            }

        }

    }
    public static int numOfDigits(int num){
        int digs = 0;
        while(num > 0){
            digs++;
            num /= 10;
        }
        return digs;
    }

    public static char[] toCharArray(int charCount, char strchar){

        if(charCount == 1)
        {
            char[] arr = new char[1];
            arr[0] = strchar;
            return arr;
        }


        int digits = numOfDigits(charCount);
        char[] arr = new char[digits + 1];
        String s = "" + charCount;

        for(int i = 0; i < s.length(); i++)
            arr[i] = s.charAt(i);

        arr[digits] = strchar;
        return arr;
    }


    public static int findEncodeLength(String s)
    {
        if( s == null || s.isEmpty())
            return 0;
        int length = 1;
        char current = s.charAt(0);

        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i) != current)
            {
                length++;
                current = s.charAt(i);
            }
        }

        return length;
    }

    public static int findDecodeLength(String rleString) {
        String temp = "";
        char ch;
        int total = 0;
        for(int i = 0; i < rleString.length(); ++i) {
            ch = rleString.charAt(i);
            if(Character.isDigit(ch)) {
                temp += ch;
            } else {
                if(!temp.isEmpty()) {
                    total += Integer.parseInt(temp);
                } else {
                    total += 1;
                }
                temp = "";
            }
        }
        return total;
    }

    public static char[] decodeRLE(String rleString)
    {
        String countStr = "";
        StringBuffer buf = new StringBuffer(); //credit to the tutoring lab tbh

        for(int i = 0; i < rleString.length(); i++)
        {
            char ch = rleString.charAt(i);
            if(Character.isDigit(ch))
                countStr += ch;
            else
            {
                int count;
                if(countStr.isEmpty())
                    count = 1;
                else
                    count = Integer.parseInt(countStr);

                for(int j = 0; j < count; j++)
                    buf.append(ch);

                countStr = "";
            }

        }

        return buf.toString().toCharArray();
    }

    public static char[][] encodeRLE(String inputString)
    {
        int len = findEncodeLength(inputString);
        char[][] arr = new char[len][];

        char current = inputString.charAt(0);
        int count = 1;
        int index = 0;
        for(int i = 1; i < inputString.length(); i++)
        {
            char ch = inputString.charAt(i);
            if(ch != current)
            {
                arr[index++] = toCharArray(count, current);
                current = ch;
                count = 1;
            }
            else
                count++;
        }

        arr[index++] = toCharArray(count, current); //store the last character processed

        return arr;
    }

    private static void display(char [][] arr)
    {
        for(int i = 0; i < arr.length; i++)
            System.out.print((arr[i])); //print the array
    }


}
