package arrayTask;

import java.util.Arrays;
/*

input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
 */

public class Array2 {
    public static void main(String[] args) {

        //Version with String using
        String[] array = {"1","2","3","4"};
        int numberToAdd = 6;
        String concat = "";
        for (int i = 0; i < array.length; i++) {
            concat += array[i];
        }

        int concatInt = Integer.parseInt(concat);
        concatInt += numberToAdd;

        String newNumber = String.valueOf(concatInt);
        int newArrayLength = newNumber.length();
        String[] arrayResult = new String[newArrayLength];
        for (int i = arrayResult.length-1; i >= 0; i--) {
            arrayResult[i] = String.valueOf(newNumber.charAt(i));
        }

        System.out.println(Arrays.toString(arrayResult));
    }
}
