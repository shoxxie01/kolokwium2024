import java.time.LocalTime;

public class SecondHand extends ClockHand{

    private int angleSeconds;

    @Override
    public void setTime(LocalTime localTime) {
        int seconds = localTime.getSecond();

        this.angleSeconds = seconds * 6;
    }

    @Override
    public String toSvg() {
       String secondsSvg = "<line x1=\"0\" y1=\"0\" x2=\"0\" y2=\"-80\" stroke=\"red\" stroke-width=\"1\" transform=\"rotate(" + this.angleSeconds + ")\"/>";
       return secondsSvg;
    }
}
