package src.com.avaj.aircraft;

import src.com.avaj.simulator.Logger;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {

        String weather = this.weatherTower.getWeather(this.coordinates);
        String message = "";
        switch(weather) {
            case "SUN":
                message = "Careful of the sunburn!";
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":
                message = "It's raining. Better watch out for lightings.";
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                break;
            case "FOG":
                message = "I want to fly above the fog!";
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                break;
            case "SNOW":
                message = "OMG! Winter is coming!";
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                break;
        }
        String identity = this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")";
        Logger.log(identity + ": " + message);
        super.updateConditions();
    }
}
