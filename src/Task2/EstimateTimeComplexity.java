package Task2;
/*
Estimate time complexity of algorithms
 */
public class EstimateTimeComplexity {
    public static void main(String[] args) {
        test3(40);
    }

    public static void test3(int n)
    {
        int a = 0, i = n;
        while (i > 0) {
            a += i;
            i /= 2;
            System.out.println(i);
    }}
    /*
======== Task1. Part A ========
void test1(int n) {
    if (n==1)
       return;
    for (int i=1; i<=n; i++)
       for (int j=1; j<=n; j++)
          System.out.println("");
          break;}
ANSWER: this is O(n^2) complexity. We have here two cycles, each cycle executes n-times.

======== Task1. Part B ========
void test2(int n)
{
    int a = 0;
for (i = 0; i < n; i++)
    for (j = n; j > i; j--)
        a = a + i + j;
}
ANSWER: this is O(n^2) complexity. We have here two cycles, first loop executes from 0 till n and inner loop from "n" to "i".

======== Task1. Part C ========
void test3(int n)
{
    int i, j, a = 0;
for (i = n/2; i <=n; i++)
    for (j = 2; j <=n; j=j2)
        a=a+n/2;
}
ANSWER: this is O(n log n) complexity. In outer loop we have n/2 and inner loop has j*2.

======== Task1. Part D ========
void test4(int n)
 {
    int a = 0, i = n;
while (i > 0) {
    a += i;
    i /= 2;
}
}
ANSWER: this is O(log n) complexity. O(n log n). "i" is halved at each iteration until it equals 1.
 */
    }

