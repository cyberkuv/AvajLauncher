package src.za.wethinkcode.avaj;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		if (type.equalsIgnoreCase("Balloon")) { return new Balloon(name, coordinates); }
		else if (type.equalsIgnoreCase("Jetplane")) { return new jetPlane(name, coordinates); }
		else if (type.equalsIgnoreCase("Helicopter")) { return new Helicopter(name, coordinates); }
		else
			System.out.println("Aircraft Factory : Unknown type " + "[" + type + "]");
		return null;
	}
}