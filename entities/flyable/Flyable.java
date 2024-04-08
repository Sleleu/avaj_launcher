package entities.flyable;
import entities.tower.WeatherTower;

public abstract class Flyable {

    protected WeatherTower weatherTower;

    public abstract void updateConditions();
    
    public void registerTower(WeatherTower p_tower) {
        System.out.println("registerTower method called");
    }
}