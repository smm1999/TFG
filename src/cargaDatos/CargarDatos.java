package cargaDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Date;
import java.util.HashSet;


import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import clases.Cancion;
import clases.CancionAcortada;
import clases.ExitoMusical;

import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.FileWriter;



public class CargarDatos {

	static int n=0;
	static int n1=0;
	static int m=0;
	
	 public static List<ExitoMusical> Exitos = new ArrayList<ExitoMusical>(); // Lista donde guardaremos los datos del archivo
     public static List<String> Canciones = new ArrayList<String>(); // Lista donde guardaremos las distintas canciones
     public static List<ExitoMusical> ExitosOrdenadosFecha = new ArrayList<ExitoMusical>(); // Lista donde guardaremos todas las canciones ordenadas por nombre

	
	public static void main(String[] args) throws ParseException, IOException {

        
        ImportarCSV2();
        ExpotarCSV(Exitos);
	}

	
	public static void ExpotarCSV(List<ExitoMusical> Exitos) throws IOException {
		String salidaArchivo = "Patron.csv"; //Nombre del archivo
		boolean existe = new File(salidaArchivo).exists();//verificamos que existe el archivo
		
		if(existe) {
			boolean fichero = new File(salidaArchivo).delete();
			
			CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            
            // Datos para identificar las columnas
            salidaCSV.write("Posicion");
            salidaCSV.write("Region");
            salidaCSV.write("URL");
            
            salidaCSV.endRecord(); // Deja de escribir en el archivo
            
            System.out.println("Llega");

            for(String cancion : Canciones) {
            	for(ExitoMusical song : ExitosOrdenadosFecha) {
            		
            		if(cancion.equals(song.URL)){
            			

            			if(song.getPosicion()>=1 && song.getPosicion()<=10) {
                			String cadena = song.getRegion()+"|"+"[1-10]";
                			salidaCSV.write(cadena);
            				
            			}
            			else if (song.getPosicion()>=11 && song.getPosicion()<=25) {
                			String cadena = song.getRegion()+"|"+"[11-25]";
                			salidaCSV.write(cadena);
            				
            			}
            			else if (song.getPosicion()>=26 && song.getPosicion()<=50) {
                			String cadena = song.getRegion()+"|"+"[26-50]";
                			salidaCSV.write(cadena);
            				
            			}
            			else if (song.getPosicion()>=51 && song.getPosicion()<=100) {
                			String cadena = song.getRegion()+"|"+"[51-100]";
                			salidaCSV.write(cadena);
            				
            			}
            			else if (song.getPosicion()>=101 && song.getPosicion()<=200) {
                			String cadena = song.getRegion()+"|"+"[101-200]";
                			salidaCSV.write(cadena);
            				
            			}
    	                /*salidaCSV.write(song.getRegion());
    	                //salidaCSV.write(song.getFecha().toString());
    	                salidaCSV.write(song.getURL());
    	                salidaCSV.write(song.getFecha().toString());
    	                //salidaCSV.write("->");
    	                //String cadenaAnterior = ""
    	                 */
            		}           	
            	}
            	salidaCSV.endRecord();
            }
	
	try {
     //Crea el archivo
     CsvWriter salidaCSV1 = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
     
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		
		
	}
		else {
			 CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
	            
	            // Datos para identificar las columnas
	            salidaCSV.write("Posicion");
	            salidaCSV.write("Region");
	            salidaCSV.write("URL");
	            
	            salidaCSV.endRecord(); // Deja de escribir en el archivo
	            
	            System.out.println("Llega");
	            
	            // Recorremos la lista y lo insertamos en el archivo
	            /*for(ExitoMusical song : Exitos) {
	            	String posicion = String.valueOf(song.getPosicion());
	                salidaCSV.write(posicion);
	                salidaCSV.write(song.getRegion());
	                //salidaCSV.write(song.getFecha().toString());
	                salidaCSV.write(song.getURL());
	                
	                salidaCSV.endRecord();
	            }*/
	            for(String cancion : Canciones) {
	            	for(ExitoMusical song : ExitosOrdenadosFecha) {
	            		
	            		if(cancion.equals(song.URL)){
	            			if(song.getPosicion()>=1 && song.getPosicion()<=10) {
	                			String cadena = song.getRegion()+"|"+"[1-10]";
	                			salidaCSV.write(cadena);
	            				
	            			}
	            			else if (song.getPosicion()>=11 && song.getPosicion()<=25) {
	                			String cadena = song.getRegion()+"|"+"[11-25]";
	                			salidaCSV.write(cadena);
	            				
	            			}
	            			else if (song.getPosicion()>=26 && song.getPosicion()<=50) {
	                			String cadena = song.getRegion()+"|"+"[26-50]";
	                			salidaCSV.write(cadena);
	            				
	            			}
	            			else if (song.getPosicion()>=51 && song.getPosicion()<=100) {
	                			String cadena = song.getRegion()+"|"+"[51-100]";
	                			salidaCSV.write(cadena);
	            				
	            			}
	            			else if (song.getPosicion()>=101 && song.getPosicion()<=200) {
	                			String cadena = song.getRegion()+"|"+"[101-200]";
	                			salidaCSV.write(cadena);
	            				
	            			}
	    	                /*salidaCSV.write(song.getRegion());
	    	                //salidaCSV.write(song.getFecha().toString());
	    	                salidaCSV.write(song.getURL());
	    	                salidaCSV.write(song.getFecha().toString());
	    	                //salidaCSV.write("->");
	    	                //String cadenaAnterior = ""
	    	                 */
	            		}           	
	            	}
	            	salidaCSV.endRecord();
	            }
		
		try {
         //Crea el archivo
         CsvWriter salidaCSV1 = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
         
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		}
	}
	
	
	 
	 public static void ImportarCSV2() throws ParseException {
	        try{
	        	
	            
	            
	            CsvReader leerCanciones = new CsvReader("dataSintitulo.csv");
	            leerCanciones.readHeaders();
	            // Mientras haya lineas obtenemos los datos del archivo
	            while(leerCanciones.readRecord()) {
	            	//boolean present=false;
	            	
	                int Position = Integer.parseInt(leerCanciones.get(0));
	                String URL = leerCanciones.get(1);
	                
	                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	                String Date = leerCanciones.get(2);
	                String Region = leerCanciones.get(3);
	                
		            /*for(String cancion : Canciones) {		        
		            	if (cancion == URL) {
		            		System.out.println("Cancion repetida");
							present=true;
							break; 
						} else {
							//System.out.println("Nueva cancion" + URL);
							present=false;
						}
		            }
		            
		            if (present==false) {
		            	//System.out.println("Cancion nueva insertada" + URL);
						Canciones.add(URL);
					}*/
	                
	                m=m+1;
	                try {
		               
	                Exitos.add(new ExitoMusical(Position,URL,format.parse(Date),Region)); // Añade la informacion a la lista
	                Canciones.add(URL);//Añadimos todas las canciones a un array para mas tarde eliminar los elementos repetidos
						
					} 
	                catch (Exception e) {
						e.printStackTrace();
						System.out.println(m);
					}
	                	

	            }
	            
	            leerCanciones.close(); // Cierra el archivo
	            
	            
	              /*for(ExitoMusical song : Exitos) {
	            	  boolean present=false;
	            	  for(String cancion : Canciones) {		        
			            	if (song.URL.toString() == cancion.toString()) {
			            		System.out.println("Cancion repetida");
								present=true;
								 
							} else {
								System.out.println(song.URL + " " + cancion);
								present=false;
							}
							break;
			            }
			            
			            if (present==false) {
			            	System.out.println("Cancion nueva insertada" + song.URL);
							Canciones.add(song.URL);
						}

	            }*/
	            
	            // Recorremos la lista y la mostramos en la pantalla
	           
	            for(ExitoMusical song : Exitos) {
	            	n=n+1;
	                System.out.println("fila" + n+ ", "
	                	+song.getPosicion() + " , "
	    	            +song.getURL()+ " , "
	    	            +song.getRegion());
	            }
	            
	            
	            ExitosOrdenadosFecha = Exitos;
	            Collections.sort(ExitosOrdenadosFecha);
	            
	            
	            for(ExitoMusical song : ExitosOrdenadosFecha) {
	            	n1=n1+1;
	            	System.out.println(n1 +" " + song.URL + " "+ song.Region + " " + song.fecha);
	            }
	            

	            
	            int cont=0;
	            for(String cancion : Canciones) {
	            	
	                //System.out.println(cancion);
	                cont++;
	            }
	            System.out.println(cont);
	            
	            //eliminamos los elementos repetidos de nuestro arraylist
	            Set<String> hashSet = new HashSet<String>(Canciones);
	            Canciones.clear();
	            Canciones.addAll(hashSet);
	            
	            int cont1=0;
	            for(String cancion : Canciones) { //Contamos el total de canciones distintas despues de actualizar el arraylist
	            	
	                cont1++;
	            }
	            System.out.println(cont1);
	            
	            

	            
	        } catch(FileNotFoundException e) {
	        	System.out.println(n);
	            e.printStackTrace();
	        } catch(IOException e) {
	        	System.out.println("2");
	            e.printStackTrace();
	        }

	 }
	 
}
