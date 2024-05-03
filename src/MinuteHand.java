import java.time.LocalTime;

public class MinuteHand extends ClockHand{

    private int  angleMinutes;

    @Override
    public void setTime(LocalTime localTime) {
        int minutes = localTime.getMinute();

        this.angleMinutes = minutes * 6;
    }

    @Override
    public String toSvg() {
        String minuteSvg = "<line x1=\"0\" y1=\"0\" x2=\"0\" y2=\"-70\" stroke=\"black\" stroke-width=\"2\" transform=\"rotate(" + this.angleMinutes + ")\"/>";
        return minuteSvg;
    }
}
