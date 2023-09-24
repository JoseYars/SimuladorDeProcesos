import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Entrada: Solicita información al usuario.
 * Salidas: Muestra los resultados de los procesos al final.
 * Valor de retorno: Ninguno.
 * Función: Función principal que simula los procesos de un sistema operativo.
 * Variables:
 *   - numProcesos: Número de procesos a ejecutar (int).
 *   - limiteTareasGlobal: Límite global de tareas (int).
 *   - procesos: Lista para almacenar los objetos Proceso (List<Proceso>).
 *   - scanner: Objeto Scanner para la entrada de datos (Scanner).
 * Fecha: 2023-09-21
 * Autor: Jose Ramirez
 */
public class EjecutarProcesos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de procesos: ");
        int numProcesos = scanner.nextInt();

        System.out.print("Ingrese el límite de tareas global: ");
        int limiteTareasGlobal = scanner.nextInt();

        List<Proceso> procesos = new ArrayList<>();

        for (int i = 1; i <= numProcesos; i++) {
            System.out.print("Ingrese el número de tareas para el Proceso " + i + ": ");
            int numTareasPorProceso = scanner.nextInt();

            Proceso proceso = new Proceso(i, numTareasPorProceso, limiteTareasGlobal);
            procesos.add(proceso);
        }

        for (Proceso proceso : procesos) {
            proceso.start();
        }

        for (Proceso proceso : procesos) {
            try {
                proceso.join(); // Espera a que cada proceso termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Imprimir todos los procesos al final
        System.out.println("Todos los procesos han finalizado:");
        for (Proceso proceso : procesos) {
            System.out.println(proceso.getNombreProceso());
        }

        scanner.close();
    }
}