package src.com.avaj.simulator;

import src.com.avaj.exception.AvajLauncherException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.lang.NumberFormatException;
import java.util.*;

public class Parser {

    static final int TYPE = 0;
    static final int NAME = 1;
    static final int LONGITUDE = 2;
    static final int LATITUDE = 3;
    static final int HEIGHT = 4;

    private int nb_iteration;
    private List<List<String>> aircrafts = new ArrayList<>();

    public int getNbIteration() { return this.nb_iteration; }
    public List<List<String>> getAircrafts() { return this.aircrafts; }

    private void checkArgs(String[] args) throws AvajLauncherException {
        if (args.length != 1)
            throw new AvajLauncherException("Invalid number of parameters");
    }

    private int checkInt(String arg) throws AvajLauncherException {
        try {
            return Integer.parseInt(arg);
        }
        catch (NumberFormatException e) {
            throw new AvajLauncherException("Invalid integer format");
        }
    }

    private File loadFile(String arg) throws AvajLauncherException {
        File file = new File(arg);
        if (!file.exists())
            throw new AvajLauncherException("Failed to open file");
        return file;
    }

    private int loadNbIteration(BufferedReader reader) throws AvajLauncherException, IOException {
        String line = reader.readLine();
        if (line != null)
            return checkInt(line);
        else
            throw new AvajLauncherException("Empty file");
    }

    private void checkAircraftLine(List<String> aircraftAttributes, int index) throws AvajLauncherException {
        if (aircraftAttributes.size() != 5)
            throw new AvajLauncherException("Aircraft#" + (index + 1) +  " Invalid aircraft attributes");
        if (checkInt(aircraftAttributes.get(LONGITUDE)) < 0 || checkInt(aircraftAttributes.get(LATITUDE)) < 0 || checkInt(aircraftAttributes.get(HEIGHT)) < 0)
            throw new AvajLauncherException("Aircraft#" + (index + 1) +  " Invalid aircraft coordinates");
        if (checkInt(aircraftAttributes.get(HEIGHT)) > 100)
            aircraftAttributes.set(HEIGHT, "100");
        switch (aircraftAttributes.get(TYPE)) {
            case "Helicopter":
            case "JetPlane":
            case "Baloon":
                break;
            default:
                throw new AvajLauncherException("Aircraft#" + (index + 1) +  " Invalid aircraft type");
        }
    }

    private void addAircraft(String line, int index) throws AvajLauncherException {
        List<String> aircraftAttributes = Arrays.asList(line.split(" "));
        checkAircraftLine(aircraftAttributes, index);
        this.aircrafts.add(aircraftAttributes);
    }

    private void readFile(File file) throws AvajLauncherException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            this.nb_iteration = loadNbIteration(reader);
            String line;
            for (int i = 0; (line = reader.readLine()) != null; i++)
                addAircraft(line, i);
        }
        catch (IOException e) {
            throw new AvajLauncherException("Parsing error");
        }
    }

    public Parser(String[] args) throws AvajLauncherException {
        checkArgs(args);
        File file = loadFile(args[0]);
        readFile(file);
    }
}