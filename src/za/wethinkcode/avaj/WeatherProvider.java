package src.za.wethinkcode.avaj;

import java.util.Random;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = null;
	private static String[] weather= { "SUN", "RAIN", "FOG", "SNOW"};
	private WeatherProvider() {}
	public static WeatherProvider getProvider() {
		if (weatherProvider == null) 
			weatherProvider = new WeatherProvider();
		return weatherProvider;
	}
	public String getCurrentWeather(Coordinates coordinates) {
		Random rand = new Random();
		int x = 0;
		x = rand.nextInt(4);
		return (weather[x]);
	}
}