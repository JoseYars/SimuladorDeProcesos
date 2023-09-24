/**
 * Entrada: Ninguna.
 * Salidas: Muestra los resultados de las tareas de cada proceso.
 * Valor de retorno: Ninguno.
 * Función: Clase que representa un proceso y sus tareas.
 * Variables:
 *   - numeroProceso: Número de proceso (int).
 *   - numeroTareasPorProceso: Número de tareas por proceso (int).
 *   - limiteTareasGlobal: Límite global de tareas (int).
 * Fecha: 2023-09-21
 * Autor: Jose Ramirez
 */
class Proceso extends Thread {
    private int numeroProceso;
    private int numeroTareasPorProceso;
    private int limiteTareasGlobal;

    /**
     * Constructor para crear un proceso con un número específico de tareas y un límite global.
     * @param numeroProceso Número de proceso.
     * @param numeroTareasPorProceso Número de tareas por proceso.
     * @param limiteTareasGlobal Límite global de tareas.
     */
    public Proceso(int numeroProceso, int numeroTareasPorProceso, int limiteTareasGlobal) {
        this.numeroProceso = numeroProceso;
        this.numeroTareasPorProceso = numeroTareasPorProceso;
        this.limiteTareasGlobal = limiteTareasGlobal;
    }

    @Override
    public void run() {
        for (int tarea = 1; tarea <= numeroTareasPorProceso; tarea++) {
            System.out.println(getNombreProceso() + ", Tarea " + tarea);

            if (tarea % limiteTareasGlobal == 0) {
                System.out.println("Límite de tareas alcanzado. Pausa en el proceso " + getNombreProceso());
                try {
                    Thread.sleep(1000); // Pausa el proceso durante 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Obtiene el nombre del proceso.
     * @return Nombre del proceso.
     */
    public String getNombreProceso() {
        return "Proceso " + numeroProceso;
    }
}