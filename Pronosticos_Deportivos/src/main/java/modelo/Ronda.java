package modelo;

import java.util.List;

public class Ronda {
    private String nroRonda;
    private List<Partido> partidos; //  lista para almacenar múltiples partidos en una ronda

    public Ronda(String nroRonda, List<Partido> partidos) {
        this.nroRonda = nroRonda;
        this.partidos = partidos;
    }

    public Ronda() {
		// TODO Auto-generated constructor stub
	}

	public String getNroRonda() {
        return nroRonda;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

	public void agregarPartido(Partido partido1) {
		// TODO Auto-generated method stub
		
	}

    
}