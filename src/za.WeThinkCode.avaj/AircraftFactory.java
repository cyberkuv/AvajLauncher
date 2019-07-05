package AvajLauncher.src.za.WeThinkCode.avaj;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        String strType = type.toLowerCase();
        if (strType.equals("helicopter"))
            return new Helicopter(name, coordinates);
        else if (strType.equals("jetPlane"))
            return new JetPlane(name, coordinates);
        else if (strType.equals("balloon"))
            return new Balloon(name, coordinates);
        else {
            System.out.println("Aircraft : unknown type");
            return null;
        }
    }
}
