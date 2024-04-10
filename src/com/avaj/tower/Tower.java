package src.com.avaj.tower;

import src.com.avaj.aircraft.*;
import src.com.avaj.simulator.Logger;
import java.util.*;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        String flyableIdentity = p_flyable.getClass().getSimpleName() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ")";
        
        if (!observers.contains(p_flyable)) {
            if (p_flyable.getCoordinates().getHeight() <= 0)
            {
                Logger.log("Tower says: " + flyableIdentity + " is already landed.");
                return;
            }
            observers.add(p_flyable);
            Logger.log("Tower says: " + flyableIdentity + " registered to weather tower.");
        }
        else
            Logger.log("Tower says: " + flyableIdentity + " already registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) {
        String flyableIdentity = p_flyable.getClass().getSimpleName() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ")";

        if (observers.contains(p_flyable)) {
            observers.remove(p_flyable);
            Logger.log("Tower says: " + flyableIdentity + " unregistered from weather tower.");
        }
        else
            Logger.log("Tower says: " + flyableIdentity + " not registered to weather tower.");
    }

    protected void conditionChanged() {
		for (int i = 0; i < observers.size(); i++)
			observers.get(i).updateConditions();
    }
}