package inicio;

import controlador.PrincipalPI;
import controlador.ApuestaController;
//import controlador.ResultadosTotales;
import controlador.PuntajeApostadoresController;
import controlador.ListaPartidosController;
import controlador.ListaPronosticosController;
import controlador.ListaRondasController;
import modelo.Partido;
import modelo.Pronostico;
import modelo.Ronda;



import java.util.List;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {			
		
		        PrincipalPI conector = new PrincipalPI();

		        // Leer datos de resultados y pronósticos
		        List<String[]> valoresResultados = conector.conectar();
		        List<String[]> valoresPronosticos = conector.conectarr();

		        // Crear lista de partidos, pronósticos y rondas
		        List<Partido> listaPartidos = ListaPartidosController.obtenerListaPartidos(valoresResultados);
		     
		        List<Pronostico> listaApuestas = ListaPronosticosController.obtenerListaPronosticos(valoresPronosticos, listaPartidos);
		        List<Ronda> listaRondas = ListaRondasController.obtenerListaRondas(valoresResultados);	  
		         
		        // Crear una única instancia de ApuestaController
		        ApuestaController apuestaController = new ApuestaController();

		       
		       // Calcular puntajes para cada apostador
		        PuntajeApostadoresController.calcularPuntajesApostadoresEnTodasLasRondas(listaApuestas, listaRondas, apuestaController);

		        // Imprimir los resultados por pantalla
		       // ResultadosTotales.imprimirResultadosTotales(listaApuestas);
		        
		        // Crear la ventana de resultados y mostrarla
		        SwingUtilities.invokeLater(() -> {
		            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(listaApuestas);
		            ventanaPrincipal.setVisible(true);
		        });
		    }
		}
		  
	

	
	