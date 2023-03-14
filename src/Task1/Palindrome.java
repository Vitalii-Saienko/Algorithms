package Task1;

import java.util.Arrays;

/*
Palindrome Number
Given an integer x, return true if x is a palindrome, and false otherwise.
 */
public class Palindrome {
    public static void main(String[] args) {
    //check number using method 1 (number as a char-type array):
        isPalindromeCharMethod("151");
        isPalindromeCharMethod("153");
    //check number using method 2 (number as an int-type):
        isPalindromeIntMethod(151);
        isPalindromeIntMethod(153);
    }

    public static boolean isPalindromeIntMethod (int number){
        boolean isPalindrome = false;
        int copyNumber = number;
        int reversedNumber = 0;
        int digit;
        while (copyNumber>0){
            digit = copyNumber % 10;
            reversedNumber = reversedNumber * 10 + digit;
            copyNumber = copyNumber / 10;
        }
        if (reversedNumber == number){
            isPalindrome = true;
            System.out.println("Input number " + number + " is palindrome");
        }
        else {
            System.out.println("Input number " + number + " is not palindrome");
        }
        return isPalindrome;
    }

    public static boolean isPalindromeCharMethod (String number){
        boolean isPalindrome = false;
        char [] numberAsCharArray = number.toCharArray();
        char [] reversedArray = new char[numberAsCharArray.length];
        for (int i = 0; i < reversedArray.length; i++) {
            reversedArray[i] = numberAsCharArray[numberAsCharArray.length-1-i];
        }
        if (Arrays.equals(numberAsCharArray, reversedArray)){
            isPalindrome = true;
            System.out.println("Input number " + number + " is palindrome");
        }
        else {
            System.out.println("Input number " + number + " is not palindrome");
        }
        return isPalindrome;
    }
}
