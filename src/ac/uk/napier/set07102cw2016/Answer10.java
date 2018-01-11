package ac.uk.napier.set07102cw2016;

import java.util.HashMap;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import mapgui.MapGui;

public class Answer10 {
	public static void main(String[] args) {
		System.out.println("Question 10");

		/*
		 * Importing the data from the Data.java Class to the question in the
		 * form of a HashMap
		 */

		HashMap<Integer, WeatherStation> dataHashMap = Data.getWeatherStations();

		/*
		 * Declaring initial variables.
		 */

		double mostSouth = Double.MAX_VALUE;
		double currentLat = 0;
		int id = 0;

		/*
		 * For loop, looping through the HashMap assigning the current
		 * WeatherStation.
		 */

		for (WeatherStation station : dataHashMap.values()) {

			/*
			 * For loop, looping through the readings within a the current
			 * WeatherStation and getting the Latitude for each reading.
			 */
			for (int i = 0; i < station.getWeatherReading().size(); i++) {
				currentLat = station.getLatitude();

				/*
				 * Checking if the current latitude reading is less than the
				 * most southernly latitude. If it is less than the most
				 * southernly, setting the most southernly to the current
				 * latitude
				 */

				if (currentLat < mostSouth) {
					mostSouth = currentLat;
					id = station.getSiteId();
				}
			}
		}

		/*
		 * Creating a new WeatherStation instance with the details of the most
		 * southernly weather station then get the longitude and latitude of
		 * that station, and displaying them on the map.
		 */

		WeatherStation mostSouthStation = dataHashMap.get(id);
		double lat = mostSouthStation.getLatitude();
		double lon = mostSouthStation.getLongitude();
		Coordinate coordinates = new Coordinate(lat, lon);
		MapGui.showMap(coordinates);
		System.out.println(mostSouthStation);

	}
}
