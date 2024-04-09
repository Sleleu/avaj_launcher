package src.com.avaj.aircraft;
import src.com.avaj.exception.AvajLauncherException;

public class AircraftFactory {
    // Singleton implementation
    private static AircraftFactory aircraftFactory = new AircraftFactory();
    private AircraftFactory() {}
    public static AircraftFactory getFactory() { return aircraftFactory; }

    int aircraftID = 1;

    public Coordinates createCoordinates(int p_longitude, int p_latitude, int p_height) throws AvajLauncherException {
        return new Coordinates(p_longitude, p_latitude, p_height);
    }

    public Aircraft newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        switch (p_type) {
            case "Helicopter":
                return new Helicopter(aircraftID++, p_name, p_coordinates);
            default:
                return null;
        }
    }
}