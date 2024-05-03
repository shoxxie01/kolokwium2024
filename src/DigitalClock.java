import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DigitalClock extends Clock{

    public enum ClockType{TWELVE_TYPE, TWENTY_FOUR_TYPE}

    private ClockType type;

    public DigitalClock(City city, ClockType type) {
        super(city);
        this.type = type;
    }

    @Override
    public String toString() {
        if(type == ClockType.TWENTY_FOUR_TYPE) {
            return super.toString();
        }else{
            LocalTime lDT = getLocalTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            return lDT.format(formatter);
        }
    }
}
