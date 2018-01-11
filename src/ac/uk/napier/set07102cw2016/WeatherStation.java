package ac.uk.napier.set07102cw2016;

import java.util.ArrayList;

public class WeatherStation {

	private String siteName;
	private int siteId;
	private double latitude;
	private double longitude;
	private ArrayList<WeatherReading> weatherReading = new ArrayList<>();

	public WeatherStation(String siteName, int siteId, double latitude, double longitude) {
		super();
		this.siteName = siteName;
		this.siteId = siteId;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public String getSiteName() {
		return siteName;
	}

	public int getSiteId() {
		return siteId;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void addReading(WeatherReading read) {
		weatherReading.add(read);
	}

	public ArrayList<WeatherReading> getWeatherReading() {
		return weatherReading;
	}

	@Override
	public String toString() {
		return "Station: Site Name = " + siteName + ", SiteId = " + siteId + ", Latitude = " + latitude
				+ ", Longitude = " + longitude;
	}
}