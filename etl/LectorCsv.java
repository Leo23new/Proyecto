package etl;

import model.Estudiante;
import Estructuras.ListaEnlazada;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorCsv {
    
    public static ListaEnlazada<Estudiante> extraerYLimpiarDatos(String rutaArchivo) {
        ListaEnlazada<Estudiante> lista = new ListaEnlazada<>();
        String linea;
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            br.readLine();
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                
                if (datos.length >= 7) {
                    
                    String nombre = datos[0].replaceAll("[\"']", "").trim();
                    
                    String genero = datos[1].trim().toLowerCase();
                    String generoLimpio = (genero.equals("m") || genero.equals("male") || genero.equals("0")) ? "M" : 
                                          (genero.equals("f") || genero.equals("female") || genero.equals("1")) ? "F" : "Desc";
                    
                    String grado = datos[2].toLowerCase().replace("grade", "").trim();
                    if (grado.startsWith("0") && grado.length() > 1) {
                        grado = grado.substring(1); 
                    }
                    
                    String math = datos[3].toLowerCase().replace("marks", "").trim();
                    String science = datos[4].toLowerCase().replace("marks", "").trim();
                    String english = datos[5].toLowerCase().replace("marks", "").trim();
                    String total = datos[6].trim();

                                                                                                       
                    Estudiante est = new Estudiante(nombre, generoLimpio, grado, math, science, english, total);
                    lista.add(est);
                }
            }
        } catch (IOException e) {
            System.out.println("Error en la lectura del CSV: " + e.getMessage());
        }
        return lista;
    }
}