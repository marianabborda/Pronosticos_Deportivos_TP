package controlador;

import modelo.Partido;
import modelo.Pronostico;
import modelo.ResultadoEnum;

import java.util.List;
import java.util.stream.Collectors;

public class ListaPronosticosController {	
	    public static List<Pronostico> obtenerListaPronosticos(List<String[]> valoresPronosticos,	                                                           List<Partido> listaPartidos) {
	        return valoresPronosticos.stream()
	                .skip(1) // Para omitir la primera fila (encabezado)
	                .map(line -> {
	                    String nombreApostador = line[0];
	                    String nroRonda = line[1];
	                    String idPartido = line[2];
	                    ResultadoEnum resultadoEnum = ResultadoEnum.valueOf(line[3]);

	                    Partido partido = listaPartidos.stream()
	                            .filter(p -> p.getNroRonda().equals(nroRonda) && p.getIdPartido().equals(idPartido))
	                            .findFirst()
	                            .orElse(null);

	                    return (partido != null) ?
	                            new Pronostico(nombreApostador, nroRonda, idPartido, resultadoEnum, new PartidoController(partido)) :
	                            null;
	                })
	                .filter(pronostico -> pronostico != null)
	                .collect(Collectors.toList());
	    }
	}
