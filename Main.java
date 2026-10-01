import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Nombre del archivo de tu base de datos
        String archivoCSV = "estudiantes_consolidado_corregido.csv";
        String linea = "";
        
        // Separador del CSV (generalmente es coma, si da error de columnas, cámbialo a ";")
        String separador = ","; 
        
        // Estructura de datos: Lista para almacenar los registros
        List<Estudiante> listaEstudiantes = new ArrayList<>();

        System.out.println("Iniciando la fase EXTRACT del ETL...");

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            // 1. Leer la primera línea para omitir los encabezados (Name, Gender, Grade, etc.)
            String encabezado = br.readLine(); 
            
            // 2. Leer el archivo línea por línea hasta el final
            while ((linea = br.readLine()) != null) {
                // Dividir la línea por el separador
                String[] datos = linea.split(separador);
                
                // Verificar que la fila tenga al menos las 7 columnas para evitar errores
                if (datos.length >= 7) {
                    // Crear el objeto Estudiante con los datos extraídos (se leen como String)
                    Estudiante estudiante = new Estudiante(
                        datos[0].trim(), // Name
                        datos[1].trim(), // Gender
                        datos[2].trim(), // Grade
                        datos[3].trim(), // Math
                        datos[4].trim(), // Science
                        datos[5].trim(), // English
                        datos[6].trim()  // Total
                    );
                    
                    // Añadir el objeto a la lista
                    listaEstudiantes.add(estudiante);
                }
            }
            
            System.out.println("¡Extracción exitosa!");
            System.out.println("Total de registros cargados en la Lista: " + listaEstudiantes.size());

            // 3. Demostración funcional: Mostrar y consultar datos (Muestra los primeros 10)
            System.out.println("\n--- Muestra de los primeros 10 registros extraídos ---");
            
            // Usamos Math.min para evitar errores si la lista llega a tener menos de 10 datos
            int limite = Math.min(10, listaEstudiantes.size()); 
            for (int i = 0; i < limite; i++) {
                System.out.println((i + 1) + ". " + listaEstudiantes.get(i).toString());
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo CSV: " + e.getMessage());
            System.out.println("Verifica que el archivo 'estudiantes_consolidado_corregido.csv' esté en la carpeta principal de tu proyecto en Visual Studio Code.");
        }
    }
}