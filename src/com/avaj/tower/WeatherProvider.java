package src.com.avaj.tower;
import src.com.avaj.aircraft.*;

public class WeatherProvider {

    // Singleton implementation
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private WeatherProvider() {}
    public static WeatherProvider getProvider() { return weatherProvider; }


    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public String getCurrentWeather(Coordinates p_coordinates) {
        // GENERATION ALGORITHM TO IMPLEMENT
        return weather[3];
    }
}