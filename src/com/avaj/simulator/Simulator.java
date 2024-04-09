package src.com.avaj.simulator;

import src.com.avaj.aircraft.*;
import src.com.avaj.exception.*;

public class Simulator {
    public static void main(String[] args) throws AvajLauncherException {
        try {
            Parser parser = new Parser(args);

            // Coordinates coord = new Coordinates(100,50,100);
            // for (int i = 0; i < 5; i++) {
            //     AircraftFactory.newAircraft("Helicopter", "BS " + i, coord);
            // }
        }
        catch (AvajLauncherException e) {
            System.out.println("AvajLauncher: " + e.getMessage());
        }
    }
}