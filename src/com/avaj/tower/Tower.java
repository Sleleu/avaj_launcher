package src.com.avaj.tower;

import src.com.avaj.aircraft.Flyable;
import java.util.List;
import java.util.ArrayList;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        String flyableIdentity = p_flyable.getClass().getSimpleName() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ")";
        
        if (!observers.contains(p_flyable)) {
            if (p_flyable.getCoordinates().getHeight() <= 0)
            {
                System.out.println("Tower says: " + flyableIdentity + " is already landed.");
                return;
            }
            observers.add(p_flyable);
            System.out.println("Tower says: " + flyableIdentity + " registered to weather tower.");
        }
        else
            System.out.println("Tower says: " + flyableIdentity + " already registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) {
        String flyableIdentity = p_flyable.getClass().getSimpleName() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ")";

        if (observers.contains(p_flyable)) {
            observers.remove(p_flyable);
            System.out.println("Tower says: " + flyableIdentity + " unregistered from weather tower.");
        }
        else
            System.out.println("Tower says: " + flyableIdentity + " not registered to weather tower.");
    }

    protected void conditionChanged() {
		for (int i = 0; i < observers.size(); i++)
			observers.get(i).updateConditions();
    }
}