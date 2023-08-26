package recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
Найдите пиковый элемент в двумерном массиве
Элемент является пиковым, если он больше или равен своим четырем соседям слева, справа, сверху и снизу.
Например, соседями для A[i][j] являются A[i-1][j], A[i+1][j], A[i][j-1] и A[i][j+1].
Для угловых элементов отсутствующие соседи считаются отрицательными бесконечными значениями.
10 20 15
21 30 14
 7 16 32
Выход: 30
30 — пиковый элемент, потому что все его
соседи меньше или равны ему.
32 также можно выбрать в качестве пика.

 */
public class FindElementInArray {
    public static void main(String[] args) {
        FindElementInArray findElementInArray = new FindElementInArray();
        findElementInArray.generalMethod();


    }

    public void generalMethod() {
        //1. search element that bigger than his "neighbors".
        //2. If there are several elements - add them all to hashMap

        int[][] array = createAndFillArray(inputSize());
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (isBigger(array, i, j)) {
                    String coordinates = "" + i + "" + j;
                    result.put(coordinates, array[i][j]);
                }
            }
        }
        System.out.println("Peak elements obtained from this array (coordinates = value):");
        System.out.println(result);
    }

    public static boolean isBigger(int[][] array, int i, int j) {
        String positionType = checkPosition(array, i, j);
        switch (positionType) {
            case "corner left bottom":
                if ((array[i][j] >= array[i][j + 1]) && (array[i][j] >= array[i + 1][j])) {
                    return true;
                } else {break;}
            case "line bottom":
                if ((array[i][j] >= array[i][j - 1]) && (array[i][j] >= array[i][j + 1]) && (array[i][j] >= array[i + 1][j])) {
                    return true;
                } else {break;}
            case "corner right bottom":
                if ((array[i][j] >= array[i][j - 1]) && (array[i][j] >= array[i + 1][j])) {
                    return true;
                } else {break;}
            case "left border":
                if ((array[i][j] >= array[i - 1][j]) && (array[i][j] >= array[i][j + 1]) && (array[i][j] >= array[i + 1][j])) {
                    return true;
                } else {break;}
            case "center":
                if ((array[i][j] >= array[i - 1][j]) && (array[i][j] >= array[i][j - 1]) && (array[i][j] >= array[i][j + 1]) && (array[i][j] >= array[i + 1][j])) {
                    return true;
                } else {break;}
            case "right border":
                if ((array[i][j] >= array[i - 1][j]) && (array[i][j] >= array[i][j - 1]) && (array[i][j] >= array[i + 1][j])) {
                    return true;
                } else {break;}
            case "corner left top":
                if ((array[i][j] >= array[i - 1][j]) && (array[i][j] >= array[i][j + 1])) {
                    return true;
                } else {break;}
            case "line top":
                if ((array[i][j] >= array[i - 1][j]) && (array[i][j] >= array[i][j - 1]) && (array[i][j] >= array[i][j + 1])) {
                    return true;
                } else {break;}
            case "corner right top":
                if ((array[i][j] >= array[i - 1][j]) && (array[i][j] >= array[i][j - 1])) {
                    return true;
                } else {break;}
        }
        return false;
    }

    private static String checkPosition(int[][] array, int indexI, int indexJ) {
        int size = array.length - 1;
        if (indexI == 0 && indexJ == 0) {
            return "corner left bottom";
        }
        if (indexI == 0 && indexJ == size) {
            return "corner right bottom";
        }
        if (indexI == size && indexJ == 0) {
            return "corner left top";
        }
        if (indexI == size && indexJ == size) {
            return "corner right top";
        }
        if (indexI == 0 && (indexJ != 0 && indexJ != size)) {
            return "line bottom";
        }
        if (indexJ == 0 && (indexI != 0 && indexI != size)) {
            return "left border";
        }
        if (indexJ == size && (indexI != 0 && indexI != size)) {
            return "right border";
        }
        if (indexI == size && (indexJ != 0 && indexJ != size)) {
            return "line top";
        }
        return "center";
    }


    private static int inputSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter size of two-dimensional array:");
        return scanner.nextInt();
    }

    private static int[][] createAndFillArray(int size) {
        Random random = new Random();
        int[][] array = new int[size][size];
        System.out.println("Generating two-dimensional array with size " + size + ":");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(50) + 10;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }
}
