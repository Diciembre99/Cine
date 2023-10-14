package CineApp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * @KevinCastillo Metodo para leer y escribir objetos de forma binaria
 */
public class FilesFunction {

    private static final Logger logger = LogManager.getRootLogger();

    /**
     * Metodo para crear un fichero apartir de la hora y el nombre de la pelicula
     * @param nombre Nombre de la pelicula
     * @param hour Hora de emision
     * @param min Minuto de emision
     * @Return fichero a devolver
     */
    public  static  File createFilesFunction(String nombre,int hour, int min) {
        //Fecha actual
        LocalDate today = LocalDate.now();
        String pathArch= ".\\Funciones\\"+today+"\\";
        String pathFile =".\\Funciones\\"+today+"\\"+nombre + hour + "_" + min+".txt";
        File file = new File(pathArch);
        //Creacion de la carpeta
        file.mkdirs();
        //Creacion del fichero
        file = new File(pathFile);
        logger.info("La ruta del fichero es"+ pathFile);
        return file;
    }

    /**
     * Escritura de ficheros apartir de una lista de funciones
     * @param file objeto tipo file donde guardaremos las funciones de esa fecha
     * @param shows
     */
    public static void WriteShows(File file, ArrayList <Functions> shows) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            //Recorremos la lista y la escribimos en el fichero pasado por parametro
            for (Functions show : shows) {
                os.writeObject(show);
                logger.trace("El fichero se escribio correctamente");
            }
            os.close();
        }catch (IOException io) {
            logger.error("Error al escribir los ficheros");
        }

    }

    public static void ReadShowList(File fileName) {
        logger.trace("leer los ficheros");
        Functions shows;
        try {
            ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileName));
            boolean eof = false;
            int i=0;
            while (!eof) {
                try {
                    shows = (Functions) oIS.readObject();
                    System.out.println(i++ + ". " + shows);
                } catch (IOException iOException) {
                    eof = true;
                    logger.info("Lista recorrida por completo");
                } catch (ClassNotFoundException ex) {

                    eof = true;

                }
            }
            oIS.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public static void ReadShows(File fileName, String movie) {
        boolean eof = true;
        ArrayList<Functions> shows = new ArrayList<Functions>();
        try {
            ObjectInput oIS = new ObjectInputStream(Files.newInputStream(fileName.toPath()));
            logger.trace("leer los ficheros");
            while (eof) {
                try {
                    shows.add((Functions) oIS.readObject());
                }catch ( IOException iOException){
                    logger.error("Lista leida por completo");
                    eof = false;
                } catch (ClassNotFoundException ex) {
                    eof = true;
                    logger.error("Error al leer los datos");
                }
            }
        } catch (IOException ex) {
            logger.error("Error");
        }
    }
}
