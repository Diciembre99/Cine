package CineApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex Pineño Sanchez
 */
public class EscribirSecuencial {

    final static String nombreArchivo = ".\\Peliculas\\ListadoPeliculas.txt";
    
    /**
     * @author Alex Pineño Sanchez
     * @param pelicula
     */
    public static void escribirSecuencial(Functions pelicula) {
        try {
            FileWriter archivoEscritura = new FileWriter(nombreArchivo, true);
            BufferedWriter bw = new BufferedWriter(archivoEscritura);
            bw.write(toStringPelicula(pelicula));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
        }
    }
    
        public static String toStringPelicula(Functions pelicula) {
        
        return pelicula.getMovie()+" "+pelicula.getAgeCategory()+" "+pelicula.getBegin()+" "+pelicula.getEnd()+" "+pelicula.getGender();
    }
}