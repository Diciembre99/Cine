package CineApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    public static void escribirSecuencial(Billboard pelicula) {
        try {
            FileWriter archivoEscritura = new FileWriter(nombreArchivo, true);
            BufferedWriter bw = new BufferedWriter(archivoEscritura);
            bw.write(toStringPelicula(pelicula));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
        }
    }
    
        public static String toStringPelicula(Billboard pelicula) {
        
            return " ";
        //return pelicula.getMovie()+" "+pelicula.getAgeCategory()+" "+pelicula.getBegin()+" "+pelicula.getEnd()+" "+pelicula.getGender();
    }
}