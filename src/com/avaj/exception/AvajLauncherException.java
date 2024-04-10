package src.com.avaj.exception;

public class AvajLauncherException extends Exception {
    public AvajLauncherException() {
        super();
    }

    public AvajLauncherException(String message) {
        super("AvajLauncher: " + message);
    }
}