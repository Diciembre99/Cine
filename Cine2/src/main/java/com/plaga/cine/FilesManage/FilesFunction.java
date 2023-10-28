package com.plaga.cine.FilesManage;

import com.plaga.cine.Modules.Functions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @KevinCastillo Metodo para leer y escribir objetos de forma binaria
 */
public class FilesFunction {

    private static final Logger logger = LogManager.getRootLogger();

    /**
     * Metodo para crear un fichero apartir de la hora y el nombre de la
     * pelicula
     *
     * @param nombre Nombre de la pelicula
     * @param hour Hora de emision
     * @param min Minuto de emision
     * @param fecha
     * @return 
     */
    public static File createFilesFunction(String nombre, int hour, int min, String fecha) {
        //Fecha actual
        String pathArch = ".\\Funciones\\" + fecha + "\\";
        String pathFile = ".\\Funciones\\" + fecha + "\\" +  nombre.replace(" ", "_") + hour + "_" + min + ".txt";
        File file = new File(pathArch);
        //Creacion de la carpeta
        file.mkdirs();
        //Creacion del fichero
        file = new File(pathFile);
        logger.info("La ruta del fichero es" + pathFile);
        return file;
    }

    /**
     * Escritura de ficheros apartir de una lista de funciones
     *
     * @param file objeto tipo file donde guardaremos las funciones de esa fecha
     * @param show
     */
    public static void WriteShow(File file, Functions show) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            //Recorremos la lista y la escribimos en el fichero pasado por parametro

            os.writeObject(show);
            logger.trace("El fichero se escribio correctamente");

            os.close();
        } catch (IOException io) {
            logger.error("Error al escribir los ficheros");
        }

    }

    /**
     * @JoseVicenteVargasMestanza
     * @param shows 
     */
    public static void WriteShows(LinkedList<Functions> shows) {
        File file;
        for (Functions show : shows) {
            file = createFilesFunction(show.getBillboard().getMovie(), show.getHour(), show.getMin(), show.getDate().toString());
            if (!file.exists()) {
                WriteShow(file, show);
            }
        }

    }

    public static Functions ReadShow(File fileName) {
        logger.trace("leer los ficheros");
        Functions show = null;
        try {
            ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileName));
            boolean eof = false;
            while (!eof) {
                try {
                    show = (Functions) oIS.readObject();
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
        return show;
    }

    public static void ReadShows(File fileName, String movie) {
        boolean eof = true;
        ArrayList<Functions> shows = new ArrayList();
        try {
            ObjectInput oIS = new ObjectInputStream(Files.newInputStream(fileName.toPath()));
            logger.trace("leer los ficheros");
            while (eof) {
                try {
                    shows.add((Functions) oIS.readObject());
                } catch (IOException iOException) {
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
