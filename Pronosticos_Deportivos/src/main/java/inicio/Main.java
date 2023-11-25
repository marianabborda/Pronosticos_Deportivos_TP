package inicio;

import java.util.ArrayList;
import java.util.List;
import modelo.Equipo;
import modelo.Partido;
import modelo.Pronostico;
import modelo.ResultadoEnum;
import modelo.Ronda;
import controlador.PrincipalPI;
import modelo.Apostador;
import controlador.PartidoController;
import controlador.ApuestaController;


public class Main {

	public static void main(String[] args) {
		
		        PrincipalPI conector = new PrincipalPI();

		        // Leer datos de resultados y pronósticos
		        List<String[]> valoresResultados = conector.conectar();
		        List<String[]> valoresPronosticos = conector.conectarr();

		        // Crear lista de partidos y pronósticos
		        List<Partido> listaPartidos = obtenerListaPartidos(valoresResultados);
		        List<Pronostico> listaApuestas = obtenerListaPronosticos(valoresPronosticos, listaPartidos);

		        // Supongamos que tienes una instancia de Partido en la lista listaPartidos
		        Partido partidoEjemplo = listaPartidos.get(0);  // el índice según las necesidades

		        // Crea una instancia de PartidoController con el Partido de ejemplo
		        PartidoController partidoController = new PartidoController(partidoEjemplo);

		        Ronda ronda = new Ronda("1", listaPartidos);

		        // Crear una única instancia de ApuestaController
		        ApuestaController apuestaController = new ApuestaController();

		        // Calcular puntajes para cada apostador
		        calcularPuntajesApostadores(listaApuestas, ronda, apuestaController);

		        // Imprimir los resultados por pantalla
		        imprimirResultados(listaApuestas);
		    }

		    private static List<Partido> obtenerListaPartidos(List<String[]> valoresResultados) {
		        List<Partido> listaPartidos = new ArrayList<>();

		        for (int i = 1; i < valoresResultados.size(); i++) {
		            String[] line = valoresResultados.get(i);
		            Partido partido = new Partido(
		                    line[0],
		                    line[1],
		                    new Equipo(line[2]),
		                    new Equipo(line[5]),
		                    Integer.parseInt(line[3]),
		                    Integer.parseInt(line[4])
		            );
		            listaPartidos.add(partido);
		        }

		        return listaPartidos;
		    }

		    private static List<Pronostico> obtenerListaPronosticos(List<String[]> valoresPronosticos, List<Partido> listaPartidos) {
		        List<Pronostico> listaApuestas = new ArrayList<>();

		        for (int i = 1; i < valoresPronosticos.size(); i++) {
		            String[] line = valoresPronosticos.get(i);
		            String nombreApostador = line[0];
		            String nroRonda = line[1];
		            String idPartido = line[2];
		            ResultadoEnum resultadoEnum = ResultadoEnum.valueOf(line[3]);

		            Partido partido = listaPartidos.stream()
		                    .filter(p -> p.getNroRonda().equals(nroRonda) && p.getIdPartido().equals(idPartido))
		                    .findFirst()
		                    .orElse(null);

		            if (partido != null) {
		                Pronostico pronostico = new Pronostico(nombreApostador, nroRonda, idPartido, resultadoEnum, new PartidoController(partido));
		                listaApuestas.add(pronostico);
		            }
		        }

		        return listaApuestas;
		    }

		    private static void calcularPuntajesApostadores(List<Pronostico> listaApuestas, Ronda ronda, ApuestaController apuestaController) {
		        for (Pronostico pronostico : listaApuestas) {
		            int puntaje = pronostico.puntos();
		            pronostico.setPuntaje(puntaje);
		        }
		    }

		    private static void imprimirResultados(List<Pronostico> listaApuestas) {
		        for (Pronostico pronostico : listaApuestas) {
		            System.out.println("Apostador: " + pronostico.getNombreApostador() +
		                    ", Puntaje en Ronda " + pronostico.getNroRonda() +" Partido número " + pronostico.getIdPartido() + ": " + pronostico.getPuntaje());
		          }
		    }
		}

		 
		//PrincipalPI conector = new PrincipalPI();
       		 
       // List<String[]> valores = conector.conectar();
      //  List<Partido> listaPartidos = new ArrayList<>();

       // for (int i = 1; i < valores.size(); i++) {
       //     String[] line = valores.get(i);
         //   Partido partido = new Partido(
          //  		(line[0]),
           // 		(line[1]),
           //         new Equipo(line[2]),
            //        new Equipo(line[5]),
             //       Integer.parseInt(line[3]),
             //       Integer.parseInt(line[4])
                   
           // );
          //  listaPartidos.add(partido);
            
       // }

        
        
        // Supongamos que tienes una instancia de Partido en la lista listaPartidos
       // Partido partidoEjemplo = listaPartidos.get(0);  //el índice según las necesidades

        // Crea una instancia de PartidoController con el Partido de ejemplo
       // PartidoController partidoController = new PartidoController(partidoEjemplo);
        
      //  List<String[]> valoresr = conector.conectarr();
       // List<Pronostico> listaApuestas = new ArrayList<>();
   

                
	   	/*    
	    for(int i = 1; i < valoresr.size(); i++) {
          String[] line = valoresr.get(i);	  
          Pronostico pronostico = new Pronostico(line[0],line[1], line[2], ResultadoEnum.valueOf(line[1]), partidoController);

           listaApuestas.add(pronostico);
            
	   }
        
       
	    	    
        Ronda ronda = new Ronda(ronda.getNroRonda(), listaPartidos);

        // Crear una única instancia de ApuestaController
        ApuestaController apuestaController = new ApuestaController();

        // Crear el Apostador con la lista de Pronósticos y la instancia de ApuestaController
        Apostador apostador = new Apostador("Nombre", listaApuestas, apuestaController);
	
        // Calcular el puntaje
         int puntaje = apostador.calcularPuntajeTotal(ronda);

        // Imprimir los resultados por pantalla
         System.out.println("Puntaje total de la persona es: " + puntaje);
       
	}
}
*/
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

