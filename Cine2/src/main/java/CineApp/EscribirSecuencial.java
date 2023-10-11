package CineApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
     */
    public static void escribirSecuencial(Billboard pelicula) {
        try {
            FileWriter archivoEscritura = new FileWriter(nombreArchivo, true);
            BufferedWriter bw = new BufferedWriter(archivoEscritura);
            bw.write(toStringPelicula(pelicula));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            logger.error("Se ha priducido un error en la escritura");
        }
    }
    
        public static String toStringPelicula(Billboard pelicula) {
        
            return pelicula.getPelicula()+" "+pelicula.getPegi()+" "+pelicula.getInicio()+" "+pelicula.getFinalizacion()+" "+pelicula.getGenero();
    }
}