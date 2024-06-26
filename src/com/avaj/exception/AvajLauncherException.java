package src.com.avaj.exception;

public class AvajLauncherException extends Exception {
    public AvajLauncherException() {
        super();
    }

    public AvajLauncherException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "AvajLauncher: " + super.getMessage();
    }
}