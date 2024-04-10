package src.com.avaj.simulator;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static String log = "";
    private static Logger logger = new Logger();

    private Logger() {}
    public static Logger getLogger() { return logger; }
    public static void log(String message) { log += message + "\n"; }

    public static void writeToFile() {
        try {
            FileWriter myWriter = new FileWriter("simulation.txt");
            myWriter.write(log);
            myWriter.close();
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
            }
        } 
}
