package src.com.avaj.simulator;

import src.com.avaj.aircraft.*;
import src.com.avaj.exception.*;
import src.com.avaj.tower.WeatherTower;
import java.util.*;

public class Simulator {

    public static void main(String[] args) throws AvajLauncherException {
        try {
            Parser parser = new Parser(args);
            WeatherTower weatherTower = new WeatherTower();
            AircraftFactory aircraftFactory = AircraftFactory.getFactory();

            for (int i = 0; i < parser.getAircrafts().size(); i++) {
                List<String> aircraftAttributes = parser.getAircrafts().get(i);
                Coordinates coord = aircraftFactory.createCoordinates(Integer.parseInt(aircraftAttributes.get(Parser.LONGITUDE)),
                        Integer.parseInt(aircraftAttributes.get(Parser.LATITUDE)),
                        Integer.parseInt(aircraftAttributes.get(Parser.HEIGHT)));
                Aircraft aircraft = aircraftFactory.newAircraft(aircraftAttributes.get(Parser.TYPE), aircraftAttributes.get(Parser.NAME), coord);
                aircraft.registerTower(weatherTower);
            }

            for (int i = 0; i < parser.getNbIteration(); i++) {
                weatherTower.changeWeather();
            }
            Logger.writeToFile();
        }
        catch (AvajLauncherException e) { System.err.println(e.getMessage()); }
    }
}