package controlador;

import modelo.Pronostico;
import modelo.Partido;
import modelo.ResultadoEnum;
import modelo.Ronda;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Prueba {

    @Test
    public void comparaTest() {
        assertEquals("Valeria", "Mariana");
    }

    @Test
    public void comparaTest1() {
        assertEquals("Mariana", "Mariana");
    }

    @Test
    public void calcularPuntajeSinAciertosTest() {
        // Crear instancias de Pronostico, Partido y Ronda para la prueba
        Pronostico pronostico1 = new Pronostico("Valeria", "1", "1", ResultadoEnum.Ganador_Equipo2, null);
        Pronostico pronostico2 = new Pronostico("Mariana", "1", "2", ResultadoEnum.Ganador_Equipo1, null);

        Partido partido1 = new Partido("Qatar", 0, 2, "Ecuador");
        Partido partido2 = new Partido("Senegal", 0, 2, "Paises_Bajos");

        Ronda ronda = new Ronda();
        ronda.agregarPartido(partido1);
        ronda.agregarPartido(partido2);

        // Crear una lista de Pronosticos con resultados que no coincidan con los Partidos
        List<Pronostico> listaPronosticos = new ArrayList<>();
        listaPronosticos.add(pronostico1);
        listaPronosticos.add(pronostico2);

        // Llamar al método calcularPuntaje y verificar el resultado
        ApuestaController apuestaController = new ApuestaController();
        int puntajeTotal = apuestaController.calcularPuntaje(listaPronosticos, ronda);

        // El resultado esperado es 0 porque no hay aciertos
        assertEquals(0, puntajeTotal);
    }

    @Test
    public void calcularPuntajeConAciertosTest() {
        // Crear instancias de Pronostico, Partido y Ronda para la prueba
        Pronostico pronostico1 = new Pronostico("Valeria", "1", "1", ResultadoEnum.Ganador_Equipo2, null);
        Pronostico pronostico2 = new Pronostico("Mariana", "1", "2", ResultadoEnum.Ganador_Equipo2, null);

        Partido partido1 = new Partido("Qatar", 0, 2, "Ecuador");
        Partido partido2 = new Partido("Senegal", 2, 1, "Paises_Bajos");

        Ronda ronda = new Ronda();
        ronda.agregarPartido(partido1);
        ronda.agregarPartido(partido2);

        // Crear una lista de Pronosticos con resultados que coincidan con los Partidos
        List<Pronostico> listaPronosticos = new ArrayList<>();
        listaPronosticos.add(pronostico1);
        listaPronosticos.add(pronostico2);

        // Llamar al método calcularPuntaje y verificar el resultado
        ApuestaController apuestaController = new ApuestaController();
        int puntajeTotal = apuestaController.calcularPuntaje(listaPronosticos, ronda);

        // El resultado esperado es mayor a 0 porque hay aciertos
        assertEquals(4, puntajeTotal);
    }
}
