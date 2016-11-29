package name.lemerdy.eric.dataMunging.weather;

import com.google.common.io.LineProcessor;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Splitter.on;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.io.Resources.readLines;

public class InlinedWeather {
    public static Integer minTemperatureSpreadDay(URL weatherFile) throws IOException {
        List<TemperatureExtremum> temperatureExtrema = readLines(weatherFile, UTF_8, new LineProcessor<List<TemperatureExtremum>>() {

            List<TemperatureExtremum> result = newArrayList();

            @Override
            public boolean processLine(String line) throws IOException {
                List<String> numericData = on(' ').omitEmptyStrings().trimResults().splitToList(line);
                if (numericData.isEmpty()) {
                    return true;
                }
                try {
                    Integer day = Integer.valueOf(numericData.get(0));
                    Integer max = Integer.valueOf(numericData.get(1));
                    Integer min = Integer.valueOf(numericData.get(2));
                    return result.add(new TemperatureExtremum(day, max, min));
                } catch (NumberFormatException e) {
                    return true;
                }
            }

            @Override
            public List<TemperatureExtremum> getResult() {
                return result;
            }

            ;
        });
        return temperatureExtrema.stream()
                .sorted()
                .findFirst()
                .get()
                .getDay();
    }
}
