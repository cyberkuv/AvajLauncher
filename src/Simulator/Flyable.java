package Simulator;

import Weather.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
    Coordinates getCoordinates();
}
