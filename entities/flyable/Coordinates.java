package entities.flyable;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    // remove "public" after
    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
        System.out.println("COORDINATES constructor : " + this);
        System.out.println("long " + this.longitude + " lat " + this.latitude + " height " + this.height);
    }

    public int getLongitude() { return this.longitude; }
    public int getLatitude() { return this.latitude; }
    public int getHeight() { return this.height; }
}