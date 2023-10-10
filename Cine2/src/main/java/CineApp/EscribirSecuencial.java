package CineApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
    public static void escribirSecuencialBillboard(Billboard pelicula) {
        
        if (!LeerSecuencial.buscarPelicula(pelicula.getPelicula())) {
        try {
            FileWriter archivoEscritura = new FileWriter(nombreArchivo, true);
            BufferedWriter bw = new BufferedWriter(archivoEscritura);
            bw.write(toStringBillboard(pelicula));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
        }
    }
    }
    
        public static String toStringBillboard(Billboard pelicula) {
        
         return pelicula.getPelicula()+" "+pelicula.getPegi()+" "+pelicula.getInicio()+" "+pelicula.getFinalizacion()+" "+pelicula.getGenero();
    }
        

        
        
}