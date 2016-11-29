package name.lemerdy.eric.dataMunging.weather;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;

public class WeatherFileReaderTest {

    @Test
    public void should_read_weather_dat_file() throws IOException {
        URL weatherFile = getResource("weather.dat");
        WeatherFileReader weatherFileReader = new WeatherFileReader(weatherFile, new WeatherFileLineProcessor());

        List<TemperatureExtremum> extrema = weatherFileReader.readFile();

        assertThat(extrema).contains(new TemperatureExtremum(17, 81, 57));
    }

}