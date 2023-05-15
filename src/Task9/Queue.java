package Task9;

import java.util.Arrays;

public class Queue {
    private int[] arr;      // массив для хранения элементов queue
    private int head;      // head указывает на первый элемент в queue
    private int tail;       // tail часть указывает на последний элемент в queue
    private int capacity;   // максимальная емкость queue
    private int count;      // текущий размер queue

    public Queue(int size)
    {
        arr = generateInitialArray(size);
        capacity = size;
        head = 0;
        tail = getIndexOfLastElement();
        count = size();
    }

    private int[] generateInitialArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        return array;
    }

    public int size() {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1){
                counter++;
            }
        }
        return counter;
    }

    private void increaseCapacity() {
        int newCapacity = capacity * 2;
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < count; i++) {
            newArray[i] = arr[i];
        }
        for (int i = count; i < newCapacity; i++) {
            newArray[i] = -1;
        }
        arr = newArray;
        capacity = newCapacity;
    }

    private int getIndexOfLastElement(){
        int lastIndex = -1;
        for (int i = 0; i < this.arr.length; i++) {
            if (arr[i] == -1){
                lastIndex =  i-1;
                break;
            }
        }
        return lastIndex;
    }

    public void pushToEnd(int data){
        if (isFull()){
            increaseCapacity();
        }
        tail++;
        arr[tail] = data;
        count++;
    }
    public void remove (){
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        for (int i = 0; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[count - 1] = -1;
        tail--;
        count--;

    }
    public int peek (){
        if (isEmpty()){
            return -1;
        }
        return arr[0];
    }

    public boolean isEmpty() {
        return  arr[0] == -1;
    }

    private boolean isFull(){
        return count == arr.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public int getCapacity() {
        return capacity;
    }
}
