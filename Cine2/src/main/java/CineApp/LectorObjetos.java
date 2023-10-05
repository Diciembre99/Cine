package CineApp;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Alex Pineño Sanchez
 */
public class LectorObjetos {
    
    
       final static File fichLector = new File(".\\Peliculas\\ListadoPeliculas.txt");
    
    //Constructores    
    public LectorObjetos (){       
    }


    
    // get & set
    public File getFichLector() {
        return fichLector;
    }
   


}
