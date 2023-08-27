package binarySearch;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @org.junit.jupiter.api.Test
    void binarySearchLength1PositiveTest() {
        int[] array = {5};
        int numberToFind = 5;
        int expected = 0;
        int actual = BinarySearch.binarySearch(array, numberToFind);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void binarySearchLength1NegativeTest() {
        int[] array = {5};
        int numberToFind = 2;
        int expected = -1;
        int actual = BinarySearch.binarySearch(array, numberToFind);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void binarySearchLength2PositiveTest() {
        int[] array = {4,5};
        int numberToFind = 5;
        int expected = 1;
        int actual = BinarySearch.binarySearch(array, numberToFind);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void binarySearchLength2PositiveTestCase2() {
        int[] array = {4,5};
        int numberToFind = 4;
        int expected = 0;
        int actual = BinarySearch.binarySearch(array, numberToFind);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void binarySearchLength2NegativeTest() {
        int[] array = {4,5};
        int numberToFind = 2;
        int expected = -1;
        int actual = BinarySearch.binarySearch(array, numberToFind);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void binarySearchLength3PositiveTestCaseLeft() {
        int[] array = {3,4,5};
        int numberToFind = 3;
        int expected = 0;
        int actual = BinarySearch.binarySearch(array, numberToFind);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void binarySearchLength3PositiveTestCaseRight() {
        int[] array = {3,4,5};
        int numberToFind = 5;
        int expected = 2;
        int actual = BinarySearch.binarySearch(array, numberToFind);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void binarySearchLength3PositiveTestCaseMiddle() {
        int[] array = {3,4,5};
        int numberToFind = 4;
        int expected = 1;
        int actual = BinarySearch.binarySearch(array, numberToFind);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void binarySearchLength3NegativeTestCase() {
        int[] array = {3,4,5};
        int numberToFind = 6;
        int expected = -1;
        int actual = BinarySearch.binarySearch(array, numberToFind);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void binarySearchLength10PositiveTestCaseLeft() {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int numberToFind = 2;
        int expected = 1;
        int actual = BinarySearch.binarySearch(array, numberToFind);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void binarySearchLength10PositiveTestCaseRight() {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int numberToFind = 9;
        int expected = 8;
        int actual = BinarySearch.binarySearch(array, numberToFind);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void binarySearchLength10PositiveTestCaseMiddle() {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int numberToFind = 5;
        int expected = 4;
        int actual = BinarySearch.binarySearch(array, numberToFind);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void binarySearchLength10NegativeTestCase() {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int numberToFind = 12;
        int expected = -1;
        int actual = BinarySearch.binarySearch(array, numberToFind);
        assertEquals(expected, actual);
    }
}