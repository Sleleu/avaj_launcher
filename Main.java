import entities.flyable.Helicopter;
import entities.flyable.Coordinates;

public class Main {
    public static void main(String[] args) {
        System.out.println("yo");

        Coordinates coord = new Coordinates(100,50,150);
        Helicopter helico = new Helicopter(42, "salut", coord);

    }
}