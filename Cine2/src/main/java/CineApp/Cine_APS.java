
package CineApp;

import java.io.File;
import java.time.LocalDate;
import java.util.LinkedList;


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
        LinkedList<Functions> shows = new LinkedList();
        Billboard b = new Billboard(nombre,today,today,Gender.COMEDY,AgeCategory.C_18);
        Billboard c = new Billboard("Prueba",today,today,Gender.COMEDY,AgeCategory.C_18);
        Billboard d = new Billboard("Ken",today,today,Gender.COMEDY,AgeCategory.C_18);
        Functions f = new Functions(b,today, 6.50F,5,hora,min);
        Functions z = new Functions(c,today, 6.50F,7,hora,min);
        Functions h = new Functions(d,today, 6.50F,8,hora,min);
        shows.add(f);
        shows.add(z);
        shows.add(h);
        FilesFunction.WriteShows(shows);
        FilesFunction.ReadShow(file);
    }
}
