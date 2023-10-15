package CineApp;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Cine_APS {

    public static void main(String[] args) {
        LinkedList<Billboard> peliculas = new LinkedList<>();

        peliculas.add(new Billboard("Saló", LocalDate.now(), LocalDate.now(), Gender.ACTION, AgeCategory.C_12));
        peliculas.add(new Billboard("Irreversible", LocalDate.now(), LocalDate.now(), Gender.ACTION, AgeCategory.C_12));
    
        DOM.escribirBillboard(peliculas);
    
    }

}
