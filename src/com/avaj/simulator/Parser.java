package src.com.avaj.simulator;

import src.com.avaj.exception.AvajLauncherException;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.util.Scanner;

public class Parser {

    private int nb_iteration;
    public int getNbIteration() { return this.nb_iteration; }

    private void checkArgs(String[] args) throws AvajLauncherException {
        if (args.length != 1)
            throw new AvajLauncherException("Invalid number of parameters");
    }

    private File loadFile(String arg) throws AvajLauncherException {
        File file = new File(arg);
        if (!file.exists())
            throw new AvajLauncherException("Failed to open file");
        return file;
    }

    private int loadNbIteration(Scanner reader) throws AvajLauncherException {
        try {
            String line = reader.nextLine();
            return Integer.parseInt(line);
        }
        catch (NumberFormatException e) {
            throw new AvajLauncherException("Number of iterations need integer value");
        }
    }

    private void printDebug() {
        System.out.println("NUMBER OF ITERATIONS :  " + this.nb_iteration);
    }

    private void readFile(File file) throws AvajLauncherException {
        try (Scanner reader = new Scanner(file)) {
            this.nb_iteration = loadNbIteration(reader);
            // continue le parsing

            // printDebug();
        } catch (FileNotFoundException e) {
            throw new AvajLauncherException("Parsing error");
        }
    }

    public Parser(String[] args) throws AvajLauncherException {
        checkArgs(args);
        File file = loadFile(args[0]);
        readFile(file);
    }
}