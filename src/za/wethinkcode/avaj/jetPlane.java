package src.za.wethinkcode.avaj;

public class jetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	jetPlane(String name, Coordinates coordinates) { super(name, coordinates); }
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN" : this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				if (this.coordinates.getHeight() > 100)
					this.coordinates.setHeight(100);
				WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "[" + this.id + "]" +
					" : This is hot.");
				break;
			case "RAIN" : this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
				WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "[" + this.id + "]" +
					" : Its raining! better watch out for lightning.");
				break;
			case "FOG" : this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
				WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "[" + this.id + "]" +
					" : Damn! so foggy.");
				break;
			case "SNOW" : this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "[" + this.id + "]" +
					" : Damn! looks like winter is around the corner.");
				break;
			default :
				WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "[" + this.id + "]" +
					" : weather tower cannot be contacted right now!");
				break;
		}
		if (this.coordinates.getHeight() <= 0) {
			WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "[" + this.id + "]" +
				" : hasn't taken off yet or rather just landed!");
			WriteFile.getWriteFile().writetofile("Tower  says: JetPlane#" + this.name + "[" + this.id + "]" +
				" unregistered from weather tower.");
		}
	}

	public	void	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		WriteFile.getWriteFile().writetofile("Tower says : JetPlane#" + this.name +
			"[" + this.id + "]" + " registered to weather tower.");
		this.weatherTower.register(this);
	}
	
}