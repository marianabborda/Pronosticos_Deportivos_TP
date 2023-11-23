package controlador;

import modelo.Pronostico;
import modelo.Partido;
import modelo.Ronda;



import java.util.List;

public class ApuestaController {
     public int calcularPuntaje(List<Pronostico> listaPronosticos, Ronda ronda) {
	
     int puntajeTotal = 0;

     for (int i = 0; i < listaPronosticos.size(); i++) {
        // Obtener el Pronostico y el Partido correspondiente
        Pronostico pronostico = listaPronosticos.get(i);
        Partido partido = ronda.getPartidos().get(i);
             // Verificar si el resultado del pronostico coincide con el resultado del partido
        if (pronostico.getResultadoEnum().equals(partido.getResultado())) {
            puntajeTotal += pronostico.puntos();
        }
    }

    return puntajeTotal;
}

}
