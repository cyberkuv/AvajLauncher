package Aircrafts;

import Simulator.Coordinates;
import Simulator.Flyable;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        String strType = type;
        if (strType.equals("Helicopter"))
            return new Helicopter(name, coordinates);
        else if (strType.equals("JetPlane"))
            return new JetPlane(name, coordinates);
        else if (strType.equals("Balloon"))
            return new Balloon(name, coordinates);
        else {
            System.out.println("Aircraft : unknown type");
            return null;
        }
    }
}
