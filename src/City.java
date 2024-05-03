import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {

    private String capital;
    private double SummerTimeZone;
    private String latitude;
    private String Longitude;

    public City(String capital, double summerTimeZone, String latitude, String longitude) {
        this.capital = capital;
        this.SummerTimeZone = summerTimeZone;
        this.latitude = latitude;
        this.Longitude = longitude;
    }

    public City() {
    }

    public LocalTime localMeanTime(LocalTime ldt){
        String tempLongitude = Longitude;
        String[] parts = tempLongitude.split(" ");
        Double numberLongitude = Double.parseDouble(parts[1]);
        String eastOrWest = parts[2];

        LocalTime customLDT = ldt;

        double allTime = numberLongitude * 4.0;
        int allMinutes = (int)(Math.floor(allTime));
        double allTimeLikeFloat = (double) (allMinutes) / 60.0;
        int hours = (int)(Math.floor(allTimeLikeFloat));
        int minutes = (int)((allTimeLikeFloat - Math.floor(allTimeLikeFloat)) * 60);
        int seconds = (int)((allTime - Math.floor(allTime)) * 60);

        if(eastOrWest == "W"){
            customLDT = customLDT.minusHours(hours).minusMinutes(minutes).minusSeconds(seconds);
        }else{
            customLDT = customLDT.plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
        }
        return customLDT;
    }

    private City parseLine(String line){
        String[] parts = line.split(",");
        String capitalName = parts[0];
        double TimeZone = Double.parseDouble(parts[1].trim());
        String latutude_ = parts[2];
        String longitude_ = parts[3];

        return new City(capitalName, TimeZone, latutude_, longitude_);
    }

    public List<City> getListOfCity(String path) throws IOException {

        List<City> cities = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        br.readLine();

        while((line=br.readLine()) != null){
            City city = parseLine(line);
            cities.add(city);
        }
        return cities;
    }

    public Map<String, City> parseFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        Map<String, City> map = new HashMap<String, City>();
        br.readLine();

        while((line=br.readLine()) != null){
            City city = parseLine(line);
            map.put(city.capital, city);
        }

        br.close();
        return map;
    }

    public static void generateAnalogClocksSvg(List<City> cities, AnalogClock analogClock) throws IOException {

        for (City city : cities) {
            analogClock.setCity(city);
            analogClock.toSvg("cityTimes/" + city.capital + ".svg");
        }
    }

    public double getSummerTimeZone() {
        return SummerTimeZone;
    }

    public String getCapital() {
        return capital;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    @Override
    public String toString() {
        return "City{" +
                "capital='" + capital + '\'' +
                ", SummerTimeZone=" + SummerTimeZone +
                ", latitude='" + latitude + '\'' +
                ", Longitude='" + Longitude + '\'' +
                '}';
    }
}
