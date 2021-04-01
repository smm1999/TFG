package clases;

import java.util.Date;

public class ExitoMusical implements Comparable<ExitoMusical>{
	
	public int posicion;
	public String URL;
	public Date fecha;
	public String Region;
	
	
	
	
	public ExitoMusical(int posicion, String uRL, Date fecha, String region) {
		super();
		this.posicion = posicion;
		URL = uRL;
		this.fecha = fecha;
		Region = region;
	}




	public int getPosicion() {
		return posicion;
	}




	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}




	public String getURL() {
		return URL;
	}




	public void setURL(String uRL) {
		URL = uRL;
	}




	public Date getFecha() {
		return fecha;
	}




	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}




	public String getRegion() {
		return Region;
	}





	public int compareTo(ExitoMusical o) {
		return fecha.compareTo(o.getFecha());
	}
	
	
	
	
	

}
