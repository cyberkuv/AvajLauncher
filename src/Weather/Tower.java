package Weather;

import Simulator.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();
    private List<Flyable> landed = new ArrayList<>();
    public void register(Flyable flyable) {
        if(observers.contains(flyable))
                return ;
        observers.add(flyable);
    }
    public void unregister(Flyable flyable) {  }
    protected void conditionsChanged() {
        for(Flyable flyable : observers) {
            flyable.updateConditions();
            if(flyable.getCoordinates().getHeight() <= 0)
                landed.add(flyable);
        }
        observers.removeAll(landed);
    }
}
