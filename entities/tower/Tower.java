package entities.tower;
import entities.flyable.Flyable;
import java.util.*;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        // TO IMPLEMENT     
    }

    public void unregister(Flyable p_flyable) {
        // TO IMPLEMENT
    }

    protected void conditionChanged() {
        // TO IMPLEMENT
    }
}