package CineApp;

import java.io.File;

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
