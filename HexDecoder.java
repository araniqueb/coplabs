import java.util.Scanner;
public class HexDecoder
{
    public static long hexConverter(String hexadecimal)
    {
        long newValue = 0;
        long currentDigit = 0;
        long value = hexadecimal.length() - 1;
        String newHex = hexadecimal.toUpperCase();
        if(hexadecimal.charAt(1) == 'X')
        {
            newHex = newHex.substring(2, newHex.length());

        }

        for(int i=0; i < newHex.length(); i++)
        {
            char ch = newHex.charAt(i);
            switch(ch)
            {
                case '1':
                    currentDigit = 1;
                    break;
                case '2':
                    currentDigit = 2;
                    break;
                case '3':
                    currentDigit = 3;
                    break;
                case '4':
                    currentDigit = 4;
                    break;
                case '5':
                    currentDigit = 5;
                    break;
                case '6':
                    currentDigit = 6;
                    break;
                case '7':
                    currentDigit = 7;
                    break;
                case '8':
                    currentDigit = 8;
                    break;
                case '9':
                    currentDigit = 9;
                    break;
                case 'A':
                    currentDigit = 10;
                    break;
                case 'B':
                    currentDigit = 11;
                    break;
                case 'C':
                    currentDigit = 12;
                    break;
                case 'D':
                    currentDigit = 13;
                    break;
                case 'E':
                    currentDigit = 14;
                    break;
                case 'F':
                    currentDigit = 15;
                    break;
                default:
                    break;
            }
            newValue = (long)(currentDigit * Math.pow(16, value)) + (long)newValue;
            value--;
        }
        return newValue;
    }
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        String hexConvert = args[0];

        long newValue = hexConverter(hexConvert);

        System.out.println(newValue);

    }
}