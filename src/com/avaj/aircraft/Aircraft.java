package src.com.avaj.aircraft;

import src.com.avaj.simulator.Logger;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    public long getId() { return this.id; }
    public String getName() { return this.name; }
    public Coordinates getCoordinates() { return this.coordinates; }

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates)
    {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    public void updateConditions()
    {
        if (this.coordinates.getHeight() <= 0)
        {
            Logger.log(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): landing.");
            this.coordinates.setHeight(0);
            this.weatherTower.unregister(this);
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
    }
}