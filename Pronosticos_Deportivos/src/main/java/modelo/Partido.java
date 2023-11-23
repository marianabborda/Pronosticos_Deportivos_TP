package modelo;

import controlador.PartidoController;

public class Partido {
	private String idPartido;
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;


   public Partido(String idPartido,Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.idPartido = idPartido;
    	this.equipo1 = equipo1;
        this.equipo2 = equipo2;
       this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        
    }

    
    
    public String getIdPartido() {
        return idPartido;
    }
    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public ResultadoEnum getResultado() {
        // Utiliza un PartidoController para obtener el resultado del partido
        PartidoController partidoController = new PartidoController(this);
        return partidoController.resultado(this.getIdPartido());
    }
 
  }
