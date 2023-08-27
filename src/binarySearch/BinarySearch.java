package binarySearch;

public class BinarySearch {

    /**
     * The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(log N).
     *     1. The data structure must be sorted.
     *     2. Access to any element of the data structure takes constant time.
     * ---------
     * Time Complexity:
     *     Best Case: O(1)
     *     Average Case: O(log N)
     *     Worst Case: O(log N)
     */

    public static int binarySearch(int[] array, int numberToFind) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (numberToFind == array[middleIndex]){
                return middleIndex;
            } else if (numberToFind < array[middleIndex]) {
                rightIndex = middleIndex - 1;
            } else {
                leftIndex = middleIndex + 1;
            }
        }
        return -1;
    }
}