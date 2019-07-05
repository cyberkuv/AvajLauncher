package Aircrafts;

import Simulator.Coordinates;
import Simulator.FileWrite;
import Simulator.Flyable;
import Weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    public JetPlane(String name, Coordinates coordinates){ super(name, coordinates); }
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN" : this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                FileWrite.getFileWrite().writeToFile("JetPlane#" + this.name + "[" + this.id + "]" +
                        " Its raining! better watch out for lightning.");
                break ;
            case "SNOW" : this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                FileWrite.getFileWrite().writeToFile("JetPlane#" + this.name + "[" + this.id + "]" +
                        " Damn! looks like winter is around the corner.");
                break ;
            case "FOG" : this.coordinates.setHeight(this.coordinates.getHeight() - 10);
                FileWrite.getFileWrite().writeToFile("JetPlane#" + this.name + "[" + this.id + "]" +
                        " Damn! so foggy.");
                break ;
            case "SUN" :
                this.coordinates.setHeight(this.coordinates.getHeight() - 20);
                FileWrite.getFileWrite().writeToFile("JetPlane#" + this.name + "[" + this.id + "]" +
                        " This is hot.");
                break ;
            default :
                FileWrite.getFileWrite().writeToFile("JetPlane#" + this.name + "[" + this.id + "]" +
                        " : weather tower cannot be contacted right now!");
                break ;
        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        FileWrite.getFileWrite().writeToFile("Tower says : JetPlane#" + this.name + "[" + this.id + "]" +
                " registered to weather tower.");
        this.registerTower(weatherTower);
    }
}
