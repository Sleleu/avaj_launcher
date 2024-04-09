package src.com.avaj.aircraft;
import src.com.avaj.tower.WeatherTower;

public abstract class Flyable {

    protected WeatherTower weatherTower;
    public abstract void updateConditions();
    public abstract long getId();
    public abstract String getName();
    
    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        this.weatherTower.register(this);
    }
}