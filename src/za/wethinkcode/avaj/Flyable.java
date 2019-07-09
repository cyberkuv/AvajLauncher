package src.za.wethinkcode.avaj;

public interface Flyable {
	public Coordinates getCoordinates();
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);
}