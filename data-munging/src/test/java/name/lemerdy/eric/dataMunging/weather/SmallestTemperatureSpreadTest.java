package name.lemerdy.eric.dataMunging.weather;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.google.common.base.Splitter.on;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static org.assertj.core.api.Assertions.assertThat;

public class SmallestTemperatureSpreadTest {

    @Test
    public void should_find_day_of_the_smallest_temperature_in_extremum_value() {
        List<TemperatureExtremum> extrema = newArrayList(
                new TemperatureExtremum(1, 88, 59),
                new TemperatureExtremum(2, 79, 53));
        SmallestTemperatureSpread smallestTemperatureSpread = new SmallestTemperatureSpread(extrema);

        Integer minTemperaturesSpread = smallestTemperatureSpread.minTemperatureSpreadDay();

        assertThat(minTemperaturesSpread).isEqualTo(2);
    }

    @Test
    public void acceptance() throws IOException {
        URL weatherFile = getResource("weather.dat");

        Integer minTemperatureSpreadDay = InlinedWeather.minTemperatureSpreadDay(weatherFile);

        assertThat(minTemperatureSpreadDay).isEqualTo(14);
    }
}