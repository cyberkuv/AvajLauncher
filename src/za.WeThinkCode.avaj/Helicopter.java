package AvajLauncher.src.za.WeThinkCode.avaj;

import AvajLauncher.src.za.WeThinkCode.avaj.*;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    Helicopter(String name, Coordinates coordinates){ super(name, coordinates); }
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN" : this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                FileWrite.getFileWrite().writeToFile("Helicopter#" + this.name + "[" + this.id + "]" +
                    " Damn this bloody rain");
                break ;
            case "SNOW" : this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                FileWrite.getFileWrite().writeToFile("Helicopter#" + this.name + "[" + this.id + "]" +
                        " My rotor is going to freeze ");
                break ;
            case "FOG" : this.coordinates.setHeight(this.coordinates.getHeight() - 10);
                FileWrite.getFileWrite().writeToFile("Helicopter#" + this.name + "[" + this.id + "]" +
                        " man i cant see shit!");
                break ;
            case "SUN" : this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                if(this.coordinates.getHeight() > 100)
                    this.coordinates.setHeight(100);
                FileWrite.getFileWrite().writeToFile("Helicopter#" + this.name + "[" + this.id + "]" +
                        " This is hot.");
                break ;
            default :
                FileWrite.getFileWrite().writeToFile("Helicopter#" + this.name + "[" + this.id + "]" +
                        " : Weather Tower cannot be contacted right now!");
                break ;
        }
        if(this.coordinates.getHeight() <= 0) {
            FileWrite.getFileWrite().writeToFile("Helicopter#" + this.name + "[" + this.id + "]" +
                    " hasn't taken off yet or rather just landed!");
            FileWrite.getFileWrite().writeToFile("Helicopter#" + this.name + "[" + this.id + "]" +
                    " unregistered from weather tower");
        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        FileWrite.getFileWrite().writeToFile("Tower says: Helicopter#" + this.name + "[" +
                this.id + "]" + " registered to weather tower.");
        weatherTower.register(this);
    }
}
