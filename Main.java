import entities.flyable.Helicopter;
import entities.flyable.Coordinates;
import entities.flyable.AircraftFactory;
import avajexception.AvajLauncherException;

public class Main {
    public static void main(String[] args) throws AvajLauncherException {
        try {
            AircraftFactory factory = new AircraftFactory();

            Coordinates coord = new Coordinates(100,50,100);
            for (int i = 0; i < 5; i++) {
                factory.newAircraft("Helicopter", "BS " + i, coord);
            }
        }
        catch (AvajLauncherException e) {
            System.out.println("AvajLauncher: " + e.getMessage());
        }
    }
}