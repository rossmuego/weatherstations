package ac.uk.napier.set07102cw2016;

public class WeatherReading {
    private int siteId;
    private String siteName;
	private int year;
	private int month;
	private int date;
	private int hour;
	private int windSpeed;
	private double tempreture;

	public WeatherReading(int siteId, String siteName, int year, int month, int date, int hour, int windSpeed, double tempreture) {
		super();
		this.siteId = siteId;
		this.siteName = siteName;
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.windSpeed = windSpeed;
		this.tempreture = tempreture;
	}

	public int getSiteId() {
		return siteId;
	}
	
	public String getSiteName() {
		return siteName;
	}
	
	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDate() {
		return date;
	}

	public int getHour() {
		return hour;
	}

	public int getWindSpeed() {
		return windSpeed;
	}

	public double getTempreture() {
		return tempreture;
	}
	
	@Override
	
	public String toString() {
		return "Reading: Year: "+ year + ", Month: "+ month + ", Date: "+ date +", Hour:"+ hour + ", Windspeed: "+ windSpeed + ", Tempreture: " + tempreture;
	}

}
