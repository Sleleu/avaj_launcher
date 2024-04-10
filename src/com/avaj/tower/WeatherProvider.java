package src.com.avaj.tower;
import src.com.avaj.aircraft.*;

public class WeatherProvider {

    // Singleton implementation
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private WeatherProvider() {}
    public static WeatherProvider getProvider() { return weatherProvider; }

    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public String getCurrentWeather(Coordinates p_coordinates) {
        long sum  = (p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight());
        int p = (int) Math.abs(sum % Integer.MAX_VALUE);
        return weather[p % weather.length]; 
    }
}