package Task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TowerOfHanoi {
    public static void main(String[] args) {
        List<Integer> tower1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14));
        List<Integer> tower2 = new ArrayList<>();
        List<Integer> tower3 = new ArrayList<>();
        System.out.print(tower1 + " " + tower2 + " " + tower3 + "\n");
        solveMethod(tower1, tower2, tower3);
        System.out.print("Result: " + tower1 + " " + tower2 + " " + tower3 + "\n");
    }

    public static void move(ArrayList towerOut, ArrayList towerIn) {
        if (towerIn.isEmpty()) {
            towerIn.add(0, (towerOut.get(0)));
            towerOut.remove(0);
        } else if (towerOut.isEmpty()) {
            towerOut.add(0, (towerIn.get(0)));
            towerIn.remove(0);
        } else {
            if ((Integer) towerOut.get(0) < (Integer) towerIn.get(0)) {
                towerIn.add(0, (towerOut.get(0)));
                towerOut.remove(0);
            } else {
                towerOut.add(0, (towerIn.get(0)));
                towerIn.remove(0);
            }
        }
    }

    public static void solveMethod(List<Integer> tower1, List<Integer> tower2, List<Integer> tower3) {
        int counter = 0;


        while (true) {
            move((ArrayList) tower1, (ArrayList) tower3);
            if ((tower1.isEmpty() && tower2.isEmpty()) || (tower1.isEmpty() && tower3.isEmpty())) {
                //System.out.println("отладка этап1");
                break;
            }
            move((ArrayList) tower1, (ArrayList) tower2);
            if ((tower1.isEmpty() && tower2.isEmpty()) || (tower1.isEmpty() && tower3.isEmpty())) {
                //System.out.println("отладка этап2");
                break;
            }
            move((ArrayList) tower2, (ArrayList) tower3);
            if ((tower1.isEmpty() && tower2.isEmpty()) || (tower1.isEmpty() && tower3.isEmpty())) {
                //System.out.println("отладка этап3");
                break;
            }
            //System.out.print("iter: " + counter + " " + tower1 + " " + tower2 + " " + tower3 + "\n");
            counter++;
        }
    }
}
