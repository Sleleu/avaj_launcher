package src.com.avaj.tower;
import src.com.avaj.aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private WeatherProvider() {}
    public static WeatherProvider getProvider() { return weatherProvider; }

    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public String getCurrentWeather(Coordinates p_coordinates) {
        int sum  = (p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight() + 42);
        return weather[sum % weather.length]; 
    }
}