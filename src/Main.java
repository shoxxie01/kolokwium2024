import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws IOException {

        City city = new City();
        Map<String, City> cityMap = city.parseFile("strefy.csv");
        City randomCity = cityMap.get("Lublin");
//
//        for(Map.Entry<String, City> cityEntry : cityMap.entrySet()){
//
//            String name = cityEntry.getKey();
//            City value = cityEntry.getValue();
//            System.out.println(name + " " + value.getSummerTimeZone());
//        }
//
//        DigitalClock digitalClock = new DigitalClock(randomCity, DigitalClock.ClockType.TWENTY_FOUR_TYPE);
//        digitalClock.setCity(randomCity);
//        System.out.println(digitalClock.toString());
//        LocalTime time = randomCity.localMeanTime(LocalTime.now());
//        System.out.println(time.toString());

        List<City> cities = city.getListOfCity("strefy.csv");

        City.generateAnalogClocksSvg(cities, new AnalogClock(city));
    }
}
