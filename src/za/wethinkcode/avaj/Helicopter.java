package src.za.wethinkcode.avaj;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	Helicopter(String name, Coordinates coordinates) { super(name, coordinates); }
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN" : this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				if (this.coordinates.getHeight() > 100)
					this.coordinates.setHeight(100);
				WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "[" + this.id + "]" +
					" : This is hot.");
				break;
			case "RAIN" : this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "[" + this.id + "]" +
					" : Damn! this bloody rain.");
				break;
			case "FOG" : this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "[" + this.id + "]" +
					" : man i cant see shit!");
				break;
			case "SNOW" : this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "[" + this.id + "]" +
					" : My rotor is going to freeze!");
				break;
			default :
				WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "[" + this.id + "]" +
					" : Weather Tower cannot be contacted right now!");
				break;
		}
		if (this.coordinates.getHeight() <= 0) {
			WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "[" + this.id + "]" +
				" : hasn't taken off yet or rather just landed!");
			WriteFile.getWriteFile().writetofile("Tower says : Helicopter#" + this.name + "[" + this.id + "]" +
				" unregistered from weather tower.");
		}
	}

	public	void	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		WriteFile.getWriteFile().writetofile("Tower says : Helicopter#" + this.name +
			"[" + this.id + "]" + " registered to weather tower.");
		weatherTower.register(this);
	}

}