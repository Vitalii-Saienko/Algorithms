package palindrome;

/*
Find the element that appears once in a sorted array
Given a sorted array in which all elements occur twice (one after the other) and one element appears only once.
 */
public class FindNumberWithoutPair {
    public static void main(String[] args) {
        findNumber(new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5}); //at the beginning (#1)
        System.out.println("=========");
        findNumber(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5}); //in the middle (#3)
        System.out.println("=========");
        findNumber(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5}); //in the end (#5)

    }

    public static int findNumber(int[] array) {
        //case1 - desired number at the beginning:
        int answer = array[0];

        //case2 - desired element in the end:
        if (array[array.length-1] != array[array.length-2]){
            answer = array[array.length-1];
        }

        //case3 - desired number in the middle:
        for (int i = 1; i < array.length-1; i++) {
            if (array[i - 1] != array[i] & array[i] != array[i + 1]) {
                answer = array[i];
                break;
            }
        }
        System.out.println("the element that appears once is " + answer);
        return answer;
    }
}
