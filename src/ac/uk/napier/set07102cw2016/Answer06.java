package ac.uk.napier.set07102cw2016;

import java.util.ArrayList;
import java.util.HashMap;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import mapgui.MapGui;

public class Answer06 {
	public static void main(String[] args) {
		System.out.println("Question 06");

		/*
		 * Importing the data from the Data.java Class to the question in the
		 * form of a HashMap
		 */

		HashMap<Integer, WeatherStation> dataHashMap = Data.getWeatherStations();

		/*
		 * Declaring initial variables.
		 */

		int minvalue = Integer.MAX_VALUE;
		int id = 0;

		/*
		 * For loop, looping through the HashMap assigning the current
		 * WeatherStation to an object then putting the readings from the
		 * current station into an array
		 */

		for (WeatherStation station : dataHashMap.values()) {
			ArrayList<WeatherReading> readings = station.getWeatherReading();

			/*
			 * Getting the size of the array of readings from the current
			 * weather station.
			 */

			int size = readings.size();

			/*
			 * Checking if the current array is smaller than the station with
			 * the fewest readings. If it is then setting the new minimum list
			 * size to the size of the current array and getting the ID of that
			 * weather station
			 */

			if (size < minvalue) {
				minvalue = size;
				id = station.getSiteId();
			}
		}

		/*
		 * Creating a new weather station with the values from the weather
		 * station with the fewest readings, then getting the latitude and
		 * longitude of that station and plotting it on the map.
		 */

		WeatherStation fewestWeath = dataHashMap.get(id);
		System.out.println(fewestWeath);
		double lat = fewestWeath.getLatitude();
		double lon = fewestWeath.getLongitude();

		Coordinate coordinates = new Coordinate(lat, lon);
		MapGui.showMap(coordinates);
	}
}
