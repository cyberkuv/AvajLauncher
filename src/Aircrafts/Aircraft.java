package Aircrafts;

import Simulator.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;
    private long nextId() { return idCounter++; }
    public Coordinates getCoordinates() { return this.coordinates; }
    protected Aircraft(String airName, Coordinates coordinates){
        this.name = airName;
        this.coordinates = coordinates;
        this.id = nextId();
    }
}
