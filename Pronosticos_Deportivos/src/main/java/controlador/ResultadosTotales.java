package controlador;
import modelo.Pronostico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class ResultadosTotales {
	public static void imprimirResultadosTotales(List<Pronostico> listaApuestas) {
        Map<String, Integer> puntajesTotales = new HashMap<>();
        Map<String, Integer> aciertosTotales = new HashMap<>();

        for (Pronostico pronostico : listaApuestas) {
            String nombreApostador = pronostico.getNombreApostador();
            int puntajeTotal = pronostico.getPuntajeTotal();

            puntajesTotales.put(nombreApostador, puntajesTotales.getOrDefault(nombreApostador, 0) + puntajeTotal);

            if (puntajeTotal > 0) {
                aciertosTotales.put(nombreApostador, aciertosTotales.getOrDefault(nombreApostador, 0) + 1);
            }
        }

        // Crear una lista de Map.Entry para ordenar los resultados
        List<Map.Entry<String, Integer>> resultList = new ArrayList<>(puntajesTotales.entrySet());

        // Ordenar la lista en orden descendente por puntajeTotal
        resultList.sort(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)));

        // Imprimir los resultados totales ordenados por puntajeTotal
        for (Map.Entry<String, Integer> entry : resultList) {
            String nombreApostador = entry.getKey();
            int puntajeTotal = entry.getValue();
            int aciertos = aciertosTotales.getOrDefault(nombreApostador, 0);

            System.out.println("Apostador: " + nombreApostador + ", Puntaje Total: " + puntajeTotal
                    + ", Aciertos Totales: " + aciertos);
        }
    }
}

