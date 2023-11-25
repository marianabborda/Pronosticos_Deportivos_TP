package inicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import modelo.Equipo;
import modelo.Partido;
import modelo.Pronostico;
import modelo.ResultadoEnum;
import modelo.Ronda;
import controlador.PrincipalPI;
import controlador.PartidoController;
import controlador.ApuestaController;
import java.util.Map;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		        PrincipalPI conector = new PrincipalPI();

		        // Leer datos de resultados y pronósticos
		        List<String[]> valoresResultados = conector.conectar();
		        List<String[]> valoresPronosticos = conector.conectarr();

		        // Crear lista de partidos y pronósticos
		        List<Partido> listaPartidos = obtenerListaPartidos(valoresResultados);
		       // List<Pronostico> listaApuestas = obtenerListaPronosticos(valoresPronosticos, listaPartidos);

		        List<Pronostico> listaApuestas = obtenerListaPronosticos(valoresPronosticos, listaPartidos);
		        List<Ronda> listaRondas = obtenerListaRondas(valoresResultados);
		        
		        // Supongamos que tienes una instancia de Partido en la lista listaPartidos
		        Partido partidoEjemplo = listaPartidos.get(0);  // el índice según las necesidades

		        // Crea una instancia de PartidoController con el Partido de ejemplo
		       PartidoController partidoController = new PartidoController(partidoEjemplo);

		       // Ronda ronda = new Ronda("1", listaPartidos);

		        // Crear una única instancia de ApuestaController
		        ApuestaController apuestaController = new ApuestaController();

		        // Calcular puntajes para cada apostador
		     //  calcularPuntajesApostadores(listaApuestas, ronda, apuestaController);

		        // Imprimir los resultados por pantalla
		     // imprimirResultados(listaApuestas);
		  //// Calcular puntajes para cada apostador
		        calcularPuntajesApostadoresEnTodasLasRondas(listaApuestas, listaRondas, apuestaController);

		        // Imprimir los resultados por pantalla
		        imprimirResultadosTotales(listaApuestas);
		    }
	
	
	
	
	private static List<Partido> obtenerListaPartidos(List<String[]> valoresResultados) {
        List<Partido> listaPartidos = new ArrayList<>();

        for (int i = 1; i < valoresResultados.size(); i++) {
            String[] line = valoresResultados.get(i);
            Partido partido = new Partido(line[0], line[1], new Equipo(line[2]), new Equipo(line[5]),
                    Integer.parseInt(line[3]), Integer.parseInt(line[4]));
            listaPartidos.add(partido);
        }

        return listaPartidos;
    }

    private static List<Pronostico> obtenerListaPronosticos(List<String[]> valoresPronosticos,
            List<Partido> listaPartidos) {
        List<Pronostico> listaApuestas = new ArrayList<>();

        for (int i = 1; i < valoresPronosticos.size(); i++) {
            String[] line = valoresPronosticos.get(i);
            String nombreApostador = line[0];
            String nroRonda = line[1];
            String idPartido = line[2];
            ResultadoEnum resultadoEnum = ResultadoEnum.valueOf(line[3]);

            Partido partido = listaPartidos.stream()
                    .filter(p -> p.getNroRonda().equals(nroRonda) && p.getIdPartido().equals(idPartido)).findFirst()
                    .orElse(null);

            if (partido != null) {
                Pronostico pronostico = new Pronostico(nombreApostador, nroRonda, idPartido, resultadoEnum,
                        new PartidoController(partido));
                listaApuestas.add(pronostico);
            }
        }

        return listaApuestas;
    }

    private static List<Ronda> obtenerListaRondas(List<String[]> valoresResultados) {
        List<Ronda> listaRondas = new ArrayList<>();

        for (int i = 1; i < valoresResultados.size(); i++) {
            String nroRonda = valoresResultados.get(i)[0];
            Ronda ronda = new Ronda(nroRonda, new ArrayList<>());
            if (!listaRondas.contains(ronda)) {
                listaRondas.add(ronda);
            }
        }

        return listaRondas;
    }

   private static void calcularPuntajesApostadoresEnTodasLasRondas(List<Pronostico> listaApuestas,
            List<Ronda> listaRondas, ApuestaController apuestaController) {
        for (Pronostico pronostico : listaApuestas) {
            for (Ronda ronda : listaRondas) {
                int puntaje = pronostico.puntos(ronda);
                pronostico.setPuntajeTotal(pronostico.getPuntajeTotal() + puntaje);
            }
        }
   }
  

    private static void imprimirResultadosTotales(List<Pronostico> listaApuestas) {
        Map<String, Integer> puntajesTotales = new HashMap<>();
        Map<String, Integer> aciertosTotales = new HashMap<>();

        for (Pronostico pronostico : listaApuestas) {
            String nombreApostador = pronostico.getNombreApostador();
            int puntajeTotal = pronostico.getPuntajeTotal();

            puntajesTotales.put(nombreApostador, puntajesTotales.getOrDefault(nombreApostador, 0) + puntajeTotal);

            if (puntajeTotal > 0) {
                aciertosTotales.put(nombreApostador, aciertosTotales.getOrDefault(nombreApostador, 0) + 1);
            }
        }

        
       
     // Crear una lista de Map.Entry para ordenar los resultados
        List<Map.Entry<String, Integer>> resultList = new ArrayList<>(puntajesTotales.entrySet());

        // Ordenar la lista en orden descendente por puntajeTotal
        resultList.sort(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)));

        // Imprimir los resultados totales ordenados por puntajeTotal
        for (Map.Entry<String, Integer> entry : resultList) {
            String nombreApostador = entry.getKey();
            int puntajeTotal = entry.getValue();
            int aciertos = aciertosTotales.getOrDefault(nombreApostador, 0);

            System.out.println("Apostador: " + nombreApostador + ", Puntaje Total: " + puntajeTotal
                    + ", Aciertos Totales: " + aciertos);
        }
    }
}
	 

