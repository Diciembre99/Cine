package CineApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerSecuencial {

    /**
     *
     * @author Alex Pineño Sanchez
     *
     * @param nombreArchivo
     */
    String nombreArchivo;
    FileReader archivoLectura;

    /**
     *
     * @author Alex Pineño Sanchez
     * 
     * @param nombreArchivo
     * @param archivoLectura
     */
    public LeerSecuencial(String nombreArchivo, FileReader archivoLectura) {
        this.nombreArchivo = nombreArchivo;
        this.archivoLectura = archivoLectura;
    }

    /**
     *@author Alex Pineño Sanchez
     */
    public void leerSecuencial() {
        try {
            this.archivoLectura = new FileReader(nombreArchivo);
            BufferedReader bufferLectura = new BufferedReader(archivoLectura);

            String linea;
            while ((linea = bufferLectura.readLine()) != null) {
                System.out.println(linea);
            }

            bufferLectura.close();
        } catch (IOException e) {
        }
    }

    /**
     *@author Alex Pineño Sanchez
     * 
     * @param nombreArchivo
     */
    public static void leerSecuencial(String nombreArchivo) {
        try {
            FileReader archivoLectura = new FileReader(nombreArchivo);
            BufferedReader bufferLectura = new BufferedReader(archivoLectura);

            String linea;
            while ((linea = bufferLectura.readLine()) != null) {
                System.out.println(linea);
            }

            bufferLectura.close();
        } catch (IOException e) {
        }

    }

    /**
     *
     * @author Alex Pineño Sanchez
     * 
     * @param nombreArchivo
     * @param archivoLectura
     */
    public static void leerSecuencial(String nombreArchivo, FileReader archivoLectura) {
        try {
            archivoLectura = new FileReader(nombreArchivo);
            BufferedReader bufferLectura = new BufferedReader(archivoLectura);

            String linea;
            while ((linea = bufferLectura.readLine()) != null) {
                System.out.println(linea);
            }

            bufferLectura.close();
        } catch (IOException e) {
        }

    }

}
