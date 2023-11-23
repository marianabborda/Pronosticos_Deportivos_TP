package inicio;

import java.util.ArrayList;
import java.util.List;
import modelo.Equipo;
import modelo.Partido;
import modelo.Pronostico;
import modelo.ResultadoEnum;
import modelo.Ronda;
import modelo.PrincipalPI;
import modelo.Apostador;
import controlador.PartidoController;
import controlador.ApuestaController;


public class Main {

	public static void main(String[] args) {		
		 
		PrincipalPI conector = new PrincipalPI();
       		 
        List<String[]> valores = conector.conectar();
        List<Partido> listaPartidos = new ArrayList<>();

        for (int i = 1; i < valores.size(); i++) {
            String[] line = valores.get(i);
            Partido partido = new Partido(
            		(line[0]),
                    new Equipo(line[1]),
                    new Equipo(line[4]),
                    Integer.parseInt(line[2]),
                    Integer.parseInt(line[3])
                   
            );
            listaPartidos.add(partido);
            
        }

        
        
        // Supongamos que tienes una instancia de Partido en la lista listaPartidos
        Partido partidoEjemplo = listaPartidos.get(0);  //el índice según las necesidades

        // Crea una instancia de PartidoController con el Partido de ejemplo
        PartidoController partidoController = new PartidoController(partidoEjemplo);
        
        List<String[]> valoresr = conector.conectarr();
        List<Pronostico> listaApuestas = new ArrayList<>();

                
	   	    
	    for(int i = 1; i < valoresr.size(); i++) {
            String[] line = valoresr.get(i);	  
            Pronostico pronostico = new Pronostico(line[0], ResultadoEnum.valueOf(line[1]), partidoController);

            listaApuestas.add(pronostico);
            
	    }
	    	    
        Ronda ronda = new Ronda("1", listaPartidos);

        // Crear una única instancia de ApuestaController
        ApuestaController apuestaController = new ApuestaController();

        // Crear el Apostador con la lista de Pronósticos y la instancia de ApuestaController
        Apostador apostador = new Apostador("Nombre","Apellido", listaApuestas, apuestaController);
	
        // Calcular el puntaje
         int puntaje = apostador.calcularPuntajeTotal(ronda);

        // Imprimir los resultados por pantalla
         System.out.println("Puntaje total de la persona es: " + puntaje);
       
	}
}
	//para imprimir  por consola los datos de las rondas y los pronósticos
	// try {
      //   LectorDeArchivos lector = new LectorDeArchivos("recursos/Resultados.csv", "recursos/Pronosticos.csv");
       //  System.out.println("Ruta del archivo 1: " + Paths.get("recursos/Resultados.csv").toAbsolutePath());
      //   System.out.println("Ruta del archivo 2: " + Paths.get("recursos/Pronosticos.csv").toAbsolutePath());

       //  System.out.println("Contenido de Rondas:");
     //    lector.imprimirDatos(lector.getRondas());

     //    System.out.println("\nContenido de Pronosticos:");
     //    lector.imprimirDatos(lector.getPronosticos());
    // } catch (IOException e) {
     //    e.printStackTrace();
    // }
// }
//}

