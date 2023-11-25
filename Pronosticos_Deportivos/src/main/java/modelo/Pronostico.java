package modelo;
import controlador.PartidoController;
import java.util.Objects;




public class Pronostico {
	private String nombreApostador; 
	private String nroRonda;
    private String idPartido;
    private ResultadoEnum resultadoEnum;
    private PartidoController partidoController;
    private int puntajeTotal; 

    public Pronostico(String nombreApostador, String nroRonda, String idPartido, ResultadoEnum resultadoEnum, PartidoController partidoController) {
    	this.nombreApostador = nombreApostador;
    	this.nroRonda = nroRonda;
    	this.idPartido = idPartido;
        this.resultadoEnum = resultadoEnum;
        this.partidoController = partidoController;   
    }

    
    public String  getNroRonda() {
        return nroRonda;
    }
    
  
    public String  getNombreApostador() {
        return nombreApostador;
    }
    
    public String  getIdPartido() {
        return idPartido;
    }
   
 
    public ResultadoEnum getResultadoEnum() {
    	return resultadoEnum;
    }
      
    
    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }
    
    
    public int puntos(Ronda ronda) {
        if (Objects.nonNull(partidoController) && Objects.nonNull(idPartido) && Objects.nonNull(ronda)) {
            // Obtiene el resultado del partido
            ResultadoEnum resultadoPartido = partidoController.resultado(idPartido);

            // Verifica si resultadoEnum es null y asigna un valor predeterminado (ajusta según tus necesidades)
            ResultadoEnum resultadoEsperado = resultadoEnum != null ? resultadoEnum : ResultadoEnum.No_hay_resultados;

            // Verifica si los resultados son iguales y la ronda es la correcta
            if (resultadoPartido.equals(resultadoEsperado) && ronda.getNroRonda().equals(nroRonda)) {
                return 1; // Puntaje por acierto
            }
        } else {
            
            System.out.println("Error: partidoController, idPartido o ronda es null");
        }

        return 0; // Puntaje si no hay aciertos
    }
}
    
    
    
    
    
    
    
    
    
   