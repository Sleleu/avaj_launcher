package src.com.avaj.aircraft;

import src.com.avaj.simulator.Logger;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {

        String weather = this.weatherTower.getWeather(this.coordinates);
        String message = "";
        switch(weather) {
            case "SUN":
                message = "Let's enjoy the good weather and take some pics.";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                break;
            case "RAIN":
                message = "Damn you rain! You messed up my baloon.";
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                break;
            case "FOG":
                message = "We can't keep flying in this fog. We're gonna crash.";
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                break;
            case "SNOW":
                message = "It's snowing. We're gonna crash.";
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                break;
        }
        String identity = this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")";
        Logger.log(identity + ": " + message);
        super.updateConditions();
    }
}
