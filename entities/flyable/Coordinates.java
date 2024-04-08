package entities.flyable;
import avajexception.AvajLauncherException;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) throws AvajLauncherException {
        
        if (p_height < 0 || p_height > 100)
            throw new AvajLauncherException(this + ": Height must be between 0 and 100");
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
        // System.out.println("COORDINATES constructor : " + this);
        // System.out.println("long " + this.longitude + " lat " + this.latitude + " height " + this.height);
    }

    public int getLongitude() { return this.longitude; }
    public int getLatitude() { return this.latitude; }
    public int getHeight() { return this.height; }
}