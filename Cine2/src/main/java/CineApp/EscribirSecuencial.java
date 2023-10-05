package CineApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Alex Pineño Sanchez
 */
public class EscribirSecuencial {

    String nombreArchivo;
    FileWriter archivo;

    public EscribirSecuencial(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * @author Alex Pineño Sanchez
     * 
     * @param nombreArchivo
     * @param escribir
     * @param append
     */
public static void escribirSecuencial(String nombreArchivo, String escribir, boolean append) {
    try {
        FileWriter archivoEscritura = new FileWriter(nombreArchivo, append);
        BufferedWriter bufferEscritura = new BufferedWriter(archivoEscritura);
        bufferEscritura.write(escribir);
        bufferEscritura.newLine(); // Agregar un salto de línea

        bufferEscritura.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    /**
     * @author Alex Pineño Sanchez
     * 
     * @param escribir
     */
    public void escribirSecuencial(String escribir) {
        try {
            this.archivo = new FileWriter(nombreArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(this.archivo);

            bufferEscritura.write(escribir);
            bufferEscritura.newLine(); // Agregar un salto de línea

            bufferEscritura.close();
        } catch (IOException e) {
        }

    }

}
