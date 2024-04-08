package entities.flyable;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        // System.out.println("HELICOPTER constructor : " + this);
    }

    public void updateConditions() {
        System.out.println("UpdateConditions method called");
    }
}