package CineApp;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * @KevinCastillo Metodo para leer y escribir objetos de forma binaria
 */
public class FilesFunction {

    public static void WriteShows(File file, ArrayList <Functions> shows) {
        boolean eof = true;
        try {
            ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            for (Functions show : shows) {
                os.writeObject(show);
                System.out.println(show.getMovie());
            }
            os.close();
        }catch (IOException io) {
            System.out.println("Error al leer los archivos");
        }

    }

    public static void ReadShowList(File fileName) {

        Functions shows;
        try {
            ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileName));
            boolean eof = false;
            int i=0;
            while (!eof) {

                try {
                    shows = (Functions) oIS.readObject();
                    System.out.println(i++ + "->" + shows);
                } catch (IOException iOException) {
                    eof = true;
                } catch (ClassNotFoundException ex) {
                    eof = true;
                    System.out.println("El objeto leído no era del tipo esperado");
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
            while (eof) {
                try {
                    shows.add((Functions) oIS.readObject());
                }catch ( IOException iOException){
                    eof = false;
                } catch (ClassNotFoundException ex) {
                    eof = true;
                    System.out.println("El objeto leído no era del tipo esperado");
                }
            }
        } catch (IOException ex) {
        }
        for (Functions fun : shows) {
            if (movie.equalsIgnoreCase(fun.getMovie())) {
                System.out.println(fun);
            }

        }
    }
}
