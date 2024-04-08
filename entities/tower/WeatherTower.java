package entities.tower;
import entities.flyable.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        // TO IMPLEMENT
    }
}