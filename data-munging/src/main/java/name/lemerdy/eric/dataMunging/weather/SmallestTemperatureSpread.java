package name.lemerdy.eric.dataMunging.weather;

import lombok.Value;

import java.util.List;

@Value
public class SmallestTemperatureSpread {

    List<TemperatureExtremum> extrema;

    public Integer minTemperatureSpreadDay() {
        return extrema.stream()
                .sorted()
                .findFirst()
                .get()
                .getDay();
    }

}
