package modelo;

import java.util.List;

public class Ronda {
    private String nro;
    private List<Partido> partidos; //  lista para almacenar múltiples partidos en una ronda

    public Ronda(String nro, List<Partido> partidos) {
        this.nro = nro;
        this.partidos = partidos;
    }

    public String getNro() {
        return nro;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    
}