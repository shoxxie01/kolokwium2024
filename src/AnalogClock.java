import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AnalogClock extends Clock{

    private final List<ClockHand> clockHands = new ArrayList<>();

    public AnalogClock(City city) {
        super(city);
        clockHands.add(new HourHand());
        clockHands.add(new MinuteHand());
        clockHands.add(new SecondHand());
    }

    public void toSvg(String path) throws IOException {

        LocalTime localTime = getLocalTime();

        FileWriter fileWriter = new FileWriter(path);

        fileWriter.write("<svg width=\"200\" height=\"200\" viewBox=\"-100 -100 200 200\" xmlns=\"http://www.w3.org/2000/svg\">\n");
        fileWriter.write("<circle cx=\"0\" cy=\"0\" r=\"90\" fill=\"none\" stroke=\"black\" stroke-width=\"2\" />\n");
        fileWriter.write("<g text-anchor=\"middle\">\n");
        fileWriter.write(
                "<text x=\"0\" y=\"-80\" dy=\"6\">12</text>\n" +
                "    <text x=\"80\" y=\"0\" dy=\"4\">3</text>\n" +
                "    <text x=\"0\" y=\"80\" dy=\"6\">6</text>\n" +
                "    <text x=\"-80\" y=\"0\" dy=\"4\">9</text>\n");
        fileWriter.write("</g>\n\n");

        for (ClockHand clockHand : clockHands) {
            clockHand.setTime(localTime);
            fileWriter.write(clockHand.toSvg() + "\n");
        }
        fileWriter.write("</svg>");

        fileWriter.close();
    }
}
