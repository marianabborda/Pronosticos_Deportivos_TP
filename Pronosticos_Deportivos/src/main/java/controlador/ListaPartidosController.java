package controlador;

import modelo.Equipo;
import modelo.Partido;

import java.util.ArrayList;
import java.util.List;

public class ListaPartidosController {
	 public static List<Partido> obtenerListaPartidos(List<String[]> valoresResultados) {
	        List<Partido> listaPartidos = new ArrayList<>();

	        for (int i = 1; i < valoresResultados.size(); i++) {
	            String[] line = valoresResultados.get(i);
	            Partido partido = new Partido(line[0], line[1], new Equipo(line[2]), new Equipo(line[5]),
	                    Integer.parseInt(line[3]), Integer.parseInt(line[4]));
	            listaPartidos.add(partido);
	        }

	        return listaPartidos;
	    }
	}

