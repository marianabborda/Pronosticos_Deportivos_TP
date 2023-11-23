package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class LectorDeArchivos {
	
	   private List<String[]> ronda;
	   private List<String[]> pronosticos;

	   public LectorDeArchivos(String rutaArchivo1, String rutaArchivo2) throws IOException {
	        Path pathArchivo1 = Paths.get(rutaArchivo1);
	        Path pathArchivo2 = Paths.get(rutaArchivo2);

	        String linea;
	        String cvsSplitBy = ";";

	        List<String[]> data1 = new ArrayList<>();
	        List<String[]> data2 = new ArrayList<>();

	        try (BufferedReader br1 = new BufferedReader(new FileReader(pathArchivo1.toString()))) {
	            while ((linea = br1.readLine()) != null) {
	                String[] filaData1 = linea.split(cvsSplitBy);
	                data1.add(filaData1);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        try (BufferedReader br2 = new BufferedReader(new FileReader(pathArchivo2.toString()))) {
	            while ((linea = br2.readLine()) != null) {
	                String[] filaData2 = linea.split(cvsSplitBy);
	                data2.add(filaData2);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        this.ronda = data1;
	        this.pronosticos = data2;
	    }
	   
	   public List<String[]> getRondas(){
		   return this.ronda;
	   }
	   
	   public List<String[]> getPronosticos(){
		   return this.pronosticos;
	   }

}





       


	   //para imprimir por consola los datos de las rondas y los pronósticos 
	  // public void imprimirDatos(List<String[]> datos) {
	   //     for (String[] fila : datos) {
	   //         for (String elemento : fila) {
	  //              System.out.print(elemento + " ");
	  //          }
	  //          System.out.println(); 
	   //     }
	  //  }
	//}




