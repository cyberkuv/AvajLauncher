package AvajLauncher.src.za.WeThinkCode.avaj;

import AvajLauncher.src.za.WeThinkCode.avaj.*;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
    public Coordinates getCoordinates();
}
