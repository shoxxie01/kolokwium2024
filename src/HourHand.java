import java.time.LocalTime;

public class HourHand extends ClockHand{

    private int angleHours;

    @Override
    public void setTime(LocalTime localTime) {
        int hours = localTime.getHour();

        this.angleHours = hours * 30;
    }

    @Override
    public String toSvg() {
        String hoursSvg = "<line x1=\"0\" y1=\"0\" x2=\"0\" y2=\"-60\" stroke=\"black\" stroke-width=\"4\" transform=\"rotate(" + this.angleHours + ")\" />";
        return hoursSvg;
    }
}
