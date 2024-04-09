package src.com.avaj.aircraft;

public class AircraftFactory {

    static int aircraftID = 0;

    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        String helicopter = "Helicopter";

        if (helicopter.equals(p_type)) {
            Helicopter hel = new Helicopter(aircraftID++, p_name, p_coordinates);
            return hel;
        }
        else {
            System.out.println("newAircraft: p_type variable isn't 'Helicopter'");
            Helicopter unknow = new Helicopter(aircraftID++, "Unknow", p_coordinates);
            return unknow;
        }
    }
}