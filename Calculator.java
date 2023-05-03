import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System. out. println("Input an operation, using Arabic (1, 5, 10) or Roman (I, V, X)\nnumbers between 1 and 10, symbols '+', '-', '*', '/', and space\nbetween them. Like that: '1 + 1' or 'I + I':");
        
        //inputting operation
        String input = scanner.nextLine().trim();
        String[] tokens = input.split(" ");

        //limit the length
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Invalid input, only one operation possible");
        }
        int a, b;

        //check entered
        try {
            a = parseNumber(tokens[0]);
            b = parseNumber(tokens[2]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid input, use Arabic (1, 5, 10) or Roman (I, V, X) numbers");
        }

        //checking arab/arab or roma/roma
        if ((isArabic(tokens[0]) && isRoman(tokens[2])) || (isRoman(tokens[0]) && isArabic(tokens[2]))) {
            throw new IllegalArgumentException("Arabic and Roman numerals cannot be used together");
        }

        //checking in 1-10
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Numbers should be between 1 and 10");
        }

        //making operation
        int result;
        switch (tokens[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Invalid operation, use only '+', '-', '*', '/'");
        }

        //if using romans, result must be >0, else - output
        if (isRoman(tokens[0]) || isRoman(tokens[2])) {
            if (result < 1) {
                throw new IllegalArgumentException("Roman numerals cannot represent zero or negative numbers");
            }
            System.out.println(toRoman(result));
        } else {
            System.out.println(result);
        }
    }
    
    //str to int
    private static int parseNumber(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                int value = romanValue(s.charAt(i));
                if (i + 1 < s.length() && value < romanValue(s.charAt(i + 1))) {
                    result -= value;
                } else {
                    result += value;
                }
            }
            if (result == 0) {
                throw new IllegalArgumentException("Invalid number");
            }
            return result;
        }
    }

    //for roman nums
    private static int romanValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Invalid Roman numeral");
        }
    }

    //if arabic check
    private static boolean isArabic(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    
    //if roman check
    private static boolean isRoman(String s) {
        String str = "IIIVIIIX"; // for 1-10 thats enough, but for more you need to change this str
        return str.contains(s);
    }
    
    //if input roman, result to roman
    private static String toRoman(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Roman numerals cannot represent zero or negative numbers");
        }
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] romanValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < romanValues.length; i++) {
            while (n >= romanValues[i]) {
                sb.append(romanSymbols[i]);
                n -= romanValues[i];
            }
        }
        return sb.toString();
    }
}