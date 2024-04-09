package src.com.avaj.simulator;

import src.com.avaj.aircraft.*;
import src.com.avaj.exception.*;
import src.com.avaj.tower.WeatherTower;

public class Simulator {

    public static void main(String[] args) throws AvajLauncherException {
        unitTests(args);
        try {
            Parser parser = new Parser(args);
            WeatherTower weatherTower = new WeatherTower();
            AircraftFactory aircraftFactory = AircraftFactory.getFactory();

            for (int i = 0; i < parser.getNbIteration(); i++) {
                weatherTower.changeWeather();
            }
            // Coordinates coord = new Coordinates(100,50,100);
            // for (int i = 0; i < 5; i++) {
            //     AircraftFactory.newAircraft("Helicopter", "BS " + i, coord);
            // }
        }
        catch (AvajLauncherException e) {
            System.out.println("AvajLauncher: " + e.getMessage());
        }
    }

    public static void unitTests(String[] args) throws AvajLauncherException {
        Parser parser = new Parser(args);
        
        System.out.println("nb_iteration: " + parser.getNbIteration());


        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory aircraftFactory = AircraftFactory.getFactory();

        for (int i = 1; i <= 5; i++) {
            Coordinates coord = aircraftFactory.createCoordinates(100, 50, 100);
            Aircraft helicopter = aircraftFactory.newAircraft("Helicopter", "H" + i, coord);
            helicopter.registerTower(weatherTower);
        }

        for (int j = 0; j < parser.getNbIteration(); j++) {
            weatherTower.changeWeather();
        }
    }
}