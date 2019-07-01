package Simulator;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;
    public Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
        if (longitude < 0 || latitude < 0)
            System.out.println("Coordinates : value must be positive");
        if (height > 100)
            this.height = 100;
        else if (height < 0)
            System.out.println("Coordinates : Takeoff impossible at such height");
    }
    public int getLongitude() {
        return this.longitude;
    }
    public int getLatitude() {
        return this.latitude;
    }
    public int getHeight() {
        return this.height;
    }
}
