package CineApp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * @KevinCastillo Metodo para leer y escribir objetos de forma binaria
 */
public class FilesFunction {

    private static final Logger logger = LogManager.getRootLogger();
    public static void WriteShows(File file, ArrayList <Functions> shows) {

        boolean eof = true;
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
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
        logger.trace("leer los ficheros");
        ArrayList<Functions> shows = new ArrayList<Functions>();
        try {
            ObjectInput oIS = new ObjectInputStream(Files.newInputStream(fileName.toPath()));
            logger.trace("leer los ficheros");
            while (eof) {
                try {
                    shows.add((Functions) oIS.readObject());
                }catch ( IOException iOException){
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
