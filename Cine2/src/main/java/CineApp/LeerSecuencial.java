package CineApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.regex.Matcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeerSecuencial {

    /**
     *
     * @author Alex Pineño Sanchez
     *
     * @param nombreArchivo
     */
    final static String nombreArchivo = ".\\Peliculas\\ListadoPeliculas.txt";
    private static final Logger logger = LogManager.getRootLogger();

    /**
     * Lee de forma secuencial los datos de películas almacenados en un archivo
     * y devuelve una lista de objetos Billboard.
     *
     * @return Una lista de objetos Billboard con los datos de las películas.
     *
     * @author Alex Pineño Sanchez, Jose Vicente Vargas Mestanza
     */
    public static LinkedList<Billboard> leerSecuencial() {
        String[] datosPeliculas;
        Matcher matcher;
        LinkedList<Billboard> billboard = new LinkedList();
        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader bufferLectura = new BufferedReader(fr);

            String linea;
            while ((linea = bufferLectura.readLine()) != null) {
                datosPeliculas = linea.split("\\*");
                billboard.add(new Billboard(datosPeliculas[0], LocalDate.parse(datosPeliculas[1]), LocalDate.parse(datosPeliculas[2]), Gender.valueOf(datosPeliculas[3]), AgeCategory.valueOf(datosPeliculas[4])));
            }

            bufferLectura.close();
        } catch (IOException e) {
            logger.error("Se producio un error en la lectura");
        }

        return billboard;
    }
}
