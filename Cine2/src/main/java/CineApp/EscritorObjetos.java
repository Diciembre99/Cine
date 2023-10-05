package CineApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Alex Pineño Sanchez
 */
public class EscritorObjetos {

    File fichEscritor;

    //Constructores
    public EscritorObjetos() {
    }

    public EscritorObjetos(File fichEscritor) {
        this.fichEscritor = fichEscritor;
    }

    // get & set
    public File getFichEscritor() {
        return fichEscritor;
    }

    public void setFichEscritor(File fichEscritor) {
        this.fichEscritor = fichEscritor;
    }

    /**
     * Método que escribe un objeto Película en un fichero
     *
     * @param p objeto Pelicula a escribir en el fichero
     */
    
    public void escribirObjeto(Object p) {
        ObjectOutputStream oos = null;
        try {
            if (fichEscritor.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(fichEscritor, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(fichEscritor, true));
            }
            oos.writeObject(p);
            oos.flush();
        } catch (IOException ioe) {
            System.out.print("ERROR de E/S en la escritura " + ioe.getMessage());
        } catch (Exception e) {
            System.out.print("Se ha producido una EXCEPCIÓN en la escritura " + e.getMessage());
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("No se puedo cerrar el stream en la escritura" + e.getMessage());
                }
            }
        }
    }
}
