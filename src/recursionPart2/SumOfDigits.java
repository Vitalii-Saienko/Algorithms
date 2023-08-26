package recursionPart2;

/*
Given a natural number N. Calculate the sum of its digits.
You cannot use strings, lists, arrays and loops.
 */
public class SumOfDigits {
    public static void main(String[] args) {
        int answer = calculateSumOfDigits(1234567);
        System.out.println(answer);
    }

    private static int calculateSumOfDigits(int i) {

        if (i / 10 < 1) {
            return i;
        }
        return calculateSumOfDigits(i / 10) + (i % 10);
    }
}
