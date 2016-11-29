package name.lemerdy.eric.dataMunging.football;

import lombok.Value;
import name.lemerdy.eric.dataMunging.weather.TemperatureExtremum;

import java.util.List;

@Value
public class SmallestGoalDifference {

    List<TeamResult> extrema;

    public String teamWithMinimumGoalDifference() {
        return extrema.stream()
                .sorted()
                .findFirst()
                .get()
                .getTeam();
    }
}
