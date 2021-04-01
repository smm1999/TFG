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


	static int m=0;//Contador del total de filas leidas del CSV
	
	 public static List<ExitoMusical> Exitos = new ArrayList<ExitoMusical>(); // Lista donde guardaremos los datos del CSV
     public static List<String> Canciones = new ArrayList<String>(); // Lista donde guardaremos todas las canciones diferentes
     public static List<ExitoMusical> ExitosOrdenadosFecha = new ArrayList<ExitoMusical>(); // Lista donde guardaremos todas las canciones ordenadas por fecha

	
	public static void main(String[] args) throws ParseException, IOException {

        System.out.println("Comienza la ejecución con la correspondiente lectura del CSV...");
        ImportarCSV2();
        System.out.println("CSV leido correctamente; Datos añadidos al array con exito");
        System.out.println("Creacion del primer CSV con las cadenas por cada cancion...");
        ExpotarCSV(Exitos);
	}

	
	public static void ExpotarCSV(List<ExitoMusical> Exitos) throws IOException {
		String salidaArchivo = "Patron.csv"; //Nombre del archivo donde guardaremos las cadenas de las diferentes canciones
		boolean existe = new File(salidaArchivo).exists();//verificamos que existe el archivo
		
			if(existe) {
			
				boolean fichero = new File(salidaArchivo).delete();//En el caso de que exista el fichero lo elimina para crear un nuevo y no te tener que sobreescribir ¡
           
			}
			
			CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            
            // Datos para identificar las columnas
            salidaCSV.write("Region|RangoPosicion");//escribimos los indicadores
            
            salidaCSV.endRecord(); // Deja de escribir en el archivo

            for(String cancion : Canciones) {//Recorremos cada cancion dentro de nuestro array
            	for(ExitoMusical song : ExitosOrdenadosFecha) {//Recorremos el array con toda la informacion completa ordenada por fecha
            		
            		if(cancion.equals(song.URL)){//De esta manera cada vez que aparece la misma cancion se añade informacion a la cadena, logrando obtener una unica cadena por cada cancion
            			
            			
            			if(song.getPosicion()>=1 && song.getPosicion()<=10) {
                			String cadena = song.getRegion()+"|"+"1-10";
                			salidaCSV.write(cadena);
            				
            			}
            			else if (song.getPosicion()>=11 && song.getPosicion()<=25) {
                			String cadena = song.getRegion()+"|"+"11-25";
                			salidaCSV.write(cadena);
            				
            			}
            			else if (song.getPosicion()>=26 && song.getPosicion()<=50) {
                			String cadena = song.getRegion()+"|"+"26-50";
                			salidaCSV.write(cadena);
            				
            			}
            			else if (song.getPosicion()>=51 && song.getPosicion()<=100) {
                			String cadena = song.getRegion()+"|"+"51-100";
                			salidaCSV.write(cadena);
            				
            			}
            			else if (song.getPosicion()>=101 && song.getPosicion()<=200) {
                			String cadena = song.getRegion()+"|"+"101-200";
                			salidaCSV.write(cadena);
            				
            			}
            		}           	
            	}
            	salidaCSV.endRecord();
	
            try {
            	
            	//Crea el archivo
            	CsvWriter salidaCSV1 = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            	
            } 
            catch (Exception e) {
            	
            	e.printStackTrace();
            	
            }	
		
		}
            
        System.out.println("Escritura del primer CSV realizada con exito");
		
	}
	
	
	 
	 public static void ImportarCSV2() throws ParseException {
	        try{
	        	
	            CsvReader leerCanciones = new CsvReader("dataSintitulo.csv");//abrimos nuestro CSV
	            leerCanciones.readHeaders();//Leemos las cabeceras con los indicadores
	            
	            while(leerCanciones.readRecord()) {// Mientras haya lineas obtenemos los datos del archivo
	            	//leemos cada parte de las cadenas para mas tarde crear un objeto con ellas
	            	
	                int Position = Integer.parseInt(leerCanciones.get(0));
	                String URL = leerCanciones.get(1);
	                
	                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	                String Date = leerCanciones.get(2);
	                String Region = leerCanciones.get(3);
	                
	                m=m+1;//Contador del total de filas que lee
	                try {
		               
	                Exitos.add(new ExitoMusical(Position,URL,format.parse(Date),Region)); // Añade la informacion al Arraylist correspondiente
	                Canciones.add(URL);//Añadimos todas las canciones a un array para mas tarde eliminar los elementos repetidos
						
					} 
	                catch (Exception e) {
						e.printStackTrace();
						System.out.println("El total de lineas leidas es de " + m);
					}
	                	

	            }
	            
	            leerCanciones.close(); // Cierra el archivo
	            
	            System.out.println("Lectura realizada");
	            
	            ExitosOrdenadosFecha = Exitos;
	            Collections.sort(ExitosOrdenadosFecha);//hacemos uso de sort para asegurarnos de que al leer las filas estas están ordenadas por fila
	            
	            System.out.println("Array ordenador por fecha: ");
	            
	            int n1=0;
	            for(ExitoMusical song : ExitosOrdenadosFecha) {
	            	n1 = n1+1;
	            	System.out.println(n1 +" " + song.URL + " "+ song.Region + " " + song.fecha);
	            }
	            

	            
	            int cont=0;
	            for(String cancion : Canciones) {//Contamos el total de filas antes eliminar las repetidas
	                cont++;
	            }
	            
	            System.out.println("El total de lineas leidas es de: " + cont);
	            
	            //eliminamos los elementos repetidos de nuestro arraylist haciendo uso de un hashSet intermedio que no permite elementos repetidos
	            Set<String> hashSet = new HashSet<String>(Canciones);
	            Canciones.clear();
	            Canciones.addAll(hashSet);
	            
	            int cont1=0;
	            for(String cancion : Canciones) { //Contamos el total de canciones distintas despues de actualizar el arraylist
	            	
	                cont1++;
	            }
	            
	            System.out.println("El total de canciones distintas es de: " + cont1);
	            
	            
	        } catch(FileNotFoundException e) {
	        	
	            e.printStackTrace();
	            
	        } catch(IOException e) {
	        	
	            e.printStackTrace();
	        }

	 }
	 
}
