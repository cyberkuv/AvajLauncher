package Aircrafts;

import Simulator.Coordinates;
import Simulator.FileWrite;
import Simulator.Flyable;
import Weather.WeatherTower;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    Balloon(String name, Coordinates coordinates) { super(name,coordinates); }
    public void updateConditions() {
        weatherTower = this.
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        FileWrite.getFileWrite().writeToFile("Tower says : Balloon#" + this.name
                + "(" + this.id + ")" + "registered to weather tower.");
        this.registerTower(weatherTower);
    }
}
