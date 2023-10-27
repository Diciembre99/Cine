package CineApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Alex Pineño Sanchez
 */
public class EscribirSecuencial {

    private static final Logger logger = LogManager.getRootLogger();
    final static String nombreArchivo = ".\\Peliculas\\ListadoPeliculas.txt";
    
    /**
     * @author Alex Pineño Sanchez
     * @param pelicula
     * @param eliminar
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