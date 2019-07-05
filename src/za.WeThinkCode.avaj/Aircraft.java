package AvajLauncher.src.za.WeThinkCode.avaj;

import AvajLauncher.src.za.WeThinkCode.avaj.*;

public class Aircraft {
    protected Long id;
    protected String name;
    protected Coordinates coordinates;
    private static Long idCounter = 0L;
    private long nextId() { return ++idCounter; }
    public Coordinates getCoordinates() { return this.coordinates; }
    protected Aircraft(String airName, Coordinates coordinates){
        this.name = airName;
        this.coordinates = coordinates;
        this.id = this.nextId();
    }
}
