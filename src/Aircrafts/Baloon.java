package Aircrafts;

import Simulator.Coordinates;
import Simulator.Flyable;
import Weather.WeatherTower;

import java.io.FileWriter;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    Baloon(String name, Coordinates coordinates) { super(name,coordinates); }
    public void updateConditions() {  }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.registerTower(weatherTower);
    }
}
