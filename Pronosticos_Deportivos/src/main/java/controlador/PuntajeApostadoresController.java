package controlador;

import modelo.Pronostico;
import modelo.Ronda;

import java.util.List;

public class PuntajeApostadoresController {
    public static void calcularPuntajesApostadoresEnTodasLasRondas(List<Pronostico> listaApuestas,
            List<Ronda> listaRondas,ApuestaController apuestaController) {
    		for (Pronostico pronostico : listaApuestas) {
    			for (Ronda ronda : listaRondas) {
    				int puntaje = pronostico.puntos(ronda);
    				pronostico.setPuntajeTotal(pronostico.getPuntajeTotal() + puntaje);
    			}
    		}
    }
}

