package src.com.avaj.simulator;

import src.com.avaj.aircraft.AircraftFactory;
import src.com.avaj.aircraft.Flyable;
import src.com.avaj.aircraft.Coordinates;
import src.com.avaj.exception.AvajLauncherException;
import src.com.avaj.tower.WeatherTower;
import java.util.List;
import java.io.PrintStream;
import java.io.File;

public class Simulator {

    public static PrintStream stream;
    public static void main(String[] args) throws AvajLauncherException {
        try {

            Parser parser = new Parser(args);
            File file = new File("simulation.txt");
            stream = new PrintStream(file);
            System.setOut(stream);
            WeatherTower weatherTower = new WeatherTower();
            AircraftFactory aircraftFactory = AircraftFactory.getFactory();

            if (parser.getNbIteration() > 10000)
                System.err.println("Warning: " + parser.getNbIteration() + " iterations, this can take a while...");
            for (int i = 0; i < parser.getAircrafts().size(); i++) {
                List<String> aircraftAttributes = parser.getAircrafts().get(i);
                Coordinates coord = aircraftFactory.createCoordinates(Integer.parseInt(aircraftAttributes.get(Parser.LONGITUDE)),
                        Integer.parseInt(aircraftAttributes.get(Parser.LATITUDE)),
                        Integer.parseInt(aircraftAttributes.get(Parser.HEIGHT)));
                Flyable aircraft = aircraftFactory.newAircraft(aircraftAttributes.get(Parser.TYPE), aircraftAttributes.get(Parser.NAME), coord);
                aircraft.registerTower(weatherTower);
            }

            for (int i = 0; i < parser.getNbIteration(); i++) {
                weatherTower.changeWeather();
            }
        }
        catch (AvajLauncherException e) { System.err.println(e.getMessage()); }
        catch (Exception e) { System.err.println("An error occured: " + e.getMessage()); }
        finally { 
            if (stream != null)
            stream.close();
        }
    }
}