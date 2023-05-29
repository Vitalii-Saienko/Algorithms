package Task11.Vacation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Вы едете в отпуск, и у вас есть семь дней на знакомство с достопримечательностями.
Вы присваиваете каждой достопримечательности стоимость в баллах (насколько вы хотите ее увидеть) и
оцениваете продолжительность поездки. Как обеспечить максимальную стоимость (увидеть самое важное) во время поездки?
Предложите жадную стратегию. Будет ли полученное решение оптимальным?
 */
public class OurTrip {
    public static void main(String[] args) {
        List<Vacation> placesToVisit = new ArrayList<>();
        placesToVisit.add(new Vacation(10, 2, "Museum"));
        placesToVisit.add(new Vacation(15, 3, "City Center"));
        placesToVisit.add(new Vacation(5, 1, "Zoo"));
        placesToVisit.add(new Vacation(40, 4, "Ликеро-водочный цех"));
        placesToVisit.add(new Vacation(10, 2, "Mega Shopping-Mall"));

        int vacationDays = 7;

        List<Vacation> wishList = selectPlaces(placesToVisit, vacationDays);
        System.out.println("In our " + vacationDays + "-days vacation we are going to visit:");
        wishList.forEach(System.out::println);
    }

    public static List<Vacation> selectPlaces(List<Vacation> places, int days) {
        List<Vacation> selectedSights = new ArrayList<>();

        places.sort(Comparator.comparingInt(Vacation::getPlaceRating).reversed());

        int remainingDays = days;
        for (Vacation sight : places) {
            if (remainingDays >= sight.getDays()) {
                selectedSights.add(sight);
                remainingDays -= sight.getDays();
            }
        }

        return selectedSights;
    }
}
