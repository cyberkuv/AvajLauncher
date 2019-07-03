package Aircrafts;

import Simulator.Coordinates;
import Simulator.FileWrite;
import Simulator.Flyable;
import Weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    public Helicopter(String name, Coordinates coordinates){ super(name, coordinates); }
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN" : this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                FileWrite.getFileWrite().writeToFile("Helicopter#" + this.name + "[" + this.id + "]" +
                    " Damn this bloody rain");
                break ;
            case "SNOW" : this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                FileWrite.getFileWrite().writeToFile("Helicopter#" + this.name + "[" + this.id + "]" +
                        " My rotor is going to freeze ");
                break ;
            case "FOG" : this.coordinates.setHeight(this.coordinates.getHeight() - 10);
                FileWrite.getFileWrite().writeToFile("Helicopter#" + this.name + "[" + this.id + "]" +
                        " man i cant see shit!");
                break ;
            case "SUN" : this.coordinates.setHeight(this.coordinates.getHeight() - 20);
                FileWrite.getFileWrite().writeToFile("Helicopter#" + this.name + "[" + this.id + "]" +
                        " This is hot.");
                break ;
            default :
                FileWrite.getFileWrite().writeToFile("Helicopter#" + this.name + "[" + this.id + "]" +
                        " : Weather Tower cannot be contacted right now!");
                break ;

        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        FileWrite.getFileWrite().writeToFile("Tower says: Helicopter#" + this.name + "[" +
                this.id + "]" + " registered to weather tower.");
        this.registerTower(weatherTower);
    }
}
