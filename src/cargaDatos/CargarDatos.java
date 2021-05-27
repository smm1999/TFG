package cargaDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
import fpm.AssocRuleMiner;
import fpm.apriori.Apriori;
import fpm.data.ItemSets;
import fpm.data.MetaData;
import fpm.fpg.FPGrowth;

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
        ImportarCSVinicial();
        System.out.println("CSV leido correctamente; Datos añadidos al array con exito");
        System.out.println("Creacion del primer CSV con las cadenas por cada cancion...");
        ExpotarCSVsinRepeticiones(Exitos);
        System.out.println("Importacion del nuevo CSV");
        ImportarCSVpropioConFPGrowth();
        System.out.println("CSV de FPGrowth terminado con exito");
        ImportarCSVpropioConApriori();
        System.out.println("CSV de Apriori terminado con exito");
        System.out.println("Fin del programa");
	}

	 public static void ImportarCSVinicial() throws ParseException {
	        try{
	        	
	            CsvReader leerCanciones = new CsvReader("dataSintitulo.csv");//abrimos nuestro CSV
	            leerCanciones.readHeaders();//Leemos las cabeceras con los indicadores
	            
	            while(leerCanciones.readRecord()) {// Mientras haya lineas obtenemos los datos del archivo
	            	//leemos cada parte de las cadenas para mas tarde crear un objeto con ellas
	            	
	                int Position = Integer.parseInt(leerCanciones.get(0));//Posción de la canción
	                String URL = leerCanciones.get(1);//URL de la canción
	                
	                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");//Establecemos el formato de fechas

	                String Date = leerCanciones.get(2);//Leemos la fecha
	                String Region = leerCanciones.get(3);//Leemos la región
	                
	                m=m+1;//Contador del total de filas que lee
	                try {
		               
	                Exitos.add(new ExitoMusical(Position,URL,format.parse(Date),Region)); // Añade la informacion al Arraylist correspondiente
	                Canciones.add(URL);//Añadimos todas las canciones a un array para mas tarde eliminar los elementos repetidos y quedarnos con las canciones totales
						
					} 
	                catch (Exception e) {
						e.printStackTrace();
						System.out.println("El total de lineas leidas es de " + m);//Gracias a este contador sabriamos que linea exacta ha causado el error
					}
	                	

	            }
	            
	            leerCanciones.close(); // Cierra el archivo
	            
	            //A continuacion repetimos el proceso seguido con el resto de csv para añadir la totalidad de la inforamcion a nuestro programa
	            
	            CsvReader leerCanciones2 = new CsvReader("dataSintitulo2.csv");
	            leerCanciones2.readHeaders();
	            
	            while(leerCanciones2.readRecord()) {
	            	
	                int Position = Integer.parseInt(leerCanciones2.get(0));
	                String URL = leerCanciones2.get(1);
	                
	                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	                String Date = leerCanciones2.get(2);
	                String Region = leerCanciones2.get(3);
	                
	                m=m+1;
	                try {
		               
	                Exitos.add(new ExitoMusical(Position,URL,format.parse(Date),Region)); 
	                Canciones.add(URL);
						
					} 
	                catch (Exception e) {
						e.printStackTrace();
						System.out.println("El total de lineas leidas es de " + m);
					}
	                	

	            }
	            
	            leerCanciones2.close(); 
	            
	            CsvReader leerCanciones3 = new CsvReader("dataSintitulo3.csv");
	            leerCanciones3.readHeaders();
	            
	            while(leerCanciones3.readRecord()) {
	            	
	            	
	                int Position = Integer.parseInt(leerCanciones3.get(0));
	                String URL = leerCanciones3.get(1);
	                
	                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	                String Date = leerCanciones3.get(2);
	                String Region = leerCanciones3.get(3);
	                
	                m=m+1;
	                try {
		               
	                Exitos.add(new ExitoMusical(Position,URL,format.parse(Date),Region));
	                Canciones.add(URL);
						
					} 
	                catch (Exception e) {
						e.printStackTrace();
						System.out.println("El total de lineas leidas es de " + m);
					}
	                	

	            }
	            
	            leerCanciones3.close();
	            
	            CsvReader leerCanciones4 = new CsvReader("dataSintitulo4.csv");
	            leerCanciones4.readHeaders();
	            
	            while(leerCanciones4.readRecord()) {
	            	
	            	
	                int Position = Integer.parseInt(leerCanciones4.get(0));
	                String URL = leerCanciones4.get(1);
	                
	                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	                String Date = leerCanciones4.get(2);
	                String Region = leerCanciones4.get(3);
	                
	                m=m+1;
	                try {
		               
	                Exitos.add(new ExitoMusical(Position,URL,format.parse(Date),Region));
	                Canciones.add(URL);
						
					} 
	                catch (Exception e) {
						e.printStackTrace();
						System.out.println("El total de lineas leidas es de " + m);
					}
	                	

	            }
	            
	            leerCanciones4.close(); 
	            
	            
	            System.out.println("Lectura realizada");
	            
	            ExitosOrdenadosFecha = Exitos;
	            Collections.sort(ExitosOrdenadosFecha);//Hacemos uso de sort para asegurarnos de que al leer las filas estas están ordenadas por fecha
	            
	            int n1=0;
	            //Seguido realizaremos un impresion por pantalla para asegurar el correcto estado de los datos y que están en el orden esperado
	            for(ExitoMusical song : ExitosOrdenadosFecha) {
	            	n1 = n1+1;
	            	System.out.println(n1 +" " + song.URL + " "+ song.Region + " " + song.fecha);
	            }
	            

	            
	            int cont=0;
	            for(String cancion : Canciones) {//Contamos el total de filas antes eliminar las repetidas
	                cont++;
	            }
	            
	            System.out.println("El total de lineas leidas es de: " + cont); //imprimimos el total de lineas para asegurarnos que corresponde con la totalidad de los csv
	            
	            //eliminamos los elementos repetidos de nuestro arraylist haciendo uso de un hashSet intermedio, el cual no permite elementos repetidos
	            Set<String> hashSet = new HashSet<String>(Canciones);
	            Canciones.clear();
	            Canciones.addAll(hashSet);//Tras esto tendremos un array con la totalidad de las diferentes canciones de nuestro conjunto de datos
	            
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

	public static void ExpotarCSVconRepeticiones(List<ExitoMusical> Exitos) throws IOException {
		String salidaArchivo = "Patron.csv"; //Nombre del archivo donde guardaremos las cadenas de las diferentes canciones
		boolean existe = new File(salidaArchivo).exists();//verificamos que existe el archivo
		
			if(existe) {
			
				boolean fichero = new File(salidaArchivo).delete();//En el caso de que exista el fichero lo elimina para crear un nuevo y no te tener que sobreescribir
           
			}
			
			CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            
            // Datos para identificar las columnas
            salidaCSV.write("Region|RangoPosicion");//escribimos los indicadores
            
            salidaCSV.endRecord(); // Deja de escribir en el archivo
            salidaCSV.flush(); //limpiamos para evitar posibles errores

            for(String cancion : Canciones) {//Recorremos cada canción dentro de nuestro array
            	for(ExitoMusical song : ExitosOrdenadosFecha) {//Recorremos el array con toda la informacion completa ordenada por fecha
            		
            		String cadenaCancion="";
            		if(cancion.equals(song.URL)){//De esta manera cada vez que aparece la misma canción se añade informacion a la cadena, logrando obtener una única cadena por cada canción
            			
            			String cadena="";
            			//Estas canciones seran clasificadas por rango para ayudar al uso de los algoritmos
            			if(song.getPosicion()>=1 && song.getPosicion()<=10) {
                			cadena = song.getRegion()+"|"+"1-10";
                			salidaCSV.write(cadena);
            				
            			}
            			else if (song.getPosicion()>=11 && song.getPosicion()<=25) {
                			cadena = song.getRegion()+"|"+"11-25";
                			salidaCSV.write(cadena);
            				
            			}
            			else if (song.getPosicion()>=26 && song.getPosicion()<=50) {
                			cadena = song.getRegion()+"|"+"26-50";
                			salidaCSV.write(cadena);
            				
            			}
            			else if (song.getPosicion()>=51 && song.getPosicion()<=100) {
                			cadena = song.getRegion()+"|"+"51-100";
                			salidaCSV.write(cadena);
            				
            			}
            			else if (song.getPosicion()>=101 && song.getPosicion()<=200) {
                			cadena = song.getRegion()+"|"+"101-200";
                			salidaCSV.write(cadena);
            				
            			}

            		}
            		
            	}
            	salidaCSV.endRecord();//dejamos de escribrir
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
	
	
	public static void ExpotarCSVsinRepeticiones(List<ExitoMusical> Exitos) throws IOException {
		String salidaArchivo = "Patron.csv"; //Nombre del archivo donde guardaremos las cadenas de las diferentes canciones
		boolean existe = new File(salidaArchivo).exists();//Verificamos que existe el archivo
		
			if(existe) {
			
				boolean fichero = new File(salidaArchivo).delete();//En el caso de que exista el fichero lo elimina para crear un nuevo y no te tener que sobreescribir ¡
           
			}
			
			CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            
            //Datos para identificar las columnas
            salidaCSV.write("Region|RangoPosicion");//Escribimos los indicadores
            
            salidaCSV.endRecord(); //Deja de escribir en el archivo
            salidaCSV.flush(); //Limpiamos los buffer

            for(String cancion : Canciones) {//Recorremos cada canción dentro de nuestro array
            	String previo="";
            	for(ExitoMusical song : ExitosOrdenadosFecha) {//Recorremos el array con toda la información completa ordenada por fecha
            		
            		String cadenaCancion="";
            		if(cancion.equals(song.URL)){//De esta manera cada vez que aparece la misma canción se añade informacion a la cadena, logrando obtener una única cadena por cada canción
            			
            			String cadena="";
            			//Estas canciones seran clasificadas por rango para ayudar al uso de los algoritmos, además nos aseguraremos de evitar repeticiones respecto a la anterior aparición

            			if(song.getPosicion()>=1 && song.getPosicion()<=10) {
                			cadena = song.getRegion()+"|"+"1-10";
            			}
            			else if (song.getPosicion()>=11 && song.getPosicion()<=25) {
                			cadena = song.getRegion()+"|"+"11-25";
            				
            			}
            			else if (song.getPosicion()>=26 && song.getPosicion()<=50) {
                			cadena = song.getRegion()+"|"+"26-50";
            				
            			}
            			else if (song.getPosicion()>=51 && song.getPosicion()<=100) {
                			cadena = song.getRegion()+"|"+"51-100";
            				
            			}
            			else if (song.getPosicion()>=101 && song.getPosicion()<=200) {
                			cadena = song.getRegion()+"|"+"101-200";
            				
            			}
            			
            			if (previo.equals(cadena)) {
            				//Si la nueva cadena es igual que la anterior no hacemos nada
            			}
            			else {
            				//Si la cadena cambia respecto a la anterior se considera información de utilidad y será escrita
            				salidaCSV.write(cadena);
            				previo = cadena;//Machacamos el valor para la siguiente iteración
            			}
            			

            		}
            		
            	}
            	salidaCSV.endRecord();//Completamos
	
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
	
	
	 	 
	 
	 public static void ImportarCSVpropioConFPGrowth() throws ParseException {
	        try{
	        	
	            CsvReader leerCanciones = new CsvReader("Patron.csv");//abrimos nuestro CSV
	            leerCanciones.readHeaders();//Leemos las cabeceras con los indicadores
	            
	            List<List<String>> database = new ArrayList<>();//Creamos la base de datos para aplicar los algoritmos
	            
	            while(leerCanciones.readRecord()) {// Mientras haya lineas obtenemos los datos del archivo
	            	//leemos cada parte de las cadenas para mas tarde crear un objeto con ellas
	            	
	                String CadenaCompleta = leerCanciones.getRawRecord();
	                //System.out.println(CadenaCompleta);
	                database.add(Arrays.asList(CadenaCompleta));
	      
	            }
	            
	            leerCanciones.close(); // Cierra el archivo
	            
	            
	            try {
	            	
	            	String salidaArchivo = "SolucionFPgrowth.csv"; //Nombre del archivo donde se guardan los resultados del algoritmo FPgrowth
	            	boolean existe = new File(salidaArchivo).exists();//verificamos que existe el archivo
	            		
	            		if(existe) {
	            			
	            			boolean fichero = new File(salidaArchivo).delete();//En el caso de que exista el fichero lo elimina para crear un nuevo y no te tener que sobreescribir
	                       
	            		}
	            	CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
	                        
	                // Datos para identificar las columnas
	                salidaCSV.write("Item-set: 'cadena' (nivel de soporte de la cadena)");//escribimos los indicadores
	                        
	                salidaCSV.endRecord(); // Deja de escribir en el archivo
						
	            	
	            	AssocRuleMiner method = new FPGrowth();//Elegimos el algoritmo a utilizar sobre los datos
	                method.setMinSupportLevel(2);//Elegimos el nivel de soporte mínimo que consideramos de interes

	                MetaData metaData = new MetaData(database);//Aplicamos la función de datos a la database

	                //Escribimos todos los resultados obtenido con nivel de soporte superior a 2 en nuestro fichero además de hacer una impresión por pantalla a forma de comprobación
	                ItemSets frequent_item_sets = method.minePatterns(database, metaData.getUniqueItems());
	                frequent_item_sets.stream().forEach((itemSet) -> {
	                	
						try {
							//Procedemos a escribir los resultados en el fichero
							salidaCSV.write("item-set: " + itemSet);
			                salidaCSV.endRecord();
			                System.out.println("item-set: " + itemSet);
			                
						} catch (IOException e) {
							
							e.printStackTrace();
						}
						
	                });
	                salidaCSV.write("Final del csv de FPGrowth");
	                salidaCSV.endRecord();//Acabamos la escritura
	                salidaCSV.flush();//Limpiamos el buffer
	                salidaCSV.close();//Cerramos nuestro archivo 
	                
				} catch (Exception e) {
					e.printStackTrace();
				}
                
	            
	            
	        } catch(FileNotFoundException e) {
	        	
	            e.printStackTrace();
	            
	        } catch(IOException e) {
	        	
	            e.printStackTrace();
	        }

	 }
	 //A continuación repetiremos el mismo proceso para el caso del algoritmo Apriori, el cual será mas lento que el anterior pero que nos servirá para constrastar resultados entre ambos
	 public static void ImportarCSVpropioConApriori() throws ParseException {
	        try{
	        	
	            CsvReader leerCanciones = new CsvReader("Patron.csv");
	            leerCanciones.readHeaders();
	            
	            List<List<String>> database = new ArrayList<>();
	            
	            while(leerCanciones.readRecord()) {
	            	
	                String CadenaCompleta = leerCanciones.getRawRecord();
	                database.add(Arrays.asList(CadenaCompleta));
	      
	            }
	            
	            leerCanciones.close();
	            
	            
	            try {
	            	
	            	String salidaArchivo = "SolucionApriori.csv";
	            	boolean existe = new File(salidaArchivo).exists();
	            		
	            		if(existe) {
	            			
	            			boolean fichero = new File(salidaArchivo).delete();
	                       
	            		}
	            	CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
	                        
	                
	                salidaCSV.write("Item-set: 'cadena' (nivel de soporte de la cadena)");
	                        
	                salidaCSV.endRecord();
						
	            	
	                AssocRuleMiner method = new Apriori();
	                method.setMinSupportLevel(2);

	                MetaData metaData = new MetaData(database);
	                
	                ItemSets frequent_item_sets = method.minePatterns(database, metaData.getUniqueItems());
	                frequent_item_sets.stream().forEach((itemSet) -> {
	                	
	                
							try {
								salidaCSV.write(" item-set: " + itemSet);
								salidaCSV.endRecord();
								System.out.println("item-set: " + itemSet);
							} catch (IOException e) {
								e.printStackTrace();
							}
						
	                });
	                salidaCSV.write("Final del csv de Apriori");
	                salidaCSV.endRecord();
	                salidaCSV.flush();
	                salidaCSV.close();
	                
				} catch (Exception e) {
					e.printStackTrace();
				}
             
	            
	            
	        } catch(FileNotFoundException e) {
	        	
	            e.printStackTrace();
	            
	        } catch(IOException e) {
	        	
	            e.printStackTrace();
	        }

	 }
	 
}
