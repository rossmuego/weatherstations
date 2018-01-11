package ac.uk.napier.set07102cw2016;

import java.util.ArrayList;
import java.util.HashMap;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import mapgui.MapGui;

public class Answer09 {
	public static void main(String[] args) {
		System.out.println("Question 09");

		/*
		 * Importing the data from the Data.java Class to the question in the
		 * form of a HashMap
		 */

		HashMap<Integer, WeatherStation> dataHashMap = Data.getWeatherStations();

		/*
		 * Declaring initial variables and arrays.
		 */

		int count = 0;
		ArrayList<Coordinate> coordinates = new ArrayList<>();

		/*
		 * For loop, looping through the HashMap assigning the current
		 * WeatherStation to an object then putting the readings from the
		 * current station into an array
		 */

		for (WeatherStation weatherStation : dataHashMap.values()) {
			ArrayList<WeatherReading> readings = weatherStation.getWeatherReading();
			boolean found = true;

			/*
			 * Looping through the weather readings for the station getting the
			 * temperature for each reading and checks if it is greater or less
			 * than 0
			 */
			for (int i = 0; i < readings.size(); i++) {
				WeatherReading reading = readings.get(i);
				double temp = reading.getTempreture();

				/*
				 * if the temperature is less than or = to 0, set the found
				 * boolean to false.
				 */

				if (temp <= 0) {
					found = false;
				}
			}

			/*
			 * If the found variables is changed to true then add one to the
			 * counter of how many stations have a reading of <= to 0, and add
			 * the coordinate of that station to a coordinate object.
			 */

			if (found) {
				count++;
				double lat = weatherStation.getLatitude();
				double lon = weatherStation.getLongitude();
				Coordinate coordinate = new Coordinate(lat, lon);
				coordinates.add(coordinate);
			}
		}

		/*
		 * Displays the number of stations with no readings below 0 and outputs
		 * their location on the map.
		 */

		System.out.println("The number of stations with no readings of 0 or below is " + count);
		MapGui.showMap(coordinates);
	}
}
