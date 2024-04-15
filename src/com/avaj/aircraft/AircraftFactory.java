package src.com.avaj.aircraft;
import src.com.avaj.exception.AvajLauncherException;

public class AircraftFactory {
    private static AircraftFactory aircraftFactory = new AircraftFactory();
    private AircraftFactory() {}
    public static AircraftFactory getFactory() { return aircraftFactory; }

    int aircraftID = 1;

    public Coordinates createCoordinates(int p_longitude, int p_latitude, int p_height) throws AvajLauncherException {
        return new Coordinates(p_longitude, p_latitude, p_height);
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws AvajLauncherException {
        Flyable flyable;
        switch (p_type) {
            case "Helicopter":
                flyable =  new Helicopter(aircraftID++, p_name, p_coordinates);
                break;
            case "JetPlane":
                flyable = new JetPlane(aircraftID++, p_name, p_coordinates);
                break;
            case "Baloon":
                flyable = new Baloon(aircraftID++, p_name, p_coordinates);
                break;
                default:
                throw new AvajLauncherException("Invalid aircraft type: " + p_type);
        }
        return flyable;
    }
}