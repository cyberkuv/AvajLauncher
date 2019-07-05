package Weather;

import Simulator.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static  String[] weather = { "RAIN", "SNOW", "FOG", "SUN" };
    private WeatherProvider() {}
    public static WeatherProvider getProvider() {
        if(weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates) {
        Random random = new Random();
        int r = random.nextInt(4);
        return weather[r];
    }
}
