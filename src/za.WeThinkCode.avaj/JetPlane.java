package AvajLauncher.src.za.WeThinkCode.avaj;

import AvajLauncher.src.za.WeThinkCode.avaj.*;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    public JetPlane(String name, Coordinates coordinates){ super(name, coordinates); }
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN" : this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                FileWrite.getFileWrite().writeToFile("JetPlane#" + this.name + "[" + this.id + "]" +
                        " Its raining! better watch out for lightning.");
                break ;
            case "SNOW" : this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                FileWrite.getFileWrite().writeToFile("JetPlane#" + this.name + "[" + this.id + "]" +
                        " Damn! looks like winter is around the corner.");
                break ;
            case "FOG" : this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                FileWrite.getFileWrite().writeToFile("JetPlane#" + this.name + "[" + this.id + "]" +
                        " Damn! so foggy.");
                break ;
            case "SUN" : this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                if(this.coordinates.getHeight() > 100)
                    this.coordinates.setHeight(100);
                FileWrite.getFileWrite().writeToFile("JetPlane#" + this.name + "[" + this.id + "]" +
                        " This is hot.");
                break ;
            default :
                FileWrite.getFileWrite().writeToFile("JetPlane#" + this.name + "[" + this.id + "]" +
                        " : weather tower cannot be contacted right now!");
                break ;
        }
        if(this.coordinates.getHeight() <= 0) {
            FileWrite.getFileWrite().writeToFile("JetPlane#" + this.name + "[" + this.id + "]" +
                    " hasn't taken off yet or rather just landed!");
            FileWrite.getFileWrite().writeToFile("JetPlane#" + this.name + "[" + this.id + "]" +
                    " unregistered from weather tower.");
        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        FileWrite.getFileWrite().writeToFile("Tower says : JetPlane#" + this.name + "[" + this.id + "]" +
                " registered to weather tower.");
        weatherTower.register(this);
    }
}
