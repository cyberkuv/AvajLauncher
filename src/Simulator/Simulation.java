package Simulator;

import Aircrafts.AircraftFactory;
import Weather.WeatherTower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<Flyable>();
    public static void main(String args[]) throws InterruptedException{
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            if(line != null){
                weatherTower = new WeatherTower();
                int simulation = Integer.parseInt(line.split(" ")[0]);
                if(simulation < 0) {
                    System.out.println("Simulation : Value must be a positive one");
                    System.exit(1);
                }
                while((line = reader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                    if(flyable != null)
                        flyables.add(flyable);
                }
                for(Flyable flyable : flyables)
                    flyable.registerTower(weatherTower);
                for(int x = 1; x <= simulation; x++)
                    weatherTower.changeWeather();
            }
        } catch(FileNotFoundException e){
            System.out.println("Simulation : " + e + "\n" + "Simulation : File Not Found " + args[0]);
        } catch(IOException e) {
            System.out.println("Simulation : " + e);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Simulation : " + e);
        } catch(NumberFormatException e) {
            System.out.println("Simulation : Invalid Number entered " + e);
        } finally {
            FileWrite.getFileWrite().Close();
        }
    }
}
