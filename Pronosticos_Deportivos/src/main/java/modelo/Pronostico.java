package modelo;
import controlador.PartidoController;


public class Pronostico {
	private String nombreApostador; 
	private String nroRonda;
    private String idPartido;
    private ResultadoEnum resultadoEnum;
    private PartidoController partidoController;
    private int puntaje; 

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
    
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }
    
    
    
    public int puntos() {    	
    	       if (partidoController != null && idPartido != null) {
    	        // Obtiene el resultado del partido
    	        ResultadoEnum resultadoPartido = partidoController.resultado(idPartido);

    	        // Verifica si resultadoEnum es null y asigna un valor predeterminado (ajusta según tus necesidades)
    	        ResultadoEnum resultadoEsperado = resultadoEnum != null ? resultadoEnum : ResultadoEnum.No_hay_resultados;

    	        // Verifica si los resultados son iguales
    	        if (resultadoPartido.equals(resultadoEsperado)) {
    	            return 1; // Puntaje por acierto
    	        }
    	    } else {
    	        // Manejar el caso en que partidoController o idPartido es null
    	        System.out.println("Error: partidoController o idPartido es null");
    	    }

    	    return 0; // Puntaje si no hay aciertos
    	}
   
}
