package AvajLauncher.src.za.WeThinkCode.avaj;

import AvajLauncher.src.za.WeThinkCode.avaj.*;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;
    public Coordinates(int longitude, int latitude, int height){
        setLongitude(longitude);
        setLatitude(latitude);
        setHeight(height);
//        if (longitude < 0 || latitude < 0)
//            System.out.println("Coordinates : value must be positive");
//        if (height > 100)
//            this.height = 100;
//        else if (height < 0)
//            System.out.println("Coordinates : Takeoff impossible at such height");
    }
    public int getLongitude() { return this.longitude; }
    public void setLongitude(int longitude) { this.longitude = longitude; }
    public int getLatitude() {
        return this.latitude;
    }
    public void setLatitude(int latitude) { this.latitude = latitude; }
    public int getHeight() {
        return this.height;
    }
    public void setHeight(int height) { this.height = height; }
}
