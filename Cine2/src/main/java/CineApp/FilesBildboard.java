package CineApp;

import java.io.*;

/**
 * @KevinCastillo
 * Metodo para leer y escribir objetos de forma binaria
 */
public class FilesBildboard {

    public void WriteBildboard(String fileName, Functions cartelera) {
        try {
            File f = new File(fileName);
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f));
            os.writeObject(cartelera);
        } catch (Exception e) {
        }
    }

    public void ReadBildboardList(String fileName, Functions cartelera) {
        boolean eof = false;
        Billboard bildboard;
        try {
            File f = new File(fileName);
            ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(f));
            while (!eof) {
                bildboard = (Billboard) oIS.readObject();
            }
        } catch (IOException iOException) {
            eof = true;
        } catch (ClassNotFoundException ex){
            eof = true;
        }


    }
}
