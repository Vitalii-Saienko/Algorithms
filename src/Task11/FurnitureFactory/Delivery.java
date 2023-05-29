package Task11.FurnitureFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Delivery {
    public static void main(String[] args) {
        Truck truck = new Truck(2000);
        Box box1 = new Box(500, 2500);
        Box box2 = new Box(300, 1800);
        Box box3 = new Box(600, 4200);
        Box box4 = new Box(300, 2400);
        Box box5 = new Box(500, 4500);
        Box box6 = new Box(800, 7200);
        List<Box> allBoxesAtWarehouse = new ArrayList<>(); //all boxes that been ordered and needed to be delivered
        allBoxesAtWarehouse.add(box1);
        allBoxesAtWarehouse.add(box2);
        allBoxesAtWarehouse.add(box3);
        allBoxesAtWarehouse.add(box4);
        allBoxesAtWarehouse.add(box5);
        allBoxesAtWarehouse.add(box6);
        List<Box> boxInTruck = deliverySolution(truck, allBoxesAtWarehouse);
        printInfoAboutDelivery(boxInTruck, truck);
    }
    /*
    1.Допускаем что клиенты не жалуются на время доставки и поэтому нет приоритетов исходя из даты заказа.
    2.Не учитываем фактор расстояния местанахождения клиентов.
    3.Исходя из допущений 1 и 2, эффективной будет такая загрузка при которой наша компания доставит коробок
      с мебелью с максимальной стоимостью килограма мебели в коробке (price/weight)
     */
    /**
     * Method calculates the effective loading of the truck based on the cost of a kilogram of goods in a box.
     * <strong> *** If current furniture is too heavy but truck still has space - program will try to put next furniture ***</strong>
     * @param truck vehicle that limited by its capacity
     * @param orderedBoxes List of all ordered boxes that ready to be delivered
     * @return boxToLoad List of boxes that have chosen to delivery this time
     */
    public static List<Box> deliverySolution(Truck truck, List<Box> orderedBoxes){
        //sorting boxes by cost of 1 kilogram (increasing order)
        orderedBoxes = orderedBoxes.stream()
                .sorted(Comparator.comparingInt(box -> box.getPriceOfItemInBox() / box.getWeightKilogram()))
                .collect(Collectors.toList());

        //loading the truck while it has space
        List<Box> boxesInTruck = new ArrayList<>();
        int loadingCounter = 0; //truck is empty
        int allBoxesCounter = orderedBoxes.size()-1;
        while (truck.getWeightCapacity() >= loadingCounter){
            if (loadingCounter + orderedBoxes.get(allBoxesCounter).getWeightKilogram() > truck.getWeightCapacity()){
                allBoxesCounter--; //the furniture is too heavy, try to put next one
            }
            boxesInTruck.add(orderedBoxes.get(allBoxesCounter));
            loadingCounter+=orderedBoxes.get(allBoxesCounter).getWeightKilogram();
            allBoxesCounter--;
            if (allBoxesCounter == 0){
                break;
            }
        }
        return boxesInTruck;
    }
    public static void printInfoAboutDelivery (List<Box> boxesInTruck, Truck truck){
        int totalCost = calculateTotalCostOfBoxesInTruck(boxesInTruck);
        int totalWeight = calculateTotalWeightInTruck(boxesInTruck);
        double truckUsedSpace = ((double) totalWeight / truck.getWeightCapacity()) * 100;
        System.out.println("Truck " + truck + " has been loaded:");
        System.out.println(boxesInTruck);
        System.out.println("Total cost of furniture in truck: " + totalCost);
        System.out.println("Average cost of 1 kilogram delivered furniture: " + ((double) totalCost/totalWeight));
        System.out.println("Total weight in truck: " + totalWeight);
        System.out.println("Truck's capacity used: " + truckUsedSpace + "%");
    }

    private static int calculateTotalWeightInTruck(List<Box> boxesInTruck) {
        return boxesInTruck.stream()
                .mapToInt(Box::getWeightKilogram)
                .sum();
    }

    private static int calculateTotalCostOfBoxesInTruck(List<Box> boxesInTruck) {
        return boxesInTruck.stream()
                .mapToInt(Box::getPriceOfItemInBox)
                .sum();
    }


}
