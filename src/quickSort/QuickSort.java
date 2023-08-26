package quickSort;
//QUICK SORT (n * Log n) - the fastest

import java.util.Arrays;
import java.util.Random;

/*
Given an array of integers. The numbers in the array are in random order.
1. Select a base element.
2. Transform the array in a way that elements smaller than the base go to the left of the array, and larger ones are to the right.
Note: after the algorithm has run, you should know where the reference element is located.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[7];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }

        System.out.println("Given random array: " + Arrays.toString(array));
        System.out.println("RESULT OF METHOD Array after transforming: " + Arrays.toString(transformArray(array)));
    }

    public static int[] transformArray(int[] inputArray) {
        //base case for closing recursion:
        if (inputArray.length == 1){
            return inputArray;
        }
        if (inputArray.length == 2) {
            if (inputArray[0] <= inputArray[1]) {
                return inputArray;
            } else {
                int temp = inputArray[1];
                inputArray[1] = inputArray[0];
                inputArray[0] = temp;
            }
            return inputArray;
        }

        //determine baseElement and create 2 arrays:
        if (inputArray == null || inputArray.length == 0) {
            return new int[0];
        }
        int baseElement = inputArray[0];
        int[] leftPart = new int[inputArray.length];
        int leftCounter = 0;
        int[] rightPart = new int[inputArray.length];
        int rightCounter = 0;

        //moving elements into two arrays, base element remains in [0] position:
        for (int j : inputArray) {
            if (baseElement >= j) {
                leftPart[leftCounter] = j;
                leftCounter++;
            } else {
                rightPart[rightCounter] = j;
                rightCounter++;
            }
        }
        //System.out.println("left part: " + Arrays.toString(leftPart)); //debugging
        //System.out.println("right part: " + Arrays.toString(rightPart)); //debugging

        //checking the border between two parts:
        int border = leftCounter - 1;

        //adding rightArray to the left one:
        int k = 1;
        int l = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i < border) {
                inputArray[i] = leftPart[k];
                k++;
            } else if (i == border) {
                inputArray[i] = baseElement;
            } else {
                inputArray[i] = rightPart[l];
                l++;
            }
        }
        //System.out.println("debug: adding rightArray to the left one: " + Arrays.toString(inputArray));

        //create 2 sub arrays:
        if (inputArray == null || inputArray.length == 0) {
            return new int[0];
        }
        int[] leftSub = new int[border+1];
        int secondCounter = 0;
        int[] rightSub = new int[inputArray.length-leftSub.length];

        //fill 2 sub arrays:
        for (int i = 0; i < leftSub.length; i++) {
            leftSub[i] = inputArray[i];
            secondCounter = i;
        }
        for (int i = 0; i < rightSub.length; i++) {
            rightSub[i] = inputArray[secondCounter+1+i];
        }
        System.out.println("debug: created leftSubArray:" + Arrays.toString(leftSub));
        System.out.println("debug: created rightSubArray:" + Arrays.toString(rightSub));

        //System.out.println("LEFT recursion call:");
        transformArray(leftSub);
        //System.out.println("RIGHT recursion call:");
        transformArray(rightSub);

        System.out.println("FINALLY MERGING:");

        //merging two arrays:
        int lastCounter = 0;

        for (int i = 0; i < leftSub.length; i++) {
            inputArray[i] = leftSub[i];
            lastCounter = i;
        }
        for (int i = 0; i < rightSub.length; i++) {
            inputArray[lastCounter+1] = rightSub[i];
            lastCounter++;
        }

        return inputArray;
    }
}
