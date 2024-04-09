package src.com.avaj.aircraft;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates)
    {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
        System.out.println("\nAIRCRAFT constructor : " + this);
        System.out.println("id: " + this.id);
        System.out.println("name: " + this.name);
        System.out.println("coordinates: " + this.coordinates);
    }

    public void updateConditions()
    {
        System.out.println("updateConditions called");
    }
}