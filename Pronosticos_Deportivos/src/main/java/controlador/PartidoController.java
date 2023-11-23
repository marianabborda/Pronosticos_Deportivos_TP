package controlador;


import modelo.Partido;
import modelo.ResultadoEnum;



public class PartidoController {
	
	private Partido partido;

    public PartidoController(Partido partido) {
        this.partido = partido;
    }
    
    
    
    public ResultadoEnum resultado(String idPartido) {
        // Lógica para determinar el resultado (ganadorEquipo1, ganadorEquipo2, empate)
        // Utiliza el idPartido para obtener el partido correspondiente 
    	
        if (partido.getGolesEquipo1() > partido.getGolesEquipo2()) {
            return ResultadoEnum.Ganador_Equipo1;
        } else if (partido.getGolesEquipo2() > partido.getGolesEquipo1()) {
            return ResultadoEnum.Ganador_Equipo2;
        } else if (partido.getGolesEquipo2() == partido.getGolesEquipo1()) {
            return ResultadoEnum.Empate;
        } else {
            return ResultadoEnum.No_hay_resultados;
        }
    }
}
    
    