package recursionPart2;

/*
Given a natural number N. Print all its digits one at a time, in reverse order, separating them with spaces or newlines.
When solving this problem, you cannot use strings, lists, arrays, loops. Only recursion and integer arithmetic are allowed.
 */
public class DigitInReverseOrder {
    public static void main(String[] args) {
        System.out.print(printDigitsReverse(123456));
    }

    private static int printDigitsReverse(int i) {
        if (i / 10 < 1) {
            return i;
        }
        System.out.print(i % 10 + " ");
        return (printDigitsReverse(i / 10));
    }
}
