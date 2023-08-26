package greedyAlgorithm.FurnitureFactory;
/*
Вы работаете в фирме по производству мебели и поставляете мебель по всей стране.
Коробки с мебелью размещаются в грузовике. Все коробки имеют разный размер, и вы стараетесь наиболее
эффективно использовать доступное пространство. Как выбрать коробки для того, чтобы загрузка имела максимальную
эффективность? Предложите жадную стратегию. Будет ли полученное решение оптимальным?
 */
public class Box {
    private int weightKilogram;
    private int priceOfItemInBox;

    public Box(int weightKilogram, int priceOfItemInBox) {
        this.weightKilogram = weightKilogram;
        this.priceOfItemInBox = priceOfItemInBox;
    }

    public int getWeightKilogram() {
        return weightKilogram;
    }

    public void setWeightKilogram(int weightKilogram) {
        this.weightKilogram = weightKilogram;
    }

    public int getPriceOfItemInBox() {
        return priceOfItemInBox;
    }

    public void setPriceOfItemInBox(int priceOfItemInBox) {
        this.priceOfItemInBox = priceOfItemInBox;
    }

    @Override
    public String toString() {
        return "Box(" + weightKilogram + " kilogram, " + priceOfItemInBox + " USD"+')';
    }
}
