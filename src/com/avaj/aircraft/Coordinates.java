package src.com.avaj.aircraft;
import src.com.avaj.exception.AvajLauncherException;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) throws AvajLauncherException {
        
        if (p_height < 0 || p_height > 100)
            throw new AvajLauncherException(this + ": Height must be between 0 and 100");
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    public int getLongitude() { return this.longitude; }
    public int getLatitude() { return this.latitude; }
    public int getHeight() { return this.height; }
    public void setLongitude(int p_longitude) { this.longitude = p_longitude; }
    public void setLatitude(int p_latitude) { this.latitude = p_latitude; }
    public void setHeight(int p_height) { this.height = p_height; }

}