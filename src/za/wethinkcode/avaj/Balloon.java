package src.za.wethinkcode.avaj;

public class Balloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	Balloon(String name, Coordinates coordinates) { super(name, coordinates); }
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN" : this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
				this.coordinates.setHeight(this.coordinates.getHeight() + 4);
				if (this.coordinates.getHeight() > 100)
					this.coordinates.setLongitude(100);
				WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "[" + this.id + "]" +
					" : This is hot!");
				break;
			case "RAIN" : this.coordinates.setHeight(this.coordinates.getHeight() - 5);
				WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "[" + this.id + "]" +
					" : Man The rain messes up the balloon.");
				break;
			case "FOG" : this.coordinates.setHeight(this.coordinates.getHeight() - 2);
				WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "[" + this.id + "]" +
					" : Damn! so foggy.");
				break;
			case "SNOW" : this.coordinates.setHeight(this.coordinates.getHeight() - 15);
				WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "[" + this.id + "]" +
					" : Damn! its freezing out here.");
				break;
			default :
				WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "[" + this.id + "]" +
					" : Weather Tower cannot be contacted right now!");
				break;
		}
		if (this.coordinates.getHeight() <= 0) {
			WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "[" + this.id + "]" +
				" : Hasn't taken off or rather just landed!");
			WriteFile.getWriteFile().writetofile("Tower says : Baloon#" + this.name + "[" + this.id + "]" +
				" unregistered from weather tower.");
		}
	}
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		WriteFile.getWriteFile().writetofile("Tower says : Baloon#" + this.name +
			"[" + this.id + "]" + " registered to weather tower.");
		weatherTower.register(this);
	}
}