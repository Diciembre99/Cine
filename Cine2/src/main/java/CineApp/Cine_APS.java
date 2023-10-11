
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
        ArrayList<Functions> shows=  new ArrayList<>();
        Scanner read = new Scanner(System.in);

        LocalDate today = LocalDate.now();
        LocalDate hora = LocalDate.now();
        File file = new File(hora+".data");
        System.out.println(file);
        Billboard billboard = new Billboard("Barbie", today,today,Gender.ACTION,AgeCategory.C_18);
        Functions function = new Functions(billboard,today,5.6F,5);
        shows.add(function);
        FilesFunction.WriteShows(file,shows);
    }
}
