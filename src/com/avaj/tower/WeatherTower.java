package src.com.avaj.tower;
import src.com.avaj.aircraft.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        this.conditionChanged();
    }
}