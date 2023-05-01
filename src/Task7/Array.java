package Task7;

import java.util.Arrays;
import java.util.Random;

/*
input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
 */
public class Array {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToAdd = random.nextInt(1000);
        //int numberToAdd = 0; //IN CASE USER WANTS TO TRY HIS OWN NUMBER
        int[] array = {1};
        System.out.println("Adding random number: " + numberToAdd + " to number represented as an array " + Arrays.toString(array) + ":");
        System.out.println(Arrays.toString(changeArrayByIncrement(array, numberToAdd)));
        int[] array2 = {1, 2};
        System.out.println("Adding random number: " + numberToAdd + " to number represented as an array " + Arrays.toString(array2) + ":");
        System.out.println(Arrays.toString(changeArrayByIncrement(array2, numberToAdd)));
        int[] array3 = {1, 2, 3};
        System.out.println("Adding random number: " + numberToAdd + " to number represented as an array " + Arrays.toString(array3) + ":");
        System.out.println(Arrays.toString(changeArrayByIncrement(array3, numberToAdd)));
        int[] array4 = {1, 2, 3, 4};
        System.out.println("Adding random number: " + numberToAdd + " to number represented as an array " + Arrays.toString(array4) + ":");
        System.out.println(Arrays.toString(changeArrayByIncrement(array4, numberToAdd)));

    }

    public static int[] changeArrayByIncrement(int[] inputArray, int numberToAdd) {
        //Part1: getting number from elements of array
        int searchNumber = inputArray[inputArray.length - 1];
        final int digit = 10;
        int power = 1;
        for (int i = inputArray.length - 1; i >= 1; i--) {
            searchNumber = searchNumber + (i * (digit * power));
            power *= 10;
        }

        //Part2: increasing result-number by input from user/random
        searchNumber += numberToAdd;

        //Part3: returning result-number to array-digit form
        //3.1 defining the length of new array
        int newLength = 0;
        int copyOfNumber = searchNumber;
        while (copyOfNumber > 0) {
            copyOfNumber /= 10;
            newLength++;
        }
        int[] answerArray = new int[newLength];

        //3.2 write result-number into array-digit form
        for (int i = newLength - 1; i >= 0; i--) {
            answerArray[i] = searchNumber % 10;
            searchNumber /= 10;
        }
        return answerArray;
    }
}
