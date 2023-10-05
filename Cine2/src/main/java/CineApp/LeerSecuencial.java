package CineApp;

import static CineApp.LectorObjetos.fichLector;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerSecuencial {

    /**
     *
     * @author Alex Pineño Sanchez
     *
     * @param nombreArchivo
     */
    final static String nombreArchivo = ".\\Peliculas\\ListadoPeliculas.txt";
    FileReader archivoLectura;
    
    /**
     *@author Alex Pineño Sanchez
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
        }
    }

         /**
     * Método que lee de un fichero todos los objetos de la clase Película y 
     * busca el que coincida con el título que se pasa por parámetro, 
     * cuando lo encuentra escribe su información en consola
     * @param titulo de la Película a buscar
     * @return el objeto Película si se ha encontrado; null si no se ha encontrado 
     */
    public Functions busca(String titulo){  
        Functions p = null;
        boolean encontrado = false;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File(nombreArchivo))); 
            p = (Functions) ois.readObject();
            while (p != null && !encontrado) {
                if (p.getMovie().equals(titulo)) {
                        encontrado = true;
                } else {
                    p = (Functions)ois.readObject();
                }  
            }//Fin del while 
            if (!encontrado){
                p = null;
            }
        } catch (EOFException eofe) {
            System.out.println("Se ha recorrido todo el fichero sin encontrar la película cuyo nombre es: " + titulo);
            p = null;   
        } catch (IOException ioe) {
            System.out.println("ERROR de E/S: " + ioe.getMessage());
            p = null;
        } catch (Exception ex) {
            System.out.println("ERROR al leer datos: " + ex.getMessage());
            p = null;
        }finally{
            try{
                if (ois != null) {
                    ois.close();}
            }catch(IOException ioe){
                System.out.println("Error al cerrar el stream de lectura durante la búsqueda " + ioe.getMessage());
            } 
        }//Fin del  try
        return p;
    }//Fin de busca

}
