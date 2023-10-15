
package CineApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
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
     * @author Alex Pineño Sanchez
     */
    public static void leerSecuencial() {
        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader bufferLectura = new BufferedReader(fr);

            String linea;
            while ((linea = bufferLectura.readLine()) != null) {
                System.out.println(linea);
            }

            bufferLectura.close();
        } catch (IOException e) {
            logger.error("Se producio un error en la lectura");
        }
    }

    /**
     *
     * Funcion que pasa de texto plano a una LinkedList de objetos tipo Billboard
     * 
     * @author Alex Pineño Sanchez
     * 
     */
    
    public static LinkedList<Billboard> leerSecuencialObjetos() {
        
        LinkedList<Billboard> lista = new LinkedList <>();

        try {

            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\*");

                LocalDate fecha1 = LocalDate.parse(partes[1], formato);
                LocalDate fecha2 = LocalDate.parse(partes[2], formato);

                Gender g = Gender.valueOf(partes[3]);
                AgeCategory a = AgeCategory.valueOf(partes[4]);

                Billboard pelicula = new Billboard(partes[0], fecha1, fecha2, g, a);

                lista.add(pelicula);
            }

            br.close();
        } catch (IOException e) {
            logger.error("Se producio un error en la lectura");
        }

        return lista;
    }

    public static String leerBillboardPorCriterio(String nombre, String atributo) {

        String resultado = "No se encuentra";
        atributo = atributo.toUpperCase();

        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\*");

                if (partes.length >= 5) {
                    String nombrePelicula = partes[0];

                    if (nombrePelicula.equals(nombre)) {
                        switch (atributo) {
                            case "PEGI":
                                resultado = partes[1];
                                break;
                            case "INICIO":
                                resultado = partes[2];
                                break;
                            case "FINAL":
                                resultado = partes[3];
                                break;
                            case "GENERO":
                                resultado = partes[4];
                                break;
                            default:
                                resultado = "Atributo no válido";
                        }
                    }
                }
            }

            br.close();
        } catch (IOException e) {
            logger.error("Hubo un problema en la rectura");
        }

        return resultado;
    }

    public static boolean buscarPelicula(String nombre) {

        boolean retorno = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String pelicula;

            while ((pelicula = br.readLine()) != null) {
                String partes[] = pelicula.split("\\*");

                if (partes[0].equals(nombre)) {
                    return true;
                }

            }

        } catch (FileNotFoundException ex) {
            logger.error("Archivo de lectura no encontrado");
        } catch (IOException ex) {
            logger.error("Hubo un problema en la rectura");
        }

        return retorno;

    }
}
