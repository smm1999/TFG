package clases;

import java.util.Date;

public class CancionAcortada {
	public int Position;
	public String URL;
	public Date Date;
	public String Region;
	
	
	
	public CancionAcortada(int position, String uRL, java.util.Date date, String region) {
		super();
		Position = position;
		URL = uRL;
		Date = date;
		Region = region;
	}
	
	public int getPosition() {
		return Position;
	}
	public void setPosition(int position) {
		Position = position;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}

	

}
