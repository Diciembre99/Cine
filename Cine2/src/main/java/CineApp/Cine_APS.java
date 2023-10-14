
package CineApp;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Cine_APS {

    public static void main(String[] args) {
        String nombre = "barbie";
        int hora = 5, min = 20;
        File file;
        LocalDate today = LocalDate.now();
        file = FilesFunction.createFilesFunction(nombre,hora,min);
        ArrayList<Functions> shows = new ArrayList<Functions>();
        Billboard b = new Billboard(nombre,today,today,Gender.COMEDY,AgeCategory.C_18);
        Functions f = new Functions(b,today, 6.50F,5,hora,min);
        shows.add(f);
        FilesFunction.WriteShows(file,shows);
        FilesFunction.ReadShowList(file);
    }
}
