package clases;
import java.util.Date;
public class Cancion {
	public int Position;
	public String Track_Name;
	public String Artist;
	public String Stream;
	public String URL;
	public Date Date;
	public String Region;

	public Cancion(int position, String track_Name, String artist, String stream, String uRL, java.util.Date date,
			String region) {
		super();
		Position = position;
		Track_Name = track_Name;
		Artist = artist;
		Stream = stream;
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


	public String getTrack_Name() {
		return Track_Name;
	}


	public void setTrack_Name(String track_Name) {
		Track_Name = track_Name;
	}


	public String getArtist() {
		return Artist;
	}


	public void setArtist(String artist) {
		Artist = artist;
	}


	public String getStream() {
		return Stream;
	}


	public void setStream(String stream) {
		Stream = stream;
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