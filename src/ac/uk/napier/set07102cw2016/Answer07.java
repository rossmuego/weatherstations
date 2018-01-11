package ac.uk.napier.set07102cw2016;

import java.util.ArrayList;
import java.util.HashMap;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import mapgui.MapGui;

public class Answer07 {
	public static void main(String[] args) {
		System.out.println("Question 07");

		/*
		 * Importing the data from the Data.java Class to the question in the
		 * form of a HashMap
		 */

		HashMap<Integer, WeatherStation> dataHashMap = Data.getWeatherStations();

		/*
		 * Declaring initial variables.
		 */

		int id = 0;
		double highestTemp = 0;
		int highestTempHour = 0;
		int highestTempDay = 0;
		int highestTempMonth = 0;
		int highestTempYear = 0;

		/*
		 * For loop, looping through the HashMap assigning the current
		 * WeatherStation to an object then putting the readings from the
		 * current station into an array
		 */

		for (WeatherStation weatherStation : dataHashMap.values()) {
			ArrayList<WeatherReading> readings = weatherStation.getWeatherReading();

			/*
			 * Looping through the readings for the current weather station,
			 * getting the temperature, hour, day, month and year of the current
			 * reading.
			 */

			for (int i = 0; i < readings.size(); i++) {
				WeatherReading tempReadings = readings.get(i);
				double currentTemp = tempReadings.getTempreture();

				/*
				 * Checking if the current temperature reading is greater than
				 * the highest recorded temperature reading so far, if it is
				 * then it is setting the hour, day, month and year variables to
				 * the variables from the current reading and getting the id of
				 * that weather station.
				 */

				if (currentTemp > highestTemp) {
					highestTemp = currentTemp;
					id = weatherStation.getSiteId();
					highestTempHour = tempReadings.getHour();
					highestTempDay = tempReadings.getDate();
					highestTempMonth = tempReadings.getMonth();
					highestTempYear = tempReadings.getYear();
				}
			}
		}

		/*
		 * Creating a new weather station with the details of the weather
		 * station with the highest recorded temperature. Then displaying that
		 * weather station as well as the date and time it was recorded on along
		 * with what the highest temperature was and displaying that weather
		 * station on a map.
		 */

		WeatherStation fewestWeath = dataHashMap.get(id);
		System.out.println(fewestWeath + " recorded the highest temperature on the date " + highestTempDay + "/"
				+ highestTempMonth + "/" + highestTempYear + ", at hour " + highestTempHour
				+ ":00, with a temperature of " + highestTemp + " degrees.");
		double lat = fewestWeath.getLatitude();
		double lon = fewestWeath.getLongitude();

		Coordinate coordinates = new Coordinate(lat, lon);
		MapGui.showMap(coordinates);
	}
}
