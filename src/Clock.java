import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public abstract class Clock {

    private City city;
    private LocalTime localTime;

    public Clock(City city) {
        this.city = city;
        this.localTime = setZoneTime(city);
    }

    public LocalTime setCurrentTime(){
        LocalTime localTime = LocalTime.now();
        return localTime;
    }

    public void setTime(int hours, int minutes, int seconds){
        try{
            if(hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60 && seconds >= 0 && seconds <60){
                this.localTime = LocalTime.of(hours, minutes, seconds);
            }
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }
    }

    public String toString() {
        DateTimeFormatter custom = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedDate = localTime.format(custom);
        return formattedDate;
    }

    public LocalTime setZoneTime(City city){
        this.localTime = setCurrentTime();
        double hoursChanging = city.getSummerTimeZone();
        int hours = (int)hoursChanging;
        int minutes = (int)((hoursChanging - Math.floor(hoursChanging)) * 60);
        LocalTime lt = this.localTime.plusHours(hours).plusMinutes(minutes);
        return lt;
    }

    public void setCity(City city_) {
        this.city = city_;
        LocalTime lt = setZoneTime(city_);
        this.localTime = lt;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }
}
