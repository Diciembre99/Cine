package CineApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase que escribira en modo secuencial
 * 
 * @author Alex Pineño Sanchez
 */
public class EscribirSecuencial {

    private static final Logger logger = LogManager.getRootLogger(); // Logger a utilizar
    final static String nombreArchivo = ".\\Peliculas\\ListadoPeliculas.txt"; // Ruta definitva del archivo de texto
    
    /**
     * @author Alex Pineño Sanchez
     * @param pelicula Objeto Billboard a escrbir
     * @param eliminar Boolean que indicara si sobreescribir el contenido o agregarlo
     */
    
     public static void escribirSecuencial(Billboard pelicula, boolean eliminar) {
        try {
            FileWriter archivoEscritura = new FileWriter(nombreArchivo, eliminar);
            BufferedWriter bw = new BufferedWriter(archivoEscritura);
            bw.write(toStringPelicula(pelicula));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            logger.error("Se ha priducido un error en la escritura");
        }
    }
  
    
    /**
     * @author Jose Vicente Vargas Mestanza
     * @param peliculas
     */
    public static void escribirSecuencialLista(LinkedList<Billboard> peliculas){
        boolean primeraVez = false;
        for (Billboard pelicula : peliculas){
            escribirSecuencial(pelicula,primeraVez);
            if(!primeraVez){
                primeraVez = true;
            }
        }
    }
    

    
        public static String toStringPelicula(Billboard pelicula) {
            return pelicula.getPelicula()+"*"+pelicula.getInicio()+"*"+pelicula.getFinalizacion()+"*"+pelicula.getGenero()+"*"+pelicula.getPegi()+"*";
    }
}