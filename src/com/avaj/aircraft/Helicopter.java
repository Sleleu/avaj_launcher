package src.com.avaj.aircraft;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        String message = "";
        switch(weather) {
            case "SUN":
                message = "This is hot.";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":
                message = "Ow it's raining today!";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                break;
            case "FOG":
                message = "I can't see in this fog!";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                break;
            case "SNOW":
                message = "My rotor is going to freeze!";
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                break;
        }
        String identity = this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")";
        System.out.println(identity + ": " + message);
        super.updateConditions();
    }
}