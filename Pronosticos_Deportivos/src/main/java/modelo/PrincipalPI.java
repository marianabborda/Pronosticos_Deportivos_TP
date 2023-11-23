package modelo;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PrincipalPI {

    public static List<String[]> leerArchivoCSV(String rutaArchivo) {
        List<String[]> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabra = linea.split(";");
                result.add(palabra);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public  List<String[]> conectar() {
        String archivo = "src/main/resources/Resultados.csv";
        List<String[]> valores = PrincipalPI.leerArchivoCSV(archivo);
        return valores;
    }
    public  List<String[]> conectarr() {
        String archivo = "src/main/resources/Pronosticos.csv";
        List<String[]> valoresr = PrincipalPI.leerArchivoCSV(archivo);
        return valoresr;
    }
	
}

