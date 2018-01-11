package ac.uk.napier.set07102cw2016;

import weather.WeatherData;
import java.util.HashMap;

public class Data {

	public static HashMap<Integer, WeatherStation> getWeatherStations() {
		String[] weatherData = WeatherData.getData();
		HashMap<Integer, WeatherStation> weatherHash = new HashMap<>();

		for (int i = 1; i < weatherData.length; i++) {
			String line = weatherData[i];

			String[] elements = line.split(",");

			int siteId = Integer.parseInt(elements[0]);

			String siteName = elements[1];
			String latitudeString = elements[2];
			String longitudeString = elements[3];

			double latitude = Double.parseDouble(latitudeString);
			double longitude = Double.parseDouble(longitudeString);

			WeatherStation weatherStationObject = new WeatherStation(siteName, siteId, latitude, longitude);

			weatherHash.put(siteId, weatherStationObject);

		}

		for (int i = 1; i < weatherData.length; i++) {
			String line = weatherData[i];

			String[] elements = line.split(",");

			int siteId = Integer.parseInt(elements[0]);
			String siteName = elements[1];
			int year = Integer.parseInt(elements[4]);
			int month = Integer.parseInt(elements[5]);
			int date = Integer.parseInt(elements[6]);
			int hour = Integer.parseInt(elements[7]);
			int windSpeed = Integer.parseInt(elements[8]);
			double temperature = Double.parseDouble(elements[9]);

			WeatherStation weatherStationObject = weatherHash.get(siteId);

			WeatherReading weatherReadingObject = new WeatherReading(siteId, siteName, year, month, date, hour,
					windSpeed, temperature);

			weatherStationObject.addReading(weatherReadingObject);

		}
		return weatherHash;
	}
}