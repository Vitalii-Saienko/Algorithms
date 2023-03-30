package Task4;
/*
Даны два целых числа x и n, напишите функцию для вычисления x^n
     решение 1 - рекурсивно O(n)
     решение 2 - улучшить решение 1 до O(log n)
 */
public class FunctionX_N {
    public static void main(String[] args) {
        System.out.println(pow(2,10));
        System.out.println(pow2(2,10));
    }
    public static int pow(int x, int n){
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        return pow(x*2, n-1);
    }
    public static int pow2(int x, int n){
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * 2;
        }
        return result;
    }
}
