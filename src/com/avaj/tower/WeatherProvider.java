package src.com.avaj.tower;
import src.com.avaj.aircraft.*;

public class WeatherProvider {
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

    public static String getCurrentWeather(Coordinates p_coordinates) {
        // GENERATION ALGORITHM TO IMPLEMENT
        return weather[0];
    }
}