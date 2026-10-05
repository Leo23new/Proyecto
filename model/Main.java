
import etl.LectorCsv;
import model.Estudiante;
import Estructuras.ListaEnlazada;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        String archivoCSV = "estudiantes_consolidado_corregido.csv";
        
        System.out.println("Iniciando la fase EXTRACT y TRANSFORM ");
        
        
        ListaEnlazada<Estudiante> listaEstudiantes = LectorCsv.extraerYLimpiarDatos(archivoCSV);
        
        System.out.println("¡Operación exitosa! Registros cargados en la Lista Enlazada: " + listaEstudiantes.size());
        
        // Inicializar el menu
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ETL ===");
            System.out.println("1. Mostrar un número especifico de registros");
            System.out.println("2. Consultar estudiante por nombre");
            System.out.println("3. Ver total de registros en memoria");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");
            
            
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1:
                        System.out.print("\n¿Cuantos registros deseas visualizar?: ");
                        if (scanner.hasNextInt()) {
                            int cantidad = scanner.nextInt();
                            scanner.nextLine(); 
                            
                            System.out.println("\n--- Mostrando los primeros " + cantidad + " registros ---");
                            int limite = Math.min(cantidad, listaEstudiantes.size());
                            for (int i = 0; i < limite; i++) {
                                System.out.println((i + 1) + ". " + listaEstudiantes.get(i).toString());
                            }
                        } else {
                            System.out.println("Entrada invalida. Debes ingresar un numero entero.");
                            scanner.next(); 
                        }
                        break;
                        
                    case 2:
                        System.out.print("\nIngresa el nombre o parte del nombre a buscar: ");
                        String nombreBuscar = scanner.nextLine().toLowerCase();
                        boolean encontrado = false;
                        
                        System.out.println("\n--- Resultados de la búsqueda ---");

                        // Recorremos la Lista Enlazada buscando coincidencias
                        for (int i = 0; i < listaEstudiantes.size(); i++) {
                            Estudiante est = listaEstudiantes.get(i);
                            if (est.getName().toLowerCase().contains(nombreBuscar)) {
                                System.out.println("Posición [" + (i + 1) + "] -> " + est.toString());
                                encontrado = true;
                            }
                        }
                        
                        if (!encontrado) {
                            System.out.println("No se encontro ningun estudiante con ese nombre en la base de datos.");
                        }
                        break;
                        
                    case 3:
                        System.out.println("\nTotal de estudiantes procesados y almacenados: " + listaEstudiantes.size());
                        break;
                        
                    case 4:
                        System.out.println("\nFinalizando el sistema");
                        break;
                        
                    default:
                        System.out.println("\nOpcion no valida");
                }
            } else {
                System.out.println("\nError: Por favor ingresa un numero valido.");
                scanner.next(); 
            }
            
        } while (opcion != 4);
        
        scanner.close();
    }
}               