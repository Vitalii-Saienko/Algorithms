package queue;


public class Task2CountSteps {
    public static void main(String[] args) {
        int destination = 5;
        int answer = calculateStepsToPoint(destination);
        System.out.println("To reach field " + destination + " there are " + answer + " possible ways.");
    }
    public static int calculateStepsToPoint(int destinationPoint){

        int startPlace = 0;

        if (startPlace + 1 == destinationPoint){
            return 1;
        }
        if (startPlace + 2 == destinationPoint){
            return 1;
        }

        return calculateStepsToPoint(destinationPoint-1) + calculateStepsToPoint(destinationPoint-2);
    }

}
