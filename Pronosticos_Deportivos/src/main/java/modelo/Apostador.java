package modelo;

import java.util.List;
import controlador.ApuestaController;


public class Apostador {

	private String nombre;
	private List<Pronostico> pronostico;
	 private ApuestaController apuestaController;
	
	
	public Apostador(String nombre, String apellido, List<Pronostico> pronostico, ApuestaController apuestaController){
		this.nombre = nombre;
        this.pronostico = pronostico;
        this.apuestaController = apuestaController;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

		
	public List<Pronostico> getPronostico(){
		return this.pronostico;
	}
	
	public int calcularPuntajeTotal(Ronda ronda) {
       
        return apuestaController.calcularPuntaje(pronostico, ronda);
    }
	
}
