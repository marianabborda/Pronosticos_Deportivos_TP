package controlador;

import modelo.Ronda;

import java.util.ArrayList;
import java.util.List;

public class ListaRondasController {
	public static List<Ronda> obtenerListaRondas(List<String[]> valoresResultados) {
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
}

