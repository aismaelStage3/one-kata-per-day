package name.lemerdy.eric.dataMunging.football;

import name.lemerdy.eric.dataMunging.weather.TemperatureExtremum;
import name.lemerdy.eric.dataMunging.weather.WeatherFileLineProcessor;
import name.lemerdy.eric.dataMunging.weather.WeatherFileReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;

public class SmallestGoalDifferenceTest {

    @Test
    public void should_find_team_with_the_smallest_goal_difference_in_football_league() {
        List<TeamResult> footballLeagueResults = newArrayList(
                new TeamResult("Arsenal", 79, 36),
                new TeamResult("Liverpool", 67, 30));
        SmallestGoalDifference smallestGoalDifference = new SmallestGoalDifference(footballLeagueResults);

        String teamWithMinimumGoalDifference = smallestGoalDifference.teamWithMinimumGoalDifference();

        assertThat(teamWithMinimumGoalDifference).isEqualTo("Liverpool");
    }
}