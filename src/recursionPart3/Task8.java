package recursionPart3;

public class Task8 {
    public static void main(String[] args) {
        int[][] array = new int[2][3];
        System.out.println("Для массива:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 1;
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("кол-во возможных способов: " + numberOfWays(2,3));
    }
    /*
    Дано прямоугольное поле размером n*m клеток. Можно совершать шаги длиной в одну клетку вправо или вниз.
    Посчитать, сколькими способами можно попасть из левой верхней клетки в правую нижнюю.
    Попробуйте решить задачу методом динамического программирования.
    Подсказка: Начать рассуждение можно так: "В некоторую клетку с координатами (i,j) можно прийти только сверху
    или слева, то есть из клеток с координатами (i – 1, j) и (i, j – 1). Таким образом, для клетки (i, j) число
    маршрутов A[i][j] будет равно A[i – 1][j] + A[i][j – 1], то есть задача сводится к двум подзадачам.".
     */
    public static int numberOfWays (int n, int m){
        if (n == 0 && m == 0) {
            return 1;
        }
        if (n == 0) {
            return numberOfWays(0, m - 1);
        }
        if (m == 0) {
            return numberOfWays(n - 1, 0);
        }
        return numberOfWays(n - 1, m) + numberOfWays(n, m - 1);
    }
}
