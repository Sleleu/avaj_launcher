package src.com.avaj.tower;
import src.com.avaj.aircraft.*;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        // TO IMPLEMENT
    }
}