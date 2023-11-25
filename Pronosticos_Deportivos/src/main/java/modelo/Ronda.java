package modelo;

import java.util.List;

public class Ronda {
    private String nroRonda;
    private List<Partido> partidos; //  lista para almacenar múltiples partidos en una ronda

    public Ronda(String nroRonda, List<Partido> partidos) {
        this.nroRonda = nroRonda;
        this.partidos = partidos;
    }

    public String getNroRonda() {
        return nroRonda;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    
}