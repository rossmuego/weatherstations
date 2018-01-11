package ac.uk.napier.set07102cw2016;

import java.util.HashMap;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import mapgui.MapGui;

public class Answer08 {
	public static void main(String[] args) {
		System.out.println("Question 08");

		/*
		 * Importing the data from the Data.java Class to the question in the
		 * form of a HashMap
		 */

		HashMap<Integer, WeatherStation> dataHashMap = Data.getWeatherStations();

		/*
		 * Declaring initial variables.
		 */

		double maxTemp = 0;
		double minTemp = Integer.MAX_VALUE;
		double meanTemp = 0;
		int count = 0;
		double totalTemp = 0;

		/*
		 * Looping through the readings in the HashMap at key 3840
		 */

		for (int i = 0; i < dataHashMap.get(3840).getWeatherReading().size(); i++) {

			/*
			 * Setting month, hour, current temperature and siteID variables to
			 * values from the HashMap
			 */
			int month = dataHashMap.get(3840).getWeatherReading().get(i).getMonth();
			int hour = dataHashMap.get(3840).getWeatherReading().get(i).getHour();
			double currentTemp = dataHashMap.get(3840).getWeatherReading().get(i).getTempreture();
			int siteID = dataHashMap.get(3840).getWeatherReading().get(i).getSiteId();

			/*
			 * An IF statement to add the temperature to the total temperature
			 * if the month is June, and it is 11am and the site ID is 3840.
			 * Then checking to see if that Temperate is a max or minimum
			 * temperature.
			 */

			if ((month == 7) && (hour == 11) && (siteID == 3840)) {

				// Creating a total temperature in order to work out the mean

				totalTemp = totalTemp + currentTemp;
				count++;

				// Working out if the current temperate is the maximum
				// temperature

				if (currentTemp > maxTemp) {
					maxTemp = currentTemp;
				}

				// Checking if the current temperature is the minimum temperate.

				if (currentTemp < minTemp) {
					minTemp = currentTemp;
				}
			}
		}

		// Calculating the mean temperature

		meanTemp = totalTemp / count;

		// Outputting the results of the maximum, minimum and mean temperature.

		System.out.println("The minimum temp is: " + minTemp);
		System.out.println("The maximum temp is: " + maxTemp);
		System.out.println("The average temp is: " + meanTemp);

		/*
		 * Setting a new WeatherStation called fewestWeath to the values of the
		 * WeatherStation 3840 and then displaying the map with the station on
		 * it
		 */

		WeatherStation fewestWeath = dataHashMap.get(3840);
		double lat = fewestWeath.getLatitude();
		double lon = fewestWeath.getLongitude();

		Coordinate coordinates = new Coordinate(lat, lon);
		MapGui.showMap(coordinates);
	}
}
